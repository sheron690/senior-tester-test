# Bug Report 7: Incomplete Session Logout

## Summary
Logging out in one tab does not log out all active sessions on the same device.

## Steps to Reproduce
1. Open two tabs and log in
2. Logout in one tab
3. Check session in the second tab

## Expected Result
All sessions should terminate after logout.

## Actual Result
Second tab remains logged in.
## Screenshots
![image](https://github.com/user-attachments/assets/20ae609b-4745-45e1-b630-fdaa55582b81)
![image](https://github.com/user-attachments/assets/d095ede7-c205-46c1-acb3-43ab1a7ad493)

## Suggested Action
Invalidate sessions across all tabs upon logout.
