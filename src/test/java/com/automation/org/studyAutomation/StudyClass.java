package com.automation.org.studyAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class StudyClass {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	@Test
	public void start() throws IOException 
	{
		Utilitycommon utility=new Utilitycommon(driver);
		
		AutomationStudy auto=new AutomationStudy(driver,test);
		auto.SignMethod();
		
		
		try {
			UpdateDetails filldata=new UpdateDetails(driver);
			filldata.FillFormauto();
		} catch (IOException e) 
		{
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot("newway")).build();
			test.fail("Error in Details", mediaModel);
		}
		RequiredInfo requiredd=new RequiredInfo(driver);
		requiredd.infophpMethod();
		
	}
	
	@Parameters("browser")
	@BeforeTest
	public void middle(String value)
	{
	String bro=value;
	
	ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("Resource//htmlreport.html");
	htmlreporter.config().setTheme(Theme.STANDARD);
	htmlreporter.config().setChartVisibilityOnOpen(true);
	htmlreporter.setAppendExisting(true);
	
	extent=new ExtentReports();
	extent.attachReporter(htmlreporter);
	
	test=extent.createTest("chopanekalyani"+value);
	test.info("Start My new Test");
	
	
	if (bro.equalsIgnoreCase("chrome")) 
	{
		System.setProperty("webdriver.chrome.driver", "Resource//chromedriver.exe");
		driver=new ChromeDriver();
		test.info("Chrome Browser Started");
	} 
	else if (bro.equalsIgnoreCase("firefox")) 
	{
		System.setProperty("webdriver.gecko.driver", "Resource//geckodriver.exe");
		driver=new FirefoxDriver();
	} 
	else if (bro.equalsIgnoreCase("ie")) 
	{
		System.setProperty("webdriver.ie.driver", "Resource//IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	} 
	else 
	{
		throw new RuntimeException("Please provide correct browser name");
	}
	test.info("Maximized browser");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://phptravels.org/register.php");
	
	}
	@AfterTest
	public void end()
	{
		test.info("Execution End");
		driver.quit();
	}
	@AfterSuite
	public void aftersuite()
	{
		extent.flush();
	}
}
