<template>
  <SliderSmall sliderSmallTitle="Guitar Hearts - Satzung" />
  <div class="content">
    Test
  </div>
  <Footer />
</template>

<script>
import SliderSmall from "@/components/landing-page/SliderSmall";
import Footer from "@/components/Footer";
export default {
  name: "Satzung",
  components: {Footer, SliderSmall}
}
</script>

<style scoped>
.content {
  margin-left: 10vw;
  margin-right: 10vw;
}
</style>