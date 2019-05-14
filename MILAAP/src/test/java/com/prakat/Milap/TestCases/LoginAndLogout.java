package com.prakat.Milap.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.prakat.Generic.Helper.BaseTest;
import com.prakat.Generic.Helper.ConstantHelper;
import com.prakat.Generic.Helper.ScreenshotHelper;
import com.prakat.Milap.Pages.LoggedInHomePage;
import com.prakat.Milap.Pages.HomePage;
import com.prakat.Milap.Pages.LoginPage;
@Listeners(ScreenshotHelper.class)
public class LoginAndLogout extends BaseTest {
	
	@Test
	public void LoginToMMT() throws IOException, Throwable {
		BaseTest.logger=BaseTest.report.createTest("Login to MMT");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		homePage.getLoginLink().click();

		loginPage.login();

		loginPage.getSkipForMobileLink().click();

		//String actTitle = driver.getTitle();
		//Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		//System.out.println("Login success");
		logger.pass("Login success");

	}

	@Test
	public void logout() {
		logout = new LoggedInHomePage(driver);
		logout.logout();
		

	}
	
	  @AfterMethod
	  public void getExtentReports(ITestResult result) {
		  BaseTest.getResult(result);
	  }	

}
