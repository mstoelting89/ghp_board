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
        <div class="buttons">
          <div class="show-news">
            <button class="btn btn-secondary" @click="getNewsDetail(newsEntry.id)" data-bs-toggle="modal" data-bs-target="#showNews">mehr lesen</button>
          </div>
          <div class="update-news">
            <font-awesome-icon class="update-icon" @click="setUpdateNewsId(newsEntry.id)"  icon="pen" data-bs-toggle="modal" data-bs-target="#updateNews" />
          </div>
          <div class="delete-news">
            <font-awesome-icon class="delete-icon" @click="setDeleteNewsId(newsEntry.id)" icon="trash" data-bs-toggle="modal" data-bs-target="#deleteNews" />
          </div>
        </div>
      </div>
    </div>
  </div>

  <NewsAddModal />
  <NewsUpdateModal
      :newsUpdateId="newsUpdateId"
  />
  <NewsShowModal
      :newsDetail="newsDetail"
  />
  <NewsDeleteModal
      :newsDeleteId="newsDeleteId"
  />

</template>

<script>
import NewsAddModal from "@/components/members/container/NewsAddModal";
import NewsShowModal from "@/components/members/container/NewsShowModal";
import NewsUpdateModal from "@/components/members/container/NewsUpdateModal";
import NewsDeleteModal from "@/components/members/container/NewsDeleteModal";

export default {
  name: "News",
  components: {NewsDeleteModal, NewsUpdateModal, NewsShowModal, NewsAddModal},
  data() {
    return {
      newsArray: '',
      newsUpdate: false,
      newsUpdateId: '',
      newsDeleteId: '',
      newsDetail: {
        detailAuthor: '',
        detailDate: '',
        detailTitle: '',
        detailText: '',
        detailImage: null
      }
    }
  },
  async created() {
    await this.$store.dispatch('getNews').then(response => {
      this.newsArray = this.loadNews(response);
    });

  },
  methods: {
    logout() {
      this.$store.dispatch('logout').then(() => this.$router.push('/login'));
    },
    loadNews(response) {
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
      return data;
    },
    getNewsDetail(id) {
      this.$store.dispatch('getNewsDetail', id).then(response => {
        let date = new Date(response.data.newsDate);
        let newsDate = ("0" + date.getDate()).slice(-2) + "." + ("0" + (date.getMonth() + 1)).slice(-2) + "." + date.getFullYear();
        let image = document.querySelector('#detailImage');

        this.newsDetail.detailTitle = response.data.newsTitle;
        this.newsDetail.detailAuthor = response.data.newsAuthor;
        this.newsDetail.detailText = response.data.newsText;
        this.newsDetail.detailDate = newsDate;
        this.newsDetail.detailImage = "data:image/jpg;base64," + response.data.newsImage;

        if (response.data.newsImage) {
          image.setAttribute('src', "data:image/jpg;base64," + response.data.newsImage);
        } else {
          image.setAttribute('src', '');
        }
      });
    },
    setUpdateNewsId(id) {
      this.newsUpdateId = id;
    },
    setDeleteNewsId(id) {
      this.newsDeleteId = id;
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
.newsEntryMain .buttons {
  display: flex;
}
.newsEntryMain .btn {
  padding: 5px;
  font-size: 12px;
  background-color: #a21d21;
}
.newsEntryMain .buttons .update-icon, .newsEntryMain .buttons .delete-icon {
  background-color: #a21d21;
  color: #fff;
  padding:7px;
  font-size:28px;
  border-radius: 5px;
  margin-left: 5px;
  margin-top: 1px;
  cursor: pointer;
}
</style>