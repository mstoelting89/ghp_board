<template>
  <div class="col-12 col-md-12 col-lg-5 ghp-container">
    <div class="page-header">
      <h2>Guitar Hearts Anfragen</h2>
      <font-awesome-icon class="add-icon" icon="circle-plus" data-bs-toggle="modal" data-bs-target="#addRequest" />
    </div>
  </div>
  <div class="modal fade" id="addRequest" tabindex="-1" aria-labelledby="addRequest" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addRequestLabel">Neue Anfrage</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3 d-flex">
              <div class="col-1 justify-content-start">
                <label for="requestTitle" class="col-form-label">Titel</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="requestTitle">
              </div>
              <div class="col-1 justify-content-start">
                <label for="requestDate" class="col-form-label">Datum</label>
              </div>
              <div class="col-5">
                <input type="date" class="form-control" id="requestDate">
              </div>
            </div>
            <div class="mb-3 d-flex">
              <div class="col-1 justify-content-start">
                <label for="requestName" class="col-form-label">Name</label>
              </div>
              <div class="col-5">
                <input type="text" class="form-control" id="requestName">
              </div>
            </div>
            <div class="mb-3">
              <div class="col-1 justify-content-start">
                <label class="col-form-label">Text:</label>
              </div>
              <ckeditor :editor="requestEditor" :config="editorConfig"></ckeditor>
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
  name: "Request",
  data() {
    return {
      requestEditor: ClassicEditor,
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