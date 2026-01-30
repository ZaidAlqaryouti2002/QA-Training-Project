import http from 'k6/http';
import { check, sleep } from 'k6';


export const options = {
  vus: 5,
  duration: '10s', 
  thresholds: {
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
  
  check(loginRes, { 'status is 200': (r) => r.status === 200 });
  
  
  let authToken = loginRes.json('accessToken');
  
  if(authToken){
      const authHeaders = {
        headers: { Authorization: `Bearer ${authToken}` },
      };
      http.get(`${BASE_URL}/auth/products`, authHeaders);
      http.get(`${BASE_URL}/users/1`, authHeaders);
  }
  
  sleep(1);
}