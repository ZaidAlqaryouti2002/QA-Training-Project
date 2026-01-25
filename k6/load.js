import http from 'k6/http';
import { check, sleep } from 'k6';


export const options = {
  vus: 20,
  duration: '30s',
  thresholds: {
    http_req_duration: ['p(95)<3000'], 
    http_req_failed: ['rate<0.01'],
  },
};

export default function () {
  const BASE_URL = 'https://dummyjson.com';

  const loginPayload = JSON.stringify({
    username: 'emilys',
    password: 'emilyspass',
  });
  const params = { headers: { 'Content-Type': 'application/json' } };

  let loginRes = http.post(`${BASE_URL}/auth/login`, loginPayload, params);
  
  let authToken = "";
  try {
      authToken = loginRes.json('accessToken');
  } catch(e) {}

  if(authToken){
      const authHeaders = {
        headers: { Authorization: `Bearer ${authToken}` },
      };
      http.get(`${BASE_URL}/auth/products`, authHeaders);
      http.get(`${BASE_URL}/users/1`, authHeaders);
  }

  sleep(1);
}