<template>
  <div class="modal fade" id="updateNews" tabindex="-1" aria-labelledby="updateNews" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addNewsLabel">Newseintrag bearbeiten</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsDetailTitle" class="col-form-label">Titel</label>
              </div>
              <div class="col-5" ref="newsTitle">
                <input type="text" class="form-control"  id="newsDetailTitle" @keydown="removeErrorMessage" v-model="title">
                <div class="errorMsg"></div>
              </div>
              <div class="col-1"></div>
              <div class="col-1 d-flex justify-content-start">
                <label for="newsDetailDate" class="col-form-label">Datum</label>
              </div>
              <div class="col-4" ref="newsDate">
                <input type="date" class="form-control" id="newsDetailDate" @keydown="removeErrorMessage" v-model="date">
                <div class="errorMsg"></div>
              </div>
            </div>

            <div class="mb-3 d-flex">
              <div class="col-1 d-flex justify-content-start">
                <label for="newsDetailAuthor" class="col-form-label">Autor</label>
              </div>
              <div class="col-5" ref="newsAuthor">
                <input type="text" class="form-control" id="newsDetailAuthor" @keydown="removeErrorMessage" v-model="author">
                <div class="errorMsg"></div>
              </div>
            </div>

            <div class="mb-3">
              <div class="col-1 d-flex justify-content-start">
                <label class="col-form-label">Text:</label>
              </div>
              <div class="col-12 justify-content-start" ref="newsText">
                <ckeditor :editor="newsEditor" :config="editorConfig" class="form-control" v-model="text"></ckeditor>
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
          <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="updateNews">Speichern</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

export default {
  name: "NewsUpdateModal",
  props: ['newsUpdateId', 'newsUpdateDetail'],
  data() {
    return  {
      newsEditor: ClassicEditor,
      editorData: '',
      editorConfig: {},
      date: '',
      author: '',
      text: '',
      title: '',
      formData: null
    }
  },
  watch: {
    newsUpdateId: function(id) {
      this.$store.dispatch('getNewsDetail', id).then(response => {
        let date = new Date(response.data.newsDate);

        this.title = response.data.newsTitle;
        this.author = response.data.newsAuthor;
        this.text = response.data.newsText;
        this.date = date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" +("0" + date.getDate()).slice(-2);
        this.image = "data:image/jpg;base64," + response.data.newsImage;

      });
    }
  },
  methods: {
    handleFile() {
      this.file = this.$refs.newsImage.files[0];
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
    },
    updateNews() {
      let checkTitle = this.checkField(this.title, this.$refs.newsTitle);
      let checkDate = this.checkField(this.date, this.$refs.newsDate);
      let checkAuthor = this.checkField(this.author, this.$refs.newsAuthor);
      let checkText = this.checkField(this.text, this.$refs.newsText);

      if (
          checkTitle ||
          checkDate ||
          checkAuthor ||
          checkText
      ) {
        this.formData = new FormData();
        this.formData.append('file', this.file);
        this.formData.append('newsUpdateId', this.newsUpdateId);
        let data = {
          newsTitle: this.title,
          newsDate: this.date + "T00:00:00",
          newsAuthor: this.author,
          newsText: this.text,
        }
        this.formData.append('newsData', JSON.stringify(data));

        this.$store.dispatch('updateNewsEntry', this.formData).then(() => {
          this.$store.dispatch('getNews').then(response => {
            this.$parent.loadNews(response);
          });
        });
        document.querySelector('#showNews .btn-close').click();
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