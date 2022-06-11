<template>
  <div class="col-12 col-md-12 col-lg-5 ghp-container">
    <div class="page-header">
      <h2>Guitar Hearts News</h2>
      <font-awesome-icon class="add-icon" icon="circle-plus" data-bs-toggle="modal" data-bs-target="#addNews" />
    </div>
    <div class="newsEntry" v-for="newsEntry in newsArray" v-bind:key="newsEntry">
      <div class="newsEntryHeader">
        <div class="newsEntryAuthor">{{ newsEntry.newsAuthor }}</div>
        <div class="newsEntryDate">{{ newsEntry.newsDate }}</div>
      </div>
      <div class="newsEntryMain">
        <div class="newsEntryTitle">{{ newsEntry.newsTitle }}</div>
        <button class="btn btn-secondary" @click="getNewsDetail(newsEntry.id)" data-bs-toggle="modal" data-bs-target="#showNews">mehr lesen</button>
      </div>
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
                <input type="file" class="form-control" ref="myFiles" id="newsImage" @change="handleFile()">
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

  <div class="modal fade" id="showNews" tabindex="-1" aria-labelledby="showNews" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <div class="row">
            <div class="newsDetailInfo">
              <div class="newsDetailAuthor" v-html="detailAuthor"></div>
              <div class="newsDetailInfoEnd">
                <div class="newsDetailDate" v-html="detailDate"></div>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
            </div>

          </div>
          <div class="row">
            <div class="newsDetailHeader">
              <div class="newsDetailTitle" v-html="detailTitle"></div>
            </div>
          </div>
        </div>
        <div class="modal-body" v-html="detailText"></div>
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
      editorConfig: {},
      newsTitle: '',
      newsDate: '',
      newsAuthor: '',
      newsText: '',
      files: '',
      newsArray: '',
      detailTitle: '',
      detailText: '',
      detailAuthor: '',
      detailDate: ''
    };
  },
  async created() {
    await this.$store.dispatch('getNews').then(response => {

      let data = [];
      response.data.forEach((item) => {
        let date = new Date(item.newsDate);
        let newsDate = ("0" + date.getDate()).slice(-2) + "." + ("0" + (date.getMonth() + 1)).slice(-2) + "." + date.getFullYear();
        let newsElement = {
          id: item.id,
          newsAuthor: item.newsAuthor,
          newsDate: newsDate,
          newsImage: item.newsImage,
          newsTitle: item.newsTitle,
          newsText: item.newsText
        }
        data.push(newsElement);
      });
      this.newsArray = data;
    });

  },
  methods: {
    logout() {
      this.$store.dispatch('logout').then(() => this.$router.push('/login'));
    },
    getNewsDetail(id) {
      this.$store.dispatch('getNewsDetail', id).then(response => {
        let date = new Date(response.data.newsDate);
        let newsDate = ("0" + date.getDate()).slice(-2) + "." + ("0" + (date.getMonth() + 1)).slice(-2) + "." + date.getFullYear();

        this.detailTitle = response.data.newsTitle;
        this.detailAuthor = response.data.newsAuthor;
        this.detailText = response.data.newsText;
        this.detailDate = newsDate;
      });
    },
    handleFile() {
      this.files = this.$refs.myFiles.files;
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
        let data = {
          newsTitle: this.newsTitle,
          newsDate: this.newsDate + "T00:00:00",
          newsAuthor: this.newsAuthor,
          newsText: this.newsText
        }

        this.$store.dispatch('insertNewNewsEntry', data).then(() => {
          this.$store.dispatch('getNews').then(response => {
            this.newsArray = response.data;
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
.ghp-container {
  background-color: #fff;
  height: 50vh;
  border-radius: 5px;
  overflow: scroll;
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
.newsEntry {
  border-bottom: 1px solid #454545;
  padding-bottom: 5px;
}
.newsEntryHeader {
  display: flex;
  font-size: 12px;
  opacity: .8;
  justify-content: space-between;
}

.newsEntryMain {
  display: flex;
  font-size: 18px;
  justify-content: space-between;
  margin-top: 5px;
}

.newsEntryMain .btn {
  padding: 5px;
  font-size: 12px;
  background-color: #a21d21;
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

#showNews .modal-header {
  flex-direction: column;
}

#showNews .modal-header .row {
  width: 100%;
}

.newsDetailInfo {
  display: flex;
  font-size: 12px;
  opacity: .8;
  justify-content: space-between;
}
.newsDetailHeader {
  display: flex;
  font-size: 18px;
  justify-content: space-between;
  margin-top: 5px;
}
.newsDetailInfoEnd {
  display: flex;
}
.newsDetailInfoEnd .btn-close {
  padding-top: 14px;
}
.errorMsg {
  display: flex;
  font-size: 12px;
  font-weight: bold;
  color: #a21d21;;
}
</style>