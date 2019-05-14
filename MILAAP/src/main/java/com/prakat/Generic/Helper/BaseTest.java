package com.prakat.Generic.Helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.prakat.Milap.Pages.HomePage;
import com.prakat.Milap.Pages.LoggedInHomePage;
import com.prakat.Milap.Pages.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	public  ExcelHelper xlib;
	public  WaitHelper waithelp;
	public  BrowserHelper browhelp;
	public HomePage homePage;
	public LoginPage loginPage;
	public LoggedInHomePage logout;
	
	public static ExtentReports report;
	public static ExtentTest logger;	
	
	@BeforeSuite
	public void setUpSuite() {
		ExtentHtmlReporter extent= new ExtentHtmlReporter("Resources\\Reports\\LearnAutomation.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}	
	
	public static ITestResult getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			

			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
		return result;

	}		
	
	@BeforeTest
	public void beforeTest() throws IOException, Throwable {
		xlib=new ExcelHelper();
		waithelp=new WaitHelper();
		browhelp= new BrowserHelper();
		//homePage= new HomePage(driver);
		// loginPage=new LoginPage(driver);
		//To get the browser type i.e chrome for this
		String browserName=xlib.getExcelData("MMT", 3, 1);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./Resources/drivers/IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
	
		
		//To get the URL from excel
		String applicationURl=xlib.getExcelData("MMT", 2, 1);
		browhelp.navigateToUrl(applicationURl);
		waithelp.implicitWait(20);
		browhelp.maximiseWindow();

	}
	
	@AfterSuite
	public void endReport(){
		report.flush();
}		

}
