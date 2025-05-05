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

## Suggested Action
Apply proper input validation for the postcode field.
