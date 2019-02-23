package com.automation.org.studyAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilitycommon {
	
	WebDriver driver;
	
	public Utilitycommon(WebDriver driver) 
	{
		this.driver=driver;
	}
	public String screenshot(String nameofShot)
	{
		
		TakesScreenshot take=(TakesScreenshot)driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screen\\"+nameofShot+",png";
		File dest=new File(destination);
		try {
			FileUtils.copyFile(source,dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
