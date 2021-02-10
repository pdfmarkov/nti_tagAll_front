<template>
  <div class="info">
    <br>
    <h1>ООО “Современные технологии автоматизации”</h1>
    <br>
    <h2>Автоматизированное складское помещение без использования человеческих ресурсов уже на вашем <br> производстве</h2>
    <br>
    <h3>На данном сайте представлено пример того, как можно автоматизировать ваш склад и сэкономить на этом ваши деньги</h3>

<!--      <svg width="78" height="63" viewBox="0 0 78 63" fill="none" xmlns="http://www.w3.org/2000/svg">-->
<!--        <ellipse opacity="0.1" cx="39" cy="31.4844" rx="39" ry="31.4844" fill="#319CFF"/>-->
<!--        <path d="M33 23.5165C33 22.7986 33.7341 22.3146 34.3939 22.5974L51.8553 30.0809C52.6634 30.4272 52.6634 31.5728 51.8553 31.9191L34.3939 39.4026C33.7341 39.6854 33 39.2014 33 38.4835V23.5165Z" fill="#319CFF"/>-->
<!--      </svg>-->
    <button class="video">

      <svg version="1.1" id="Capa_1" height="50" width="50" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
           viewBox="0 0 477.867 477.867" style="enableBackground:new 0 0 477.867 477.867;" fill="dodgerblue" xml:space="preserve">
        <g>
	        <g>
		        <path d="M238.933,0C106.974,0,0,106.974,0,238.933s106.974,238.933,238.933,238.933s238.933-106.974,238.933-238.933
			      C477.726,107.033,370.834,0.141,238.933,0z M339.557,246.546c-1.654,3.318-4.343,6.008-7.662,7.662v0.085L195.362,322.56
			      c-8.432,4.213-18.682,0.794-22.896-7.638c-1.198-2.397-1.815-5.043-1.8-7.722V170.667c-0.004-9.426,7.633-17.07,17.059-17.075
			      c2.651-0.001,5.266,0.615,7.637,1.8l136.533,68.267C340.331,227.863,343.762,238.11,339.557,246.546z"/>
	        </g>
        </g>
      </svg>

<!--      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
<!--      <span class="material-icons video__button" style="font-size: 250%">play_circle</span>-->
      <label class="video__link">Посмотреть видео о разработке</label>
    </button>






  </div>
</template>

<script>
export default {
  name: "info"
}
</script>

<style>

.video {
  background-color: Transparent;
  background-repeat:no-repeat;
  border: none;
  cursor:pointer;
  overflow: hidden;
  outline:none;

  margin: 0 0 0 50px;
  text-align: center;
  color: dodgerblue; /* White text */
  padding: 12px 16px; /* Some padding */
  font-size: 16px; /* Set a font size */
}

.video__link{
  text-align: center;
  font-size: 200%;
  text-decoration: underline;
  cursor: pointer;
}

.video__button {
  font-size: 250%;
  text-align: center;
  cursor: pointer;

}



</style>