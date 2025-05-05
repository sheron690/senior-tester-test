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

## Suggested Action
Invalidate sessions across all tabs upon logout.
