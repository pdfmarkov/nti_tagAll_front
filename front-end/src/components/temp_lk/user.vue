<template>
  <div class="user">
    <div class="user__left">
      <img src="@/assets/chel.png" alt="" style="width: 400px; margin-top: -10px" >

    </div>
    <div class="user__right">

      <table>
        <tr>
          <td>
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" >
            Василий</td>
        </tr>
        <tr>
          <td>  <img src="@/assets/pen.png" alt="" style="width: 15px;margin-right: 7px;" >Иванович</td>
        </tr>
        <tr>
          <td>  <img src="@/assets/pen.png" alt="" style="width: 15px;margin-right: 7px;" >Залупкин</td>
        </tr>
        <tr>
          <td>  <img src="@/assets/pen.png" alt="" style="width: 15px;margin-right: 7px;" >pupkin@pupkin.ru</td>
        </tr>
        <tr>
          <td>  <img src="@/assets/pen.png" alt="" style="width: 15px;margin-right: 7px;" >8 (999)-999-00-00</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "user"
}
</script>

<style scoped>

  TABLE {
    margin-top: 50px;
    margin-left: 10px;
    width: 300px; /* Ширина таблицы */
    border-collapse: collapse; /* Убираем двойные линии между ячейками */
    border: 1px solid rgba(0, 0, 0, 0.4);
  }
  TD, TH {
    font-family:Bruno;
    font-weight: bold;
    padding: 5px; /* Поля вокруг содержимого таблицы */
    border: 1px solid rgba(0, 0, 0, 0.4);
    text-align: left; /* Выравнивание по левому краю */
  }

  h{
    margin-left: 30px;
  }



  .user {
    height: 100%;
    display: flex;
    align-items: stretch;
  }

  .user__left {
    margin-left: -460px;
    margin-top: 100px;
    margin-bottom: 100px;
    float: left;
    width: 400px;
  }

  .user__right {
    margin-top: 100px;
    margin-bottom: 100px;
    vertical-align: center;
    float: right;
  }

  .user__us {
    color: dodgerblue;
    font-weight: bold;
  }

  b{
    font-weight: bold;
  }

  svg{
    border-radius: 15px;
    border-color: black;
    margin: 0 0 0 50px;
    filter: drop-shadow( 3px 3px 2px rgba(0, 0, 0, .7));

  }

</style>