Feature:Customres

Background:Below are common steps for every scenario
Given User Launch Chrome Browser
When User opens Url"https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User Enters email as "admin@yourstore.com"and password as "admin"
And Click on login
Then User can view Dashboard
@sanity
Scenario:Add new Customer
When User click on customers Menu
And User Click on customers MenuItem
And User click on Add new button
Then User can view Add new Customerpage
When User Enters Customer info
And click on save button
Then User can View Confirmation message "The new customer has been added successfully"
And close Browser
@regression
Scenario:Search Customer by Emailid
When User click on customers Menu
And User Click on customers MenuItem
And User Enter Customer Email
When Click on search Button
Then User found Email in Search table
And close Browser
@regression
Scenario:Search Customer by Name
When User click on customers Menu
And User Click on customers MenuItem
And User Enter Firstname
And User Enter LastName
When Click on search Button
Then User found Name in Search table
And close Browser

