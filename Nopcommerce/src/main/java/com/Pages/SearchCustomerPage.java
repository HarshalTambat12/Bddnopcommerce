package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.WaitUtillity;

public class SearchCustomerPage {
public WebDriver ldriver;
WaitUtillity wu;
public SearchCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	wu =new WaitUtillity(ldriver);
}

@FindBy(id="SearchEmail")
public WebElement SearchEmail;
@FindBy(id="SearchFirstName")
public WebElement sfname;
@FindBy(id="SearchLastName")
public WebElement slname;
@FindBy(id="search-customers")
public WebElement search;
@FindBy(xpath="//*[@id='customers-grid_wrapper']")
public WebElement table;

@FindBy(xpath="//*[@id='customers-grid']/tbody/tr")
public List<WebElement> tablerow;
@FindBy(xpath="//*[@id='customers-grid']/tbody/tr/td")
public List<WebElement> tablecoloumn;


public void setEmail(String email) {
	wu.WaitforElement(SearchEmail, 20);
	SearchEmail.clear();
	SearchEmail.sendKeys(email);
}
public void setFirstName(String fname) {
	wu.WaitforElement(sfname, 20);
	sfname.clear();
	sfname.sendKeys(fname);
}

public void setLastName(String lname) {
	wu.WaitforElement(slname, 20);
	slname.clear();
	slname.sendKeys(lname);
}

public void clickonsearch() {
	search.click();
}
public int getnoofrows() {
	return(tablerow.size());
}

public int getnoofcoloumns() {
	return(tablecoloumn.size());
}


public boolean searchCustomerbyName(String Name) {
	boolean flag=false;
	
	for (int i=1;i<getnoofrows();i++) 
	{
		String name=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
		System.out.println(name);
		
	
	String names[]=name.split("");
		if (names[0].equals("Victoria") && names[1].equals("Terces"))
		{
			flag=true;
			
		}
		
	}
	return flag;
}
	
	
public boolean Searchuserbyname(String Name) {
	String name=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[3]")).getText();
	System.out.println(name);
	if (name.contains(Name)) {
		return true;
	}else
		return false;
}


/*
 * public boolean searchCustomerbyEmail(String email) { boolean flag=false;
 * for(int i=1;i<getnoofrows();i++) { String emailid
 * =table.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[2]"
 * )).getText(); System.out.println(emailid); if (emailid.equals(email)) {
 * return true; } //*[@id="customers-grid"]/tbody/tr/td[2]
 * 
 * 
 * } return flag; }
 */

public boolean searchCustomerbyEmail(String email) {
	String emailid=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
	System.out.println(emailid);
	if (emailid.equals(email)) {
		return true;
		
	}
	else 
		return false;
}





}
