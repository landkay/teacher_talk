
import axios from 'axios'

axios.defaults.baseURL = process.env.VUE_APP_IPS_API_URL;

export function post(url, data) {

    return new Promise(function(resolve, reject) {

        axios.post(url, data).then(function(response) {

            console.log('[success]', response);
            resolve(response.data);
        }).catch(function(error) {

            console.log('[failed]', error);
        })
    });
}

export function get(url) {

    return new Promise(function(resolve, reject) {

        axios.get(url).then(function(response) {

            console.log('[success]', response);
            resolve(response.data);
        }).catch(function(error) {

            console.log('[failed]', error);
        })
    });
}
