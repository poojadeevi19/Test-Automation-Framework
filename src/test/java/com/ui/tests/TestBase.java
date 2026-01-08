package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;
    private boolean isHeadless;
    
   @Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the Home page of the website")
	public void setup(
			@Optional("CHROME") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless,ITestResult result) {
		
    	this.isLambdaTest=isLambdaTest;
    	WebDriver lambdaDriver;
		if(isLambdaTest) {
			 
			lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser,result.getMethod().getMethodName()); 
			homePage =new HomePage(lambdaDriver);
			
		}
		else {
			//running the test on local machine!!!!
		logger.info("Load the Homepage of the Website");
		homePage = new HomePage(Browser.valueOf(browser), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Team Down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
		homePage.getDriver().quit();
		}
	}
}
