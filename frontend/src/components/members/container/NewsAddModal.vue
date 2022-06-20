<template>
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
              <div class="col-5" ref="newsTitle">
                <input type="text" class="form-control"  id="newsTitle" @keydown="removeErrorMessage" v-model="newsTitle">
                <div class="errorMsg"></div>
              </div>
              <div class="col-1"></div>
              <div class="col-1 d-flex justify-content-start">
                <label for="newsTitle" class="col-form-label">Datum</label>
              </div>
              <div class="col-4" ref="newsDate">
                <input type="date" class="form-control" id="newsDate" @keydown="removeErrorMessage" v-model="newsDate">
                <div class="errorMsg"></div>
              </div>
            </div>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsTitle" class="col-form-label">Autor</label>
              </div>
              <div class="col-5" ref="newsAuthor">
                <input type="text" class="form-control" id="newsAuthor" @keydown="removeErrorMessage" v-model="newsAuthor">
                <div class="errorMsg"></div>
              </div>
            </div>

            <div class="mb-3">
              <div class="col-1 d-flex justify-content-start">
                <label class="col-form-label">Text:</label>
              </div>
              <div class="col-12 justify-content-start" ref="newsText">
                <ckeditor :editor="newsEditor" :config="editorConfig" v-model="newsText" class="form-control"></ckeditor>
                <div class="errorMsg"></div>
              </div>
            </div>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsImage" class="col-form-label">Bild</label>
              </div>
              <div class="col-5">
                <input type="file" class="form-control" ref="newsImage" id="newsImage" @change="handleFile()">
              </div>
            </div>

          </form>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-default" data-bs-dismiss="modal">Schließen</button>
          <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="insertNewNewsEntry">Speichern</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

export default {
  name: "NewsAddModal",
  data() {
    return {
      newsEditor: ClassicEditor,
      editorConfig: {},
      newsTitle: '',
      newsDate: '',
      newsAuthor: '',
      newsText: '',
      formData: null
    }
  },
  methods: {
    handleFile() {
      this.file = this.$refs.newsImage.files[0];
    },
    insertNewNewsEntry() {

      let checkTitle = this.checkField(this.newsTitle, this.$refs.newsTitle);
      let checkDate = this.checkField(this.newsDate, this.$refs.newsDate);
      let checkAuthor = this.checkField(this.newsAuthor, this.$refs.newsAuthor);
      let checkText = this.checkField(this.newsText, this.$refs.newsText);

      if (
          checkTitle ||
          checkDate ||
          checkAuthor ||
          checkText
      ) {
        this.formData = new FormData();
        this.formData.append('file', this.file);

        let data = {
          newsTitle: this.newsTitle,
          newsDate: this.newsDate + "T00:00:00",
          newsAuthor: this.newsAuthor,
          newsText: this.newsText,
        }
        this.formData.append('newsData', JSON.stringify(data));

        this.$store.dispatch('insertNewNewsEntry', this.formData).then(() => {
          this.$store.dispatch('getNews').then(response => {
            this.$parent.loadNews(response);
            //this.newsArray = this.loadNews(response);
          });
        });
        document.querySelector('#showNews .btn-close').click();
      }
    },
    checkField(input, inputWrapper) {
      if (input.length <= 0) {
        inputWrapper.querySelector('.errorMsg').innerHTML = "Dieses Feld muss ausgefüllt sein";
        return false;
      } else {
        inputWrapper.querySelector('.errorMsg').innerHTML = "";
        return true;
      }
    },
    removeErrorMessage(event) {
      if (event.target.parentNode.querySelector('.errorMsg').innerHTML.length > 0) {
        event.target.parentNode.querySelector('.errorMsg').innerHTML = "";
      }
    }
  }
}
</script>

<style scoped>
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
.btn-secondary {
  padding: 5px;
  font-size: 12px;
  background-color: #a21d21;
}

.btn-default {
  border: 1px solid #a21d21;
}

.btn-primary {
  padding: 15px 40px;
  font-size: 16px;
  background-color: #a21d21;
}

</style>