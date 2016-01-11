package com.totalwine.test.grid;

/*
 * Web Account Registration Workflow
 * Workflow:
 *  
 * Technical Modules:
 * 	1. BeforeMethod (Test Pre-requisites):
 * 			Invoke webdriver
 * 			Maximize browser window
 * 	2. Test (Workflow)
 * 	3. AfterMethod
 * 			Take screenshot, in case of failure
 * 			Close webdriver
 * 	4. AfterClass
 * 			Quit webdriver
 */


import java.io.IOException;
import java.net.URL;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.totalwine.test.config.ConfigurationFunctions;

public class EmailSignup {
	WebDriver driver;
	
	@DataProvider(name="EmailSignup")
    public Object[][] createData() {
    	Object[][] retObjArr=ConfigurationFunctions.getTableArray(ConfigurationFunctions.resourcePath,"EmailSignup", "emailaddresses");
        return(retObjArr);
    } 
	@BeforeMethod
	  public void setUp() throws Exception {
	    DesiredCapabilities cap = DesiredCapabilities.firefox();
	    cap.setBrowserName("firefox");
	    cap.setPlatform(Platform.VISTA);
	    driver = new RemoteWebDriver(new URL("http://10.125.22.123:5566/wd/hub"),cap); //Hub URL
	  }  
	
	@Test (dataProvider = "EmailSignup")
	public void RegistrationTest (String email) throws InterruptedException, BiffException, IOException {
		//String [] emailAddresses = {"automate1@totalwine.com","automate2@totalwine.com","automate3@totalwine.com","automate4@totalwine.com"};
		driver.get(ConfigurationFunctions.locationSet+"71.193.51.0");
		Thread.sleep(2000);
		driver.findElement(By.id("btnYes")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#email-signup-overlay-new-site > div.modal-dialog > div.modal-content > div.modal-body > p.close > a.btn-close")).click();
	    Thread.sleep(2000);
    	driver.findElement(By.cssSelector("span.footer-Email-text.analyticsJoinOurEmail")).click();
    	Thread.sleep(2000);
    	driver.switchTo().frame(driver.findElement(By.id("iframe-signup-overlay")));
	    driver.findElement(By.id("emailAnonomous")).clear();
	    driver.findElement(By.id("emailAnonomous")).sendKeys(email);
	    driver.findElement(By.id("checkEmailAnonomous")).clear();
	    driver.findElement(By.id("checkEmailAnonomous")).sendKeys(email);
	    //driver.findElement(By.cssSelector("label")).click();
	    driver.findElement(By.id("check_box_100")).click();
	    //driver.findElement(By.id("emailuserregister")).click();
	    Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(By.id("emailuserregister"))).doubleClick().build().perform(); //Double-click
	    Thread.sleep(2000);
	}
}
