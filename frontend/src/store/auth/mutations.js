export const mutations = {
    LOGGED_IN(state) {
        state.loggedIn = true
    },
    ERROR_MSG(state, payload) {
        state.errorMsg = payload;
    },
    NEWS(state) {
        state.news = true
    }
}