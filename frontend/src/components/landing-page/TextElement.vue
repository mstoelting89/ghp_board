<template>
  <div class="text-element">
    <div class="text-element-title">
      <div class="first-word">
        {{ textElementFirstWord }}
      </div>
      <div>
        {{ textElementTitle }}
      </div>
    </div>
    <div class="text-element-text">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  name: "TextElement",
  props: [
      'textElementTitle',
      'textElementFirstWord'
  ]
}
</script>

<style scoped>
.first-word {
  font-weight: 600;
  color: #a21d21;
}
.text-element-title {
  font-size: 2rem;
}
</style>