package com.automation.org.studyAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class UpdateDetails {
	
	WebDriver driver;

	@FindBy(name="companyname")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@name='address1'and @type='text']")
	WebElement Streetaddress;
	
	@FindBy(name="city")
	WebElement citytextbox;
	
	@FindBy(id="stateinput")
	WebElement statetextbox;
	public UpdateDetails(WebDriver driver3) 
	{
		driver=driver3;
		PageFactory.initElements(driver, this);
	}
	public void FillFormauto() throws IOException
	{
		
		
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals(driver.getTitle(), "");
		CompanyName.sendKeys("cognizant");
		Streetaddress.sendKeys("abc chowk");
		citytextbox.sendKeys("pune");
		statetextbox.sendKeys("MP");
		//soft.assertAll();
		
	}

}
