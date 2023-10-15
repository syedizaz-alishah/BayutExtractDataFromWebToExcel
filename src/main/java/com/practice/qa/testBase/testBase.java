package com.practice.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.practice.utility.TestUtil;
import com.qa.practice.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Author  
 * 
 * Engr Syed Izaz Ali Shah
 * 
 * */


public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static com.aventstack.extentreports.ExtentReports extent;
	public static com.aventstack.extentreports.ExtentTest test;
	public static Set <String> handler;
	public static List<String> list;

	
	
	public testBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\practice\\qa\\config\\environmental.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//driver= (ThreadLocal<WebDriver>) driver1();
		PageFactory.initElements(driver, this);
	}


	public static void initialization(){
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\com\\dillners\\qa\\config\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		// to run in headless set true
		co.setHeadless(false);
	    driver= WebDriverManager.chromedriver().capabilities(co).create();
		
		e_driver = new EventFiringWebDriver((WebDriver) driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);

		try
		{
			driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			driver.get(prop.getProperty("url"));

		}


	}
	public static void clickOn(WebElement element)
	{


		new WebDriverWait(driver,TestUtil.WAIT_FOR_ELEMENT).ignoring(Exception.class).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}


}
