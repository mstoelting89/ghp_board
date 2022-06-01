import authService from "@/service/authService";

export const actions = {
    login({ commit }, data) {
        return new Promise((resolve) => {
            authService.login(data)
                .then((response) => {
                    localStorage.setItem('token', response.data.token);
                    localStorage.setItem('userRole', response.data.role[0].authority)

                    commit("LOGGED_IN", true);
                    resolve({error: 0});
                })
                .catch(() => {
                    resolve({error: 1});
                });
        });
    },
    logout() {
        return new Promise((resolve) => {
           localStorage.removeItem('token');
           localStorage.removeItem('userRole');
           resolve();
        });
    }
}