package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger =LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[normalize-space()='Sign in']");
    
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() { // page funtions .......can't use void 
		logger.info("trying to performing click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}
	
	
	
}
