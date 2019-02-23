package com.automation.org.studyAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class AutomationStudy {
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(css="input[name='firstname']")
	WebElement FirstName;
	
	@FindBy(css="input[name='lastname']")
	WebElement Lastname;
	
	@FindBy(id="inputEmail")
	WebElement Email;
	
	@FindBy(name="phonenumber")
	WebElement phonenumber;
	
	public AutomationStudy(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public AutomationStudy(WebDriver driver2,ExtentTest test) {
		driver=driver2;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	public void SignMethod() throws IOException {
		// TODO Auto-generated method stub
		
		//Assert.assertEquals(driver.getTitle(), "Register - PHPTRAVELS");//hard assert
		
		ExcelRead read=new ExcelRead();
		String[] myvalue=read.readExceldata();
		
		FirstName.sendKeys(myvalue[0]);
		Lastname.sendKeys(myvalue[1]);
		Email.sendKeys(myvalue[2]);
		phonenumber.sendKeys("7217944832");
	}

}
