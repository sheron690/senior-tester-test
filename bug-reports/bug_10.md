# Bug Report 10: Cart Not Synced Across Sessions

## Summary
Cart contents do not persist across browser sessions or tabs.

## Steps to Reproduce
1. Add items in one browser/tab
2. Login in another browser/tab
3. Cart is empty

## Expected Result
Cart should sync across all sessions for the same user.
## Actual Result
Cart contents are not preserved.
## Screenshots
![image](https://github.com/user-attachments/assets/2d9eef5c-ee2f-418e-a3eb-9e805391527e)
![image](https://github.com/user-attachments/assets/6034d205-b98c-44fe-a62f-c0addf893981)

## Suggested Action
Implement server-side cart persistence.
