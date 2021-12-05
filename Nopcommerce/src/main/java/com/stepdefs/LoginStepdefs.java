package com.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pages.Addcustomers;
import com.Pages.LoginPage;
import com.Pages.SearchCustomerPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepdefs extends Baseclass {
public WebDriver driver;
public LoginPage lp;

@Given("^User Launch Chrome Browser$")
public void user_Launch_Chrome_Browser() throws Throwable {
    System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    driver=new ChromeDriver();
   // driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");	
	lp=new LoginPage(driver);
}

@When("^User opens Url\"([^\"]*)\"$")
public void user_opens_Url(String url) throws Throwable {
	driver.get(url);	
}

@When("^User Enters email as \"([^\"]*)\"and password as \"([^\"]*)\"$")
public void user_Enters_email_as_and_password_as(String Email, String Pass) throws Throwable {
    lp.setUserName(Email);
    lp.setPassword(Pass);
}

@When("^Click on login$")
public void click_on_login() throws Throwable {
    lp.clickloginbutton();
}

@Then("^Page Title should be\"([^\"]*)\"$")
public void page_Title_should_be(String title) throws Throwable {
    if (driver.getPageSource().contains("Login was unsuccessful")) {
		driver.close();
		Assert.assertTrue(false);
	}else {
		Assert.assertEquals(title, driver.getTitle());
	}
		
}

@When("^User click on Logout Link$")
public void user_click_on_Logout_Link() throws Throwable {
   lp.clicklogout();
   Thread.sleep(3000);
}

@Then("^close Browser$")
public void close_Browser() throws Throwable {
   driver.close();
}

//---------------Addcustomerspage steps--------------------------
@Then("^User can view Dashboard$")
public void user_can_view_Dashboard() throws Throwable {
   ac=new Addcustomers(driver);
   Assert.assertEquals("Dashboard / nopCommerce administration", ac.getPagetitle());
}

@When("^User click on customers Menu$")
public void user_click_on_customers_Menu() throws Throwable {
    Thread.sleep(3000);
    ac.ClickCustomresMenu();
}

@When("^User Click on customers MenuItem$")
public void user_Click_on_customers_MenuItem() throws Throwable {
   Thread.sleep(3000);
   ac.ClickCustomersMenuItem();
}

@When("^User click on Add new button$")
public void user_click_on_Add_new_button() throws Throwable {
   ac.ClickAddnew();
   Thread.sleep(2000);
}

@Then("^User can view Add new Customerpage$")
public void user_can_view_Add_new_Customerpage() throws Throwable {
    Assert.assertEquals("Add a new customer / nopCommerce administration", ac.getPagetitle());
  
}

@When("^User Enters Customer info$")
public void user_Enters_Customer_info() throws Throwable {
	
 String email=randomsteing()+"@gmail.com";   
 ac.setEmail(email);
 ac.setpassword("test1234");
 ac.setFirstname("Kiran");
 ac.setLasttname("java");
 ac.setGender("Male");
 ac.setDoB("05/22/1987");
 ac.setAdminComment("This is for Testing.........");
}

@When("^click on save button$")
public void click_on_save_button() throws Throwable {
    ac.clickonSave();
}

@Then("^User can View Confirmation message \"([^\"]*)\"$")
public void user_can_View_Confirmation_message(String arg1) throws Throwable {
    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
}
//-------------------searchcustomer by emailid----------------
@When("^User Enter Customer Email$")
public void user_Enter_Customer_Email() throws Throwable {
    sc=new SearchCustomerPage(driver);
    sc.setEmail("victoria_victoria@nopCommerce.com");
}

@When("^Click on search Button$")
public void click_on_search_Button() throws Throwable {
   sc.clickonsearch();
   Thread.sleep(3000);
}

@Then("^User found Email in Search table$")
public void user_found_Email_in_Search_table() throws Throwable {
    boolean status=sc.searchCustomerbyEmail("victoria_victoria@nopCommerce.com");
    Assert.assertEquals(true, status);
}
//---------------------------searchcustomerby Name---------------------
@When("^User Enter Firstname$")
public void user_Enter_Firstname() throws Throwable {
	 sc=new SearchCustomerPage(driver);
	 sc.setFirstName("Victoria");
}

@When("^User Enter LastName$")
public void user_Enter_LastName() throws Throwable {
   sc.setLastName("Terces");
}

@Then("^User found Name in Search table$")
public void user_found_Name_in_Search_table() throws Throwable {
   boolean act=sc.Searchuserbyname("Victoria Terces");
   Assert.assertEquals(true, act);
}

}
