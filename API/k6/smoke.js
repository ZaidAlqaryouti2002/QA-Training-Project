import http from "k6/http";
import { check, sleep } from "k6";

const BASE_URL = __ENV.BASE_URL || "https://dummyjson.com";

export const options = {
  // SMOKE TEST: 5 users for 10 seconds
  vus: 5,
  duration: "10s",
  thresholds: {
    http_req_failed: ["rate<0.01"],
    http_req_duration: ["p(95)<2000"],
  },
};

export default function () {
  // 1) GET products list
  const res1 = http.get(`${BASE_URL}/products?limit=30`, {
    tags: { endpoint: "GET_/products" },
  });

  check(res1, {
    "products list: status is 200": (r) => r.status === 200,
    "products list: has products array": (r) => {
      try {
        return Array.isArray(r.json().products);
      } catch {
        return false;
      }
    },
  });

  // 2) GET products search
  const res2 = http.get(`${BASE_URL}/products/search?q=phone`, {
    tags: { endpoint: "GET_/products/search" },
  });

  check(res2, {
    "search: status is 200": (r) => r.status === 200,
    "search: has products array": (r) => {
      try {
        return Array.isArray(r.json().products);
      } catch {
        return false;
      }
    },
  });

  // 3) GET cart by id
  const res3 = http.get(`${BASE_URL}/carts/1`, {
    tags: { endpoint: "GET_/carts/1" },
  });

  check(res3, {
    "cart: status is 200": (r) => r.status === 200,
    "cart: id is 1": (r) => {
      try {
        return r.json().id === 1;
      } catch {
        return false;
      }
    },
  });

  // optional small pause
  sleep(1);
}