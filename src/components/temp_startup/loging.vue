<template>
  <div id="loging">
      <div id="login-form">
      <fieldset>
        <label id="main_title"> РЕГИСТРАЦИЯ </label>
        <input type="email" placeholder="ПОЧТА" title="почта" v-model="user.login" required="true" autocomplete="username">
        <br/>
        <input type="password" placeholder="ПАРОЛЬ" title="пароль" v-model="user.password" required="true" autocomplete="current-password">
        <a id="back"> ВЕРНУТЬСЯ КО ВХОДУ </a>
        <button @click="signin" title="Кнопка для входа в существующий аккаунт" class="btn">
           <b>&#8594;</b>
        </button>
      </fieldset>
    </div>
  </div>
</template>

<script>
  const baseURL = 'http://localhost:41143/';
  export default {
    name: 'loging',
    props: ['access', 'refresh'],
    data: function() {
      return { 
        user: {
          login: '',
          password: '',
        },
        minPasswordLength: 8,
        queries: {
          signin: 'api/aunt/sign_in',
          register: 'api/aunt/register',
        },
      };
    },
    computed: {
      isNotFilled: function() {

        return !(this.user.login !== undefined && this.user.login !== null && this.user.password !== undefined && this.user.password !== null && this.user.login.length > 0 && this.user.password.length >= this.minPasswordLength); 
      },
    },
    methods: {
      createMessage: async function(message) {
        console.error(message);
        let field = document.getElementById('err_message');
        field.innerText = message;
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
            this.$router.push({name: 'app-page'});
          }
        } else this.createMessage(`*${json.description}`);
      },

      signup: async function(event) {

        console.log('sign up new account:');
        console.log(`user: ${this.user}`);
        
        console.log('fetching tokens from server...');
        let response = await fetch(baseURL+this.queries.register, {
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
            localStorage.setItem("accessToken", json.accessToken);
            localStorage.setItem("refreshToken", json.refreshToken);

            this.$session.set(this.access, json.accessToken);
            this.$session.set(this.refresh, json.refreshToken);

            //window.location.reload();
            this.$router.push({name: 'app-page'});
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

  #back {
    float: left;
    left: 10%;
    margin: 15px 10px 10px 30px;
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
    width: 100px;
    height: 50px;
    background: #F3F3F3;
    margin: 10px 10px 10px 160px;
    border: 2px solid #6FB2E6;
    box-sizing: border-box;
    border-radius: 30px;
    transition: all 500ms ease;
  }

  .btn b {
    font-size: 150%;
  }

  .btn:hover {
    background: #6FB2E6;
    color: #fff;
    box-shadow: inset 0 0 0 3px #6FB2E6;
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