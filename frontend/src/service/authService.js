import axios from 'axios';

export default {
    login(data) {
        const header = {
            "Content-Type": "application/json",
            "Accept": "*/*",
        }

        return axios.post("http://localhost:8886/api/v1/login", data, header);
    }
}