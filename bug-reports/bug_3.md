# Bug Report 3: Incorrect Error Message for Wrong Password

## Summary
Error message misleadingly states that both username and password are incorrect.

## Steps to Reproduce
1. Go to https://www.saucedemo.com/v1/
2. Enter a valid username
3. Enter an incorrect password
4. Click Login

## Expected Result
Message should indicate password is incorrect.

## Actual Result
Displays: "Epic sadface: Username and password do not match any user in this service."
## Screenshots
![image](https://github.com/user-attachments/assets/b3f1f7c5-b91b-48e5-853e-b1717229995c)

## Suggested Action
Provide specific error message indicating the actual issue.
