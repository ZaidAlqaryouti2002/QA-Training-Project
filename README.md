#  QA Final Project: End-to-End Testing Suite

**Author:** Zaid Alabed  
**Project:** HTU Final QA Training Project  
**Date:** February 2026  

---

## Introduction
Welcome to my QA project repository, This project demonstrates a quality assurance process, covering **Manual Testing, API Automation, Performance Testing, UI Automation, and CI/CD Integration**.

The testing scope targets two applications:
1.  **Frontend (UI):** [Swag Labs (SauceDemo)](https://www.saucedemo.com) - For Manual & UI Automation.
2.  **Backend (API):** [DummyJSON](https://dummyjson.com) - For API & Performance Testing.

---

## Project Requirements & Coverage

This repository is structured to meet the following 8 deliverables:

### 1 Test Plan & Strategy
* **File Location:** `Root/Test Plan.pdf`
* **Description:** A detailed document covering the scope, in-scope/out-of-scope items, risks, and test strategy for UI testing.

### 2 Manual Test Cases
* **File Location:** `20 test cases + bug report with steps to reproduction/Manual Test Cases.xlsx`
* **Coverage:** Over 20 test cases covering End-to-End scenarios (Login -> Inventory -> Cart -> Checkout).
* **Execution:** Evidence of pass/fail status is included within the sheet.

### 3 Defect Log (Bug Reports)
* **File Location:** `20 test cases + bug report with steps to reproduction/Bug reports saucedemo.xlsx`
* **Details:** Documented **8+ valid defects** found during exploratory testing (focusing on the problem_user flow).
* **Format:** Includes Severity, Steps to Reproduce, Expected vs Actual results.

### 4 & 5 API Automation (Postman & Newman)
* **Tool:** Postman & Newman
* **Files:** `apitest.json`, `env.json`, `users.csv` (Located in API Folder).
* **Coverage:** 20+ Operations (GET, POST, PUT, DELETE) asserting Status Codes, Response Time, and JSON Schema.


### 6 Performance Testing (k6)
I ran a load test on the DummyJSON API to check stability.
* **Script:** `load.js`
* **Command:** `k6 run load.js`
* **Configuration:** 15 Users for 30 seconds.
* **Folder:** API/K6.

**Test Results:**
* **Errors:** 0.00% (Passed).
* **Response Time (p95):** 323ms.
* **Status:** The API handled the load successfully.

### 7 UI Automation
* **Folder:** Root/SauceDemo Selenium automation
* Contains Selenium/Cypress scripts for Login and Checkout scenarios.

### 8 CI/CD (GitHub Actions)
* **File:** `.github/workflows/deploy.yml`
* I set up a workflow to run the API tests automatically on every push, You can check the **Actions** tab to see the build history.

---

## How to Run the Project
1. Clone the repo: https://github.com/ZaidAlqaryouti2002/QA-Training-Project
2. Install dependencies (for k6 or Newman).
3. Run the scripts using the commands listed above.


---

