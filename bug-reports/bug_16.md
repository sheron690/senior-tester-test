# Bug Report 16: Checkout Permits Order with Empty Cart

## Summary
Users are allowed to place an order even if no items are present in the cart.

## Steps to Reproduce
1. Visit the site
2. Go directly to checkout without adding items
3. Attempt to complete order

## Expected Result
User should be prevented from checking out with an empty cart.

## Actual Result
Checkout completes without warning or item validation.
## Screenshots
![image](https://github.com/user-attachments/assets/57fd97f9-d707-46ee-881b-392e942a56ed)

## Suggested Action
Add cart validation before proceeding to checkout confirmation.
