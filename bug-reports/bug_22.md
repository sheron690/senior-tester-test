# Bug Report 22: Same User Can Add to Cart From Multiple Sessions

## Summary
Same user can be logged in on multiple tabs and add different items to cart.

## Steps to Reproduce
1. Login on multiple tabs/devices with same user
2. Add different items in each session

## Expected Result
Cart should synchronize across sessions.

## Actual Result
Each session has independent cart state.

## Suggested Action
Restrict or sync session-level cart behavior.
