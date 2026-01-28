# QA Capstone Project - HTU Training

**Name:** Zaid Alabed  
**Role:** QA Trainee  
**Date:** Feb 2026  

---

## Project Overview
This repository contains my final project deliverables. The goal was to test the **Swag Labs** website (UI) and **DummyJSON** (API) using Manual and Automated testing tools.

The project covers 8 main requirements as requested.

---

## Deliverables & Files

### 1. Test Plan
* **File:** `Test Plan.pdf`
* Contains the scope, tools, risk analysis, and strategy for the project.

### 2. Manual Test Cases
* **File:** `Manual Test Cases.xlsx`
* Includes 20+ test cases covering the full shopping scenario (Login > Add to Cart > Checkout). Status (Pass/Fail) is recorded in the file.

### 3. Defect Log (Bugs)
* **File:** `Bug reports saucedemo.xlsx`
* List of **8 bugs** found during testing (mostly related to `problem_user`). Includes steps to reproduce and severity.

### 4. API Automation (Postman)
* **Collection:** `apitest.json`
* **Environment:** `env.json`
* **Data File:** `users.csv`
* I created a collection covering GET, POST, PUT, and DELETE requests. The tests verify status codes and response times.
* **To run:** `newman run apitest.json -e env.json -d users.csv -n 5`

### 5. Newman Report
* The HTML report is generated automatically via GitHub Actions (see section 8) or can be run locally using the command above.

### 6. Performance Testing (k6)
I ran a load test on the DummyJSON API to check stability.
* **Script:** `load.js`
* **Command:** `k6 run load.js`
* **Configuration:** 15 Users for 30 seconds.

**Test Results:**
* **Errors:** 0.00% (Passed).
* **Response Time (p95):** 323ms.
* **Status:** The API handled the load successfully.

### 7. UI Automation
* **Folder:** `/SauceDemo Selenium automation`
* Contains Selenium/Cypress scripts for Login and Checkout scenarios.

### 8. CI/CD (GitHub Actions)
* **File:** `.github/workflows/deploy.yml`
* I set up a workflow to run the API tests automatically on every push. You can check the **Actions** tab to see the build history.

---

## How to Run the Project
1. Clone the repo: `git clone <repo-url>`
2. Install dependencies (for k6 or Newman).
3. Run the scripts using the commands listed above.

---