Feature:Login 
@sanity
Scenario:Successful Login with valid Credentials
Given User Launch Chrome Browser
When User opens Url"https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User Enters email as "admin@yourstore.com"and password as "admin"
And Click on login
Then Page Title should be"Dashboard / nopCommerce administration"
When User click on Logout Link
Then Page Title should be"Your store. Login"
And close Browser
@regression
Scenario Outline:Login Data Driven
Given User Launch Chrome Browser
When User opens Url"https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User Enters email as "<emailid>"and password as "<passwd>"
And Click on login
Then Page Title should be"Dashboard / nopCommerce administration"
When User click on Logout Link
Then Page Title should be"Your store. Login"
And close Browser

Examples:
| emailid | passwd |
| admin@yourstore.com | admin |
| admin@gmail.com | admin123 |
