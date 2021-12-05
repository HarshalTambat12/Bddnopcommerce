package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomers {
	public WebDriver ldriver;
	public Addcustomers(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	public WebElement CustomersMenu;
	@FindBy(xpath="//li[@class='nav-item has-treeview menu-open']//li[1]//a[1]")
	public WebElement CustomersMenuItem;
	@FindBy(xpath="//a[normalize-space()='Add new']")
	public WebElement Addnew;
	@FindBy(xpath="//input[@id='Email']")
	public WebElement Email;
	@FindBy(xpath="//input[@id='Password']")
	public WebElement Password;
	@FindBy(id="FirstName")
	public WebElement FName;
	@FindBy(id="LastName")
	public WebElement LName;
	@FindBy(xpath="//label[normalize-space()='Male']")
	public WebElement GdrMale;
	@FindBy(xpath="//label[normalize-space()='Female']")
	public WebElement GdrFeMale;
	@FindBy(xpath="//input[@id='DateOfBirth']")
	public WebElement DoB;
	@FindBy(id="Company")
	public WebElement company;
	@FindBy(id="IsTaxExempt")
	public WebElement Tax;
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-border-down']//div[@role='listbox']")
	public WebElement Newsletter;
	@FindBy(id="AdminComment")
	public WebElement AdminComment;
	@FindBy(name="save")
	public WebElement save;
	public void ClickCustomresMenu() {
		CustomersMenu.click();
	}
	public void ClickCustomersMenuItem() {
		CustomersMenuItem.click();
	}
	public void ClickAddnew() {
		Addnew.click();
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setpassword(String pass) {
		Password.click();
	}
	public void setGender(String gender) {
		if (gender.equals("FeMale")) {
			GdrFeMale.click();
			
		}else
			GdrMale.click();
			}
	public void setFirstname(String fname) {
		FName.sendKeys(fname);
	}
	public void setLasttname(String lname) {
		FName.sendKeys(lname);
	}
	public void setDoB(String dob) {
		DoB.sendKeys(dob);
	}
	public void clickonSave() {
		save.click();
	}
	public String getPagetitle() {
		return ldriver.getTitle();
	}
	
	public void setAdminComment(String comment) {
		AdminComment.sendKeys(comment);
	}
}
