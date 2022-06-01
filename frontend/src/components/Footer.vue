<template>
  <div class="footer">
    <div class="col-lg-4 col-xs-3 sub-text-footer pt-3 pb-3">
      The Guitar Hearts Project e.V.
      guitarheartsproject@outlook.de
      067719344061
      Langgasse 17, 56348 Bornich, Germany

      ©2020 The Guitar Hearts Project e.V.
    </div>
    <div class="col-lg-6 col-xs-3 partners">
      Partner
    </div>
    <div class="col-lg-2 col-xs-3 secondary-menu">
      <router-link to="/satzung">Satzung</router-link>
      <router-link to="/impressum">Impressum</router-link>
      <router-link to="/login">Mitglieder-Login</router-link>
      Kontakt
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer"
}
</script>

<style scoped>
.footer {
  display:flex;
  background-color: #000000;
  color: #ffffff;
}
</style>