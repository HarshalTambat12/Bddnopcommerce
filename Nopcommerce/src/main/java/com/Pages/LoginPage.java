package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver ldriver;
public LoginPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
@FindBy(id="Email")
public WebElement email;
@FindBy(id="Password")
public WebElement pass;
@FindBy(linkText="Logout")
public WebElement logout;
@FindBy(tagName="button")
public WebElement button;

public void setUserName(String uname) {
	email.clear();
	email.sendKeys(uname);
}
public void setPassword(String pwd) {
	pass.clear();
	pass.sendKeys(pwd);
}
public void clickloginbutton() {
	button.click();
}
public void clicklogout() {
	logout.click();
}

}
