package com.stepdefs;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.Pages.Addcustomers;
import com.Pages.LoginPage;
import com.Pages.SearchCustomerPage;

public class Baseclass {
public WebDriver driver;
public LoginPage lp;
public Addcustomers ac;
public SearchCustomerPage sc;

public static String randomsteing() {
	String generatedstring1=RandomStringUtils.randomAlphabetic(5);
	return (generatedstring1);
}
}
