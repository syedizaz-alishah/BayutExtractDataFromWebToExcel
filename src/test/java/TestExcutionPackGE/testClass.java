package TestExcutionPackGE;

/*Author  
 * 
 * Engr Syed Izaz Ali Shah
 * 
 * */


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.qa.testBase.testBase;
import com.qa.practice.pages.bayutTest;
public class testClass extends testBase{
	
	

		bayutTest bayutPageObj;
		
		public  testClass()
		{
			super();
		}
		
		@BeforeClass
		public void setup()
		{
			initialization();
			bayutPageObj = new bayutTest();
			
		}
		
		@Test()
		public void dataCollectionIntoExcelShetTest() throws Exception
		{
			bayutPageObj.collectDataIntoExcelSheetValidation();
			
		}

	}

