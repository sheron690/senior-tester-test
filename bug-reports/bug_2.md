# Bug Report 2: Incomplete Error Message When Both Username and Password Are Missing

## Summary
Login form only reports the absence of the username and ignores missing password input.

## Steps to Reproduce
1. Go to https://www.saucedemo.com/v1/
2. Leave both username and password fields blank
3. Click on the "Login" button

## Expected Result
Error messages indicating that both username and password are required.

## Actual Result
Only "Epic sadface: Username is required" message is displayed.
## Screenshots
![image](https://github.com/user-attachments/assets/37a7cc23-59da-4ac9-8fb6-2f569a1e64cb)

## Suggested Action
Update validation logic to check and display all missing required fields.
