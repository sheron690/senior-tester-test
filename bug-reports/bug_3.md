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

## Suggested Action
Provide specific error message indicating the actual issue.
