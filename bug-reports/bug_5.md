# Bug Report 5: Concurrent Logins Allowed from Multiple Devices

## Summary
Same user account can be logged in concurrently from multiple devices, windows, or tabs.
## Steps to Reproduce
1. Login with the same user on two different browsers/devices.

## Expected Result
Restrict to a single session per user account.

## Actual Result
Multiple concurrent sessions allowed.
## Screenshots
![image](https://github.com/user-attachments/assets/a3110975-5eee-4603-9b5d-74043fe1f09b)

## Suggested Action
Implement session management to prevent multiple concurrent logins per user.
