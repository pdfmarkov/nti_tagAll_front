<template>
<div class="about">
  <div class="left">
    <h1>О нас</h1>
    <br>
    <h3>Наша компания работает на рынке автоматизации с 2006 года. Мы автоматизировали больше 150 производственных предприятий.
    </h3>
    <br>
    <h3>Более 60% клиентов к нам обращаются повторно с другими задачами автоматизации. Главным нашим подразделением является автоматизация складских помещений по типу компании Amazon</h3>
  </div>

  <div class="right">
    <img src="@/assets/shelves.png" alt="полки" class="img__shelves" width="100%" height="100%">
  </div>


</div>
</template>

<script>
export default {
  name: "about"
}
</script>

<style scoped>

.about{
  background: white;
  height: 100%;
}

.left {
  background: white;
  float: left;
  width: 50%;
  height: 100%;

}

.right {
  background: white;
  float: right;
  width: 50%;
  height: 100%;

}

h3 {
  width: 40%;
  font-size: 140%;
}

.img__shelves {
  box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 30px;
}

</style>