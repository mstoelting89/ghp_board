<template>
  <div class="modal fade" id="showNews" tabindex="-1" aria-labelledby="showNews" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <div class="row">
            <div class="newsDetailInfo">
              <div class="newsDetailAuthor" v-html="newsDetail.detailAuthor"></div>
              <div class="newsDetailInfoEnd">
                <div class="newsDetailDate" v-html="newsDetail.detailDate"></div>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
            </div>

          </div>
          <div class="row">
            <div class="newsDetailHeader">
              <div class="newsDetailTitle" v-html="newsDetail.detailTitle"></div>
            </div>
          </div>
        </div>
        <div class="modal-body">
          <div class="body-image">
            <img class="detailImage" src="{{ newsDetail.detailImage }}" id="detailImage">
          </div>
          <div class="body-text" v-html="newsDetail.detailText"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewsShowModal",
  props: ['newsDetail'],
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
  color: #a21d21;
}
.detailImage {
  width:50%;
  height:auto;
}
.body-text {
  text-align: left;
}
</style>