<template>
  <div class="intro-text">
    <div class="col-sm-12 col-md-12 col-lg-4 flex align-self-center intro-title-main">
      <div class="first-word">
        {{ introTextFirstWord }}
      </div>
      <div>
        {{ introTextTitle }}
      </div>

    </div>
    <div class="col-sm-12 col-md-12 col-lg-8 intro-text-main">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  name: "IntroText",
  props: [
      'introTextTitle',
      'introTextFirstWord'
  ]
}
</script>

<style scoped>
  .intro-title-main {
    text-align: left;
    font-size: 2rem;
  }
  .intro-text {
    display: flex;
    margin-top: 20px;
  }
  .intro-text-main {
    text-align: left;
  }
  .first-word {
    font-weight: 600;
    color: #a21d21;
  }
</style>