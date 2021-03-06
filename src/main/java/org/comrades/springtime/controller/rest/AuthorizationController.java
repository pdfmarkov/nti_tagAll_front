package org.comrades.springtime.controller.rest;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Role;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.AuthenticationRequestDto;
import org.comrades.springtime.module.requested.ParamDto;
import org.comrades.springtime.security.jwt.TokenHandler;
import org.comrades.springtime.servise.EmailService;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.NonUniqueResultException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "https://pdfmarkov.github.io")
@RestController
@RequestMapping("/api/aunt/**")
public class AuthorizationController {

    private final AuthenticationManager authenticationManager;
    private final TokenHandler jwtTokenProvider;
    private final UserService userService;
    private final EmailService emailService;
    private final Code codeGenerator;

    @Autowired
    public AuthorizationController(AuthenticationManager authenticationManager, TokenHandler jwtTokenProvider, UserService userService, EmailService emailService, Code codeGenerator) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.emailService = emailService;
        this.codeGenerator = codeGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            String username = authenticationRequestDto.getLogin();
            String password = authenticationRequestDto.getPassword();
            String code = authenticationRequestDto.getCode();

            if (codeGenerator.checkCode(username, code)) {
                User user = new User(username, password);
                user.addRole(Role.ROLE_USER);


                String refreshToken = jwtTokenProvider.generateRefreshToken(user);
                user.setRefreshToken(refreshToken);

                String accessToken = jwtTokenProvider.generateAccessToken(user);

                userService.saveUser(user);

                Authentication auth = jwtTokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("я срабатываю");
                response.put("refreshToken", refreshToken);
                response.put("accessToken", accessToken);

                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else
            {
                response.put("description","Неверный код подтверждения");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }



        }catch (IncorrectResultSizeDataAccessException | NonUniqueResultException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity confirm(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            String username = authenticationRequestDto.getLogin();
            String password = authenticationRequestDto.getPassword();

            if (username == null || password == null) {
                throw new NonUniqueResultException("Username or password should not be empty");
            }

            try {
                userService.findByUsername(username);
                throw new NonUniqueResultException("Username is already in use.");
            }catch (UserNotFoundException ex) {}

            codeGenerator.generateCode(username);

            try {
                emailService.sendSimpleMessage(username,"Подтверждение почты. Умный склад", "Ваш пароль для входа: "+ codeGenerator.getCode(username));
            } catch (Exception e){
               throw new NonUniqueResultException("Произошла ошибка при отправке письма");
            }

            response.put("email", true);
            return ResponseEntity.ok(response);

        }catch (IncorrectResultSizeDataAccessException | NonUniqueResultException ex) {
            response.put("description", ex.getMessage());

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }

    @PostMapping("/updatefirstname")
    public ResponseEntity updateFirstName(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();

        System.out.println("Я СРАБАТЫВАЮ И ХОЧУ ОБНОВИТЬ");

        try {
            System.out.println(paramDto);
            System.out.println(paramDto.getLogin());
            System.out.println(paramDto.getFirstname());
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateFirstName(user,paramDto.getFirstname());
            response.put("firstname", userService.findByUsername(paramDto.getLogin()).getFirstname());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Я ОБНОВИЛ");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign_in")
    public ResponseEntity signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            String username = authenticationRequestDto.getLogin();

            User user = userService.findByUsername(username);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, authenticationRequestDto.getPassword()));

            String accessToken = jwtTokenProvider.generateAccessToken(user);

            response.put("refreshToken", user.getRefreshToken());
            response.put("accessToken", accessToken);

            return ResponseEntity.ok(response);
        }catch (UserNotFoundException | AuthenticationException ex) {
            if (ex instanceof UserNotFoundException) response.put("description", ex.getMessage());
            else response.put("description", "Wrong login or password.");

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }

}
