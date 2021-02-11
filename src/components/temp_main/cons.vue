<template>
  <div class="cons">
    <div class="cons__left">

      <svg width="300" height="265" viewBox="0 0 300 265" fill="white" xmlns="http://www.w3.org/2000/svg">
        <path d="M0.357666 15.0376C0.357666 6.35906 7.7003 -0.508503 16.3595 0.0711215L285.146 18.063C293.024 18.5903 299.144 25.1341 299.144 33.0295V249.962C299.144 258.641 291.801 265.509 283.142 264.929L14.3558 246.937C6.47808 246.41 0.357666 239.866 0.357666 231.97V15.0376Z" fill="white"/>
      </svg>


    </div>
    <div class="cons__right">
      <h1>Как часто ваши работники ошибаются и тратят драгоценное время?</h1>
      <br>
      <h3>Мы это знаем не по наслышке. По нашим исследованиям работники на больших складах тратят больше 35% рабочего времени в пустую. только потому что они люди. Мы предлагаем вам это исправить!</h3>
      <br>
      <button title="Связаться со мной" class="btn__more">Связаться со мной</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "cons"
}
</script>

<style scoped>



.btn__more {
  font-size: 22px;
  text-align: center;
  margin: 0  0 10px 50px;
  background: dodgerblue;
  border: 2px solid dodgerblue;
  box-sizing: border-box;
  border-radius: 30px;
  color: white;
  transition: all 500ms ease;
}

.btn__more:hover {
  background: white;
  color: dodgerblue;
  box-shadow: inset 0 0 0 3px dodgerblue;
  cursor: pointer;
}

.cons {
  height: 100%;
  display: flex;
  align-items: stretch;
}

.cons__left {
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: left;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.cons__right {
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: right;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.cons__us {
  color: dodgerblue;
  font-weight: bold;
}

b{
  font-weight: bold;
}
h3 {
  font-size: 140%;
}

svg{
  border-radius: 15px;
  border-color: black;
  margin: 0 0 0 50px;
  filter: drop-shadow( 3px 3px 2px rgba(0, 0, 0, .7));

}

</style>