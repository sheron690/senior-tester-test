# Bug Report: Login Bug – Locked Out User

## Summary
Login fails for `locked_out_user` with valid credentials.

## Steps to Reproduce
1. Go to https://www.saucedemo.com/v1/
2. Enter username: `locked_out_user`
3. Enter password: `secret_sauce`
4. Click Login

## Expected Result
User should be redirected to inventory page.

## Actual Result
Error message shown: "Sorry, this user has been locked out."

## Suggested Action
Investigate why valid credentials do not permit access; check backend user flag logic.
