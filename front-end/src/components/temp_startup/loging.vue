<template>
  <div id="loging">
      <div id="login-form">
      <fieldset>
        <label id="main_title"> {{ typeOfPage === 'auth' ? 'ВХОД' : typeOfPage === 'reg' ? 'РЕГИСТРАЦИЯ' : 'ВВЕДИТЕ КОД ПОДТВЕРЖДЕНИЯ'}} </label>

        <input type="email" placeholder="ПОЧТА" title="почта" v-model="user.login" required="true" autocomplete="username" v-if="typeOfPage === 'reg' || typeOfPage === 'auth'">
        <br v-if="typeOfPage === 'reg' || typeOfPage === 'auth'"/>
        <input type="password" placeholder="ПАРОЛЬ" title="пароль" v-model="user.password" required="true" autocomplete="current-password" v-if="typeOfPage === 'reg' || typeOfPage === 'auth'">

        <input type="text" placeholder="ВАШ КОД" title="код" required="true" autocomplete="code" v-if="typeOfPage === 'confirm'">

        <br/>

        <a @click="" class="trouble_link" v-if="typeOfPage === 'auth'"> ЗАБЫЛИ ПАРОЛЬ? </a>
        <br v-if="typeOfPage === 'auth'"/>
        <a @click="" class="trouble_link" v-if="typeOfPage === 'auth'"> РЕГИСТРАЦИЯ </a>

        <a class="trouble_link" v-if="typeOfPage === 'reg' || typeOfPage === 'confirm'"> ВЕРНУТЬСЯ КО ВХОДУ </a>

        <button @click="signup" title="Кнопка для входа в существующий аккаунт" class="btn">
          <svg id="arrow" width="59" height="24" viewBox="0 0 59 24" fill="black" xmlns="http://www.w3.org/2000/svg">
            <path d="M58.0607 13.0607C58.6464 12.4749 58.6464 11.5251 58.0607 10.9393L48.5147 1.3934C47.9289 0.807611 46.9792 0.807611 46.3934 1.3934C45.8076 1.97919 45.8076 2.92893 46.3934 3.51472L54.8787 12L46.3934 20.4853C45.8076 21.0711 45.8076 22.0208 46.3934 22.6066C46.9792 23.1924 47.9289 23.1924 48.5147 22.6066L58.0607 13.0607ZM0 13.5H57V10.5H0V13.5Z"/>
          </svg>
        </button>

      </fieldset>
    </div>
  </div>
</template>

