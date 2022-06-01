<template>
  <div class="col-12 col-md-12 col-lg-5 ghp-container">
    <div class="page-header">
      <h2>Guitar Hearts News</h2>
      <font-awesome-icon class="add-icon" icon="circle-plus" data-bs-toggle="modal" data-bs-target="#addNews" />
    </div>
  </div>

  <div class="modal fade" id="addNews" tabindex="-1" aria-labelledby="addNews" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addNewsLabel">Neuer Newseintrag</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsTitle" class="col-form-label">Titel</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="newsTitle" v-model="newsTitle">
              </div>
              <div class="col-1"></div>
              <div class="col-1 d-flex justify-content-start">
                <label for="newsTitle" class="col-form-label">Datum</label>
              </div>
              <div class="col-4">
                <input type="date" class="form-control" id="newsDate" v-model="newsDate">
              </div>
            </div>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsTitle" class="col-form-label">Autor</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="newsAuthor" v-model="newsAuthor">
              </div>
            </div>

            <div class="mb-3">
              <div class="col-1 d-flex justify-content-start">
                <label class="col-form-label">Text:</label>
              </div>
              <div class="col-12 justify-content-start">
                <ckeditor :editor="newsEditor" :config="editorConfig" v-model="newsText"></ckeditor>
              </div>
            </div>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsImage" class="col-form-label">Bild</label>
              </div>
              <div class="col-5">
                <input type="file" class="form-control" ref="myFiles" id="newsImage" @change="handleFile()">
              </div>
            </div>

          </form>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Schließen</button>
          <button type="button" class="btn btn-primary" @click="send">Speichern</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

export default {
  name: "News",
  data() {
    return {
      newsEditor: ClassicEditor,
      editorConfig: {

      },
      newsTitle: '',
      newsDate: '',
      newsAuthor: '',
      newsText: '',
      files: ''
    };
  },
  methods: {
    logout() {
      this.$store.dispatch('logout').then(() => this.$router.push('/login'));
    },
    send() {
      console.log(this.newsTitle);
      console.log(this.newsDate);
      console.log(this.newsAuthor);
      console.log(this.newsText);
      console.log(this.files);
    },
    handleFile() {
      this.files = this.$refs.myFiles.files;
    }
  }
}
</script>

<style scoped>
.ghp-container {
  background-color: #fff;
  height: 50vh;
  border-radius: 5px;
}
.page-header {
  margin-top: 10px;
  display: flex;
  justify-content: space-between;
}
.add-icon {
  font-size: 35px;
  color: #a21d21;
  cursor: pointer;
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