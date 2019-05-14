package com.prakat.Milap.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(id="login-link")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

}
