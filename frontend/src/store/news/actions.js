import newsService from "@/service/newsService";

export const actions = {
    getNews() {
        newsService.get().then((response) => {
            console.log(response);
        });
    }
}