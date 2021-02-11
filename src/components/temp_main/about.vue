<template>
<div class="about">
  <div class="about__left">
    <h1 class="about__us">О нас</h1>
    <br>
    <h3>Наша компания работает на рынке автоматизации с <b>2006 года.</b>  Мы автоматизировали больше <b>150</b>  производственных предприятий.</h3>
    <br>
    <h3>Более <b>60%</b> клиентов к нам обращаются повторно с другими задачами автоматизации. Главным нашим подразделением является автоматизация складских помещений по типу компании Amazon</h3>
    <br>
    <button title="Узнать больше" class="btn__more">Узнать больше</button>
  </div>
  <div class="about__right">
    <img src="@/assets/shelves.png" alt="полки" class="img__shelves" width="100%" height="100%">
  </div>
</div>

</template>

<script>
export default {
  name: "about",
  methods: {

  },
}
</script>

<style scoped>

* {
  background: white;
}

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

.about {
  height: 100%;
  display: flex;
  align-items: stretch;
}

.about__left {
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: left;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.about__right {
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: right;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.about__us {
  color: dodgerblue;
  font-weight: bold;
}

b{
  font-weight: bold;
}
h3 {
  font-size: 140%;
}

.img__shelves {
  filter: drop-shadow( 2px 3px 2px rgba(0, 0, 0, .7));
  box-shadow: inset 0 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 30px;
}

</style>