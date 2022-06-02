import axios from 'axios';

export default {
    getNews() {
        const token = localStorage.getItem('token');

        const header = {
            'Content-Type' : 'application/x-www-form-urlencoded',
            'Authorization': `Bearer ${token}`,
            'Access-Control-Allow-Origin' : '*',
            'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        }

        return axios.get("http://localhost:8886/api/v1/news", {
            headers: header
        });
    },
    getNewsDetail(id) {
        const token = localStorage.getItem('token');

        const header = {
            'Content-Type' : 'application/x-www-form-urlencoded',
            'Authorization': `Bearer ${token}`,
            'Access-Control-Allow-Origin' : '*',
            'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        }

        return axios.get("http://localhost:8886/api/v1/news/" + id, {
            headers: header
        });
    }
}