<script>
  const baseURL = 'http://localhost:41143/';
  export default {
    name: 'loging',
    props: ['access', 'refresh','typeOfPage'],
    data: function() {
      return { 
        user: {
          login: '',
          password: '',
        },
        queries: {
          signin: 'api/aunt/sign_in',
          register: 'api/aunt/register',
          checkemail: 'api/aunt/confirm',
        },
      };
    },
    mounted() {
      //this.typeOfPage = localStorage.getItem("typeOfPage");
    },
    computed: {
      isNotFilled: function() {
        return !(this.user.login !== undefined && this.user.login !== null && this.user.password !== undefined && this.user.password !== null && this.user.login.length > 0 && this.user.password.length >= this.minPasswordLength); 
      },
    },
    methods: {
      createMessage: async function(message) {
        console.error(message);
        alert(message);
      },


      signin: async function(event) {
        console.log('sign in account:');
        console.log(`user: ${this.user}`);

        console.log('fetching tokens from server...');
        let response = await fetch(baseURL+this.queries.signin, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json;charset=utf-8',
          },
          body: JSON.stringify(this.user)
        }).catch(function (){
          alert("Error while authentication. Check your connection")
        });

        let json = null;
        try {
          json = await response.json();
        } catch (e) {
          console.error(e);
          return;
        }

        console.log('check if response is ok (200)');
        if (response.ok) {
          console.log('response 200; get token');
          console.log(`response body: ${json}`);
          if (!json) {
            console.log('bad data: expected { accessToken, refreshToken }');
            this.createMessage(`*${json}`);
          } else {
            console.log(`got user access-token`);
            console.log(`got user refresh-token`);
            localStorage.setItem("accessToken", json.accessToken);
            localStorage.setItem("refreshToken", json.refreshToken);

            this.$session.set(this.access, json.accessToken);
            this.$session.set(this.refresh, json.refreshToken);
            //console.log(this.$session.get(this.access)+"   "+this.$session.get(this.refresh))

            //window.location.reload();
            this.$router.push({name: 'main-page'});
          }
        } else this.createMessage(`*${json.description}`);
      },

      signup: async function(event) {

        console.log('sign up new account:');
        console.log(`user: ${this.user}`);
        
        console.log('fetching tokens from server...');
        let response = await fetch(baseURL+this.queries.checkemail, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json;charset=utf-8',
          },
          body: JSON.stringify(this.user)
        }).catch(function (){
          alert("Error while getting token. Check your connection")
        });

        console.log('sent request');
        console.log('check if status 201');

        let json = null;
        try {
          json = await response.json();
        } catch (e) {
          console.error(e);
          return;
        }

        if (response.status === 201) {
            console.log('user created');
          console.log(`response body: ${JSON.stringify(json)}`);
          if (!json)
            console.log('bad data: expected { accessToken, refreshToken }');
          else {
            console.log('got user access-token');
            console.log('get user refresh-token');
            //TODO: ВЕРНУТЬ
            // localStorage.setItem("accessToken", json.accessToken);
            // localStorage.setItem("refreshToken", json.refreshToken);

            this.$session.set(this.access, json.accessToken);
            this.$session.set(this.refresh, json.refreshToken);

            //window.location.reload();
            //TODO: ВЕРНУТЬ
            //this.$router.push({name: 'app-page'});
          }
        } else {
            this.createMessage(`*${json.description}`);
        }
      },
    }
  }

</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap%27');

  .trouble_link {
    float: left;
    text-decoration: underline;
    margin: 0 0 0 6%;
  }

  #main_title {
    vertical-align: middle;
    line-height: 65px;
    font-size: 170%;
  }

  #loging {
    background: #F6FBFF;
    display: block;
    width: 40%;
    margin: 0 auto;
  }

  #login-form {
    background: #F6FBFF;
  }

  #login-form input {
    margin: auto;
    width: 90%;
    border: 1px solid #c6c9cc;
    border-radius: 15px;
    color: #555;
    display: block;
    padding: 1% 2%;
    height: 50px;
  }

  #login-form label {
    padding: 0 5% ;
    color: #3e606f;
    font-family: Satisfy,Lato,Open Sans,Roboto,sans-serif;
    text-transform: capitalize;
    font-size: 170%
  }

  #login-form fieldset#back {
    text-align: left;
  }

  #login-form fieldset {
    padding: 4%;
    border: 1px solid #F6FBFF;
    border-radius: 5px;
    margin: 1% 1%;
    text-align: center;
  }

  #err_message {
      font-size: 100%;
      font-style: italic;
      margin-left: 10%;
      color: #cd1a21
  }

  .btn {
    float: right;
    width: 95px;
    height: 46px;
    margin: 0 6% 0 0 ;
    background: #F3F3F3;
    border: 2px solid #6FB2E6;
    box-sizing: border-box;
    border-radius: 30px;
    transition: all 500ms ease;
  }


  .btn:hover {
    background: #6FB2E6;
    color: #fff;
    box-shadow: inset 0 0 0 3px #6FB2E6;
    cursor: pointer;
  }

  #arrow {
    height: 95%;
    width: 95%;

  }

  .btn:hover svg {
    fill: white;
    transition: all 500ms ease;
  }


  @media only all and (min-width: 882px) and (max-width: 1255px) {
      #login-form {
          display: block;
          height: 100%;
          width: 100%;
      }

      #login-form label {
          font-size: 160%;
      }


      #loging {
          width: 50%;
      }
  }

  @media only all and (max-width: 881px) {
    #loging {
      display: block;
      width: 90%;
    }
  }
</style>