<template>
  <div class="navigation">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!--
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Satzung</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Impressum</a>
            </li>
          </ul> -->
        </div>
        <div class="sidebar-buttons">
          <ul class="navbar-nav">
            <li class="nav-item">
              Bewerben
            </li>
            <li class="nav-item">
              Spenden
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Navigation"
}
</script>

<style scoped>
  .navbar {
    width: 100%;
    background-color: transparent;
  }
  #navbarSupportedContent {
    justify-content: flex-end;
  }
  .nav-link {
    font-size: 20px;
    font-weight: bold;
    margin-top: auto;
    margin-bottom: auto;
  }
  .navbar-nav {
    margin-right: 5vw;
  }
  .navigation {
    position: fixed;
    z-index: 1000;
    width:100%;
  }
  .nav-item {
    padding: 10px;
  }

  .sidebar-buttons li {
    margin: 15px;
    font-weight: bold;
    font-size: 20px;
    color: #fff;
    background-color: #a21d21;
    padding: 10px;
    border-radius: 5px;
  }
</style>