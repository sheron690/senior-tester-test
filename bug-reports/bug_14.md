# Bug Report 14: Invalid Postcode Accepted During Checkout

## Summary
The checkout form accepts any value for the postcode field, without validation.

## Steps to Reproduce
1. Proceed to checkout
2. Enter symbols or text into the postcode field

## Expected Result
Form should restrict input to valid postcode formats.

## Actual Result
Any characters are accepted, including invalid entries.
## Screenshots
![image](https://github.com/user-attachments/assets/38afb078-1794-46b6-97d6-a5881c5d3297)
![image](https://github.com/user-attachments/assets/b3c963aa-f22e-4c6d-8569-73cb706b3072)

## Suggested Action
Apply proper input validation for the postcode field.
