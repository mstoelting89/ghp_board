<template>
  <div class="slider">
    <div class="row header-title align-items-center">
      <div class="col-4 col-md-4 col-lg-4 logo-align">
        <img :src="require('@/assets/images/BilderLars/1548x1026.png')">
      </div>
      <div class="col-12 col-md-12 col-lg-8">
        <div class="page-header">
          <h1>{{ sliderSmallTitle }}</h1>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SliderSmall",
  props: [
      'sliderSmallTitle'
  ]
}
</script>

<style scoped>
.slider {
  height: 50vh;
  background-image: url("~@/assets/images/background-img-min-min(1).jpeg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center 50%;
  position: relative;
}
.header-title {
  position: absolute;
  left: 6vw;
  background-color: rgba(255,255,255,.8);
  padding: 1rem 3rem 3rem 1rem;
  min-width: 60vw;
  max-width: 60vw;
  display: flex;
  border-radius: 5px;
  text-align: left;
  top: 15vh;
}
.logo-align {
  margin: 0 auto;
  display: flex;
  justify-content: center;
}
.logo-align img {
  height: 20vh;
}
</style>