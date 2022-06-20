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
    },
    updateNewsEntry({ commit }, payload) {
        commit("NEWS");

        return new Promise((resolve) => {
            newsService.updateNewsEntry(payload).then((response) => {
                resolve(response);
            })
        })
    },
    deleteNewsEntry({ commit }, payload) {
        commit("NEWS");

        return new Promise((resolve) => {
            newsService.deleteNewsEntry(payload).then((response) => {
                resolve(response);
            })
        })
    },
    getAttachment({ commit }, payload) {
        commit("NEWS");

        return new Promise((resolve) => {
            newsService.getAttachment(payload).then((response) => {
                resolve(response);
            })
        })
    }
}