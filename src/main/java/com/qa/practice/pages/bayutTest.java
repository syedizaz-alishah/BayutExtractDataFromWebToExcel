package com.qa.practice.pages;



/*Author  
 * 
 * Engr Syed Izaz Ali Shah
 * 
 * */


import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.testBase.testBase;
import com.qa.practice.utility.TestUtil;
import com.qa.practice.utility.Xls_Reader;

public class bayutTest extends testBase {
	
	TestUtil TestUtilObj = new TestUtil();
	// Page Factory	
	
	@FindBy(css=".a41c4dcc.FilterDesign2022.b8ab28f4")
	public
	WebElement locationSearchFiled;
	
	@FindBy(css=".c3901770.f6d94e28.FilterDesign2022")
	public
	WebElement findButton;
	
	@FindBy (xpath="//a[contains(@aria-label,'Listing phone number')]/span")
	WebElement phoneNumber;
	
	@FindBy(css=".eae3ed68.bacd4915")
	WebElement crossButton;
	
	
	
	@FindBy (xpath="//div[@title='Next']")
	WebElement nextButton;
	
	
	public bayutTest()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void collectDataIntoExcelSheetValidation() throws Exception
	{
		int k=1;
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\practice\\qa\\testData\\test.xlsx");
		
		if(!reader.isSheetExist("Sheet1"))
		{
			reader.addSheet("Sheet1");
			
		}
		reader.addColumn("Sheet1", "Phone Numbers");
		
		
		clickOn(locationSearchFiled);
		locationSearchFiled.sendKeys("Dubai");
		clickOn(findButton);
		int z=2;
		do
		{
			int m =k-1;
			
			String phoneNumberValue="";
			System.out.println("\n ************************* I am On Page "+k);
			List <WebElement> totlaCallButtons = driver.findElements(By.cssSelector("._85d9f2e2._4dbe9da8"));
			for (int i=0;i< totlaCallButtons.size();i++)
			{
				int j =i+1;
				clickOn(driver.findElement(By.xpath("(//button[contains(.,'Call')])["+j+"]")));
				phoneNumberValue=phoneNumber.getText();
				
				reader.setCellData("Sheet1", "Phone Numbers", z, phoneNumberValue);
				//TestUtilObj.writeExcel("C:\\\\Users\\\\Mark XLVII\\\\eclipse-workspace\\\\PracticeTest\\\\src\\\\main\\\\java\\\\com\\\\practice\\\\qa\\\\testData\\\\test\\\\BayutContact.xlsx",phoneNumberValue , z,0);
				//System.out.println( phoneNumber.getText());
				crossButton.click();
				z++;
				
			}
			k++;
			clickOn(driver.findElement(By.xpath("//div[contains(@title,'Page "+k+"')]")));
			
		}
		while(k<=10);
		
	}
	
	

}
