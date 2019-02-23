package com.automation.org.studyAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
public String[] readExceldata() throws IOException {
		
		File f=new File("Resource/Book.xlsx");
		FileInputStream fis= new FileInputStream(f);
		
		XSSFWorkbook exc= new XSSFWorkbook(fis);
		XSSFSheet sh= exc.getSheet("selenium");
		
		String company= sh.getRow(1).getCell(0).getStringCellValue();
		
		String strrtadd= sh.getRow(1).getCell(1).getStringCellValue();
		
		String citytest= sh.getRow(1).getCell(2).getStringCellValue();
		
		System.out.println(company+" "+strrtadd+" "+citytest);
		
		
		String [] values= new String[3];
		values[0]=company;
		values[1]=strrtadd;
		values[2]=citytest;
		
		exc.close();
		fis.close();
		
		return values;
	}



}
