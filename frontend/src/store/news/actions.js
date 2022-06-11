import newsService from "@/service/newsService";

export const actions = {
    getNews() {
        return new Promise((resolve) => {
            newsService.getNews().then((response) => {
                resolve(response);
            });
        });
    },
    getNewsDetail({ commit }, payload) {
        commit('NEWS');
        return new Promise((resolve) => {
           newsService.getNewsDetail(payload).then((response) => {
               resolve(response);
           })
        });
    },
    insertNewNewsEntry({ commit }, payload) {
        commit("NEWS");

        return new Promise((resolve) => {
            newsService.insertNewsEntry(payload).then((response) => {
                resolve(response);
            });
        })
    }
}