<template>
  <div class="col-12 col-md-12 col-lg-12 ghp-container">
    <div class="page-header">
      <h2>Guitar Hearts Blog</h2>
      <font-awesome-icon class="add-icon" icon="circle-plus" data-bs-toggle="modal" data-bs-target="#addBlog" />
    </div>
  </div>
  <div class="modal fade" id="addBlog" tabindex="-1" aria-labelledby="addBlog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addBlogLabel">Neue Anfrage</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3 d-flex">
              <div class="col-1 justify-content-start">
                <label for="blogTitle" class="col-form-label">Titel</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="blogTitle">
              </div>
              <div class="col-1 justify-content-start">
                <label for="blogDate" class="col-form-label">Datum</label>
              </div>
              <div class="col-5">
                <input type="date" class="form-control" id="blogDate">
              </div>
            </div>
            <div class="mb-3 d-flex">
              <div class="col-1 justify-content-start">
                <label for="blogAuthor" class="col-form-label">Autor</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="blogAuthor">
              </div>
            </div>
            <div class="mb-3">
              <div class="col-1 justify-content-start">
                <label class="col-form-label">Text:</label>
              </div>
              <ckeditor :editor="blogEditor" :config="editorConfig"></ckeditor>
            </div>
          </form>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Schließen</button>
          <button type="button" class="btn btn-primary">Speichern</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

export default {
  name: "Blog",
  data() {
    return {
      blogEditor: ClassicEditor,
      editorConfig: {

      }
    };
  },
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