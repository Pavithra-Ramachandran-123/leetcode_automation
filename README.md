Demo Recording : https://drive.google.com/file/d/1rPDGjqmo9uZq272gaIIRF528REu-0La2/view?usp=sharing

# Leetcode Automation Project

## About
LeetCode is a leading online platform designed to help individuals enhance their coding skills and prepare for technical interviews. This project automates tests to verify URLs, retrieve question details, and ensure the functionality of the LeetCode website.

---

## Tools Used
- **Java**
- **Selenium**
- **Gradle**

---

## Project Structure
- `TestCases.java`: Contains individual test cases.
- `App.java`: The entry point for executing automation scripts.

---

## Test Cases

### TestCase01: Verify LeetCode Homepage URL
**Description:** Ensure the homepage URL contains "leetcode".

**Test Steps:**
1. Navigate to [LeetCode](https://leetcode.com/).
2. Verify the URL contains "leetcode".

**Expected Result:** The homepage URL contains "leetcode".

---

### TestCase02: Verify Problem Set URL and Display First 5 Questions
**Description:** Retrieve and verify the details of the first 5 problems.

**Test Steps:**
1. Click on the "Questions" link.
2. Verify the URL contains "problemset".
3. Retrieve and print the first 5 question titles.
4. Confirm the first question is "Two Sum".

**Expected Result:** Correct details of the first 5 questions are displayed.

---

### TestCase03: Verify the Two Sum Problem
**Description:** Open the "Two Sum" problem and verify the URL.

**Test Steps:**
1. Open the "Two Sum" problem.
2. Verify the URL contains "two-sum".

**Expected Result:** The URL contains "two-sum".

---

### TestCase04: Verify Submissions Tab
**Description:** Ensure the submissions tab displays "Register or Sign In".

**Test Steps:**
1. Click on the submissions tab.
2. Verify the message "Register or Sign In" is displayed.

**Expected Result:** The message "Register or Sign In" appears.

---

## How to Run the Tests
1. Clone the repository.
2. Install dependencies using `gradle build`.
3. Execute the tests using `gradle test`.

---


