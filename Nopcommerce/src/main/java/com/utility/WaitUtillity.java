package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtillity {
public WebDriver driver;

public WaitUtillity(WebDriver driver) {
	this.driver=driver;
}

public void WaitforElement(WebElement element,long timeoutInSeconds) {
WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
wait.until(ExpectedConditions.visibilityOf(element));
}
}
