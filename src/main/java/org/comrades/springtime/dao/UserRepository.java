package org.comrades.springtime.dao;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String login) throws UserNotFoundException;
    User findUserByUID(Long id) throws UserNotFoundException;
    User findUserByRefreshToken(String refreshToken) throws UserNotFoundException;


    @Modifying
    @Query("update User u set u.firstname = :firstname where u.UID = :UID")
    void updateUserFirstName(@Param(value = "UID") long UID, @Param(value = "firstname") String firstname);

}
