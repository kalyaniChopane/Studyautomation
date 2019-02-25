package com.automation.org.studyAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequiredInfo {
	
	@FindBy(name="customfield[1]")
	WebElement Field;
	
	@FindBy(name="customfield[2]")
	WebElement mobilefiled;
	
	WebDriver driver;
	public RequiredInfo(WebDriver driver5) {
		driver=driver5;
		PageFactory.initElements(driver, this);
	}
	public void infophpMethod()
	{
		Select findus=new Select(Field);
		findus.selectByVisibleText("Google");
		
		mobilefiled.sendKeys("7832190230");
		
	}

}
