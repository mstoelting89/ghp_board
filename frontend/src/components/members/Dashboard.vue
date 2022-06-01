<template>
  <div class="slider"></div>
  <div class="ghp-dashboard">
    <div class="row container-wrapper justify-content-between">
      <News />
      <Request />
    </div>
    <div class="row container-wrapper">
      <Blog />
    </div>
    <div class="row container-wrapper">
      <Instruments />
    </div>
  </div>

</template>

<script>
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import News from "@/components/members/container/News";
import Request from "@/components/members/container/Request";
import Blog from "@/components/members/container/Blog";
import Instruments from "@/components/members/container/Instruments";

export default {
  name: "Dashboard",
  components: {Instruments, Blog, Request, News},
  data() {
    return {
      editor: ClassicEditor,
      editorConfig: {

      }
    };
  },
  methods: {
    logout() {
      this.$store.dispatch('logout').then(() => this.$router.push('/login'));
    }
  }
}
</script>

<style scoped>
.slider {
  height: 100vh;
  background-image: url("~@/assets/images/background-img-min-min(1).jpeg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  position: fixed;
  width: 100vw;
  z-index: -1;
}
.header-title {
  position: absolute;
  left: 6vw;
  background-color: rgba(255,255,255,1);
  padding: 1rem 3rem 3rem 1rem;
  min-width: 60vw;
  max-width: 60vw;
  display: flex;
  border-radius: 5px;
  text-align: left;
  top: 30vh;
}
.logo-align {
  margin: 0 auto;
  display: flex;
  justify-content: center;
}
.logo-align img {
  height: 20vh;
}

.btn:focus {
  box-shadow: none;
}

button, button:focus {
  background-color: #a21d21;
  border: 1px solid #a21d21;
  box-shadow: none;
}

button:hover {
  opacity: 0.8;
  background-color: #a21d21;
  border: 1px solid #a21d21;
}

.ghp-container {
  background-color: #fff;
  height: 50vh;
  border-radius: 5px;
}

.ghp-dashboard {
  padding-top: 125px;
}

.container-wrapper {
  margin-left: 20px;
  margin-right: 20px;
  margin-bottom: 20px;
}


.modal-dialog {
  min-width: 70vw;
}
.modal-content {
  min-height: 90vh;
}
.btn-close {
  background-color: transparent;
  border: none;
}
.btn {
  font-weight: bold;
  border-radius: 5px;
  border: none;
  padding: 15px 40px;
}
</style>