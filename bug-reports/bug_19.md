# Bug Report 19:Checkout Fields Accept Special Characters

## Summary
Special characters and spaces can be entered in name and postcode fields.

## Steps to Reproduce
1. Go to checkout
2. Enter symbols in First Name, Last Name, and Postcode

## Expected Result
Form should accept only valid alphanumeric input.

## Actual Result
All special characters are accepted.
## Screenshots
![image](https://github.com/user-attachments/assets/a59d4c70-00a7-4e2d-a881-b6145d71b92e)
![image](https://github.com/user-attachments/assets/f47b76f4-f660-4bb6-a73d-bffd81d6cade)

## Suggested Action
Add frontend and backend input validation.
