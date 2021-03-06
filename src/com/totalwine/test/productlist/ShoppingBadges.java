package com.totalwine.test.productlist;

import org.testng.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//BrowserStack Imports
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ShoppingBadges {
	
	public String baseURL="http://twmuatwebserver:webserveruattwm@23.253.140.185";
	public String locationSet = "http://twmuatwebserver:webserveruattwm@23.253.140.185/?remoteTestIPAddress=69.49.175.214";
	public WebDriver driver;
	
	 @BeforeClass
	  public void setUp() throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
		    /*caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "11.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1024x768");*/
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "10.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "8");
		    caps.setCapability("resolution", "1024x768");
		    caps.setCapability("browserstack.debug",true);
	    driver = new RemoteWebDriver(new URL("http://rajat43:nF9GrzCFjj3zjy692675@hub.browserstack.com/wd/hub"),caps);
	    driver.get(locationSet);
		driver.findElement(By.id("btnYes")).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector("#email-signup-overlay-new-site > div.modal-dialog > div.modal-content > div.modal-body > p.close > a.btn-close")).click();
		   
	  }  
	/*
	@Test
	public void setUpTest () throws InterruptedException {
		//webdriver code to access website and setup NM store
		//driver = new FirefoxDriver();
		driver.get(locationSet);
		driver.findElement(By.id("btnYes")).click();
	    //driver.findElement(By.id("btnSelectLocation")).click();
	    //driver.findElement(By.id("newStoreSearch_box")).clear();
	    //driver.findElement(By.id("newStoreSearch_box")).sendKeys("NM");
	    //driver.findElement(By.cssSelector("button[class=\"btn-red btn store-finder\"]")).click();
	    //Thread.sleep(5000);
	    //driver.findElement(By.id("changeStoreBtn")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector("#email-signup-overlay-new-site > div.modal-dialog > div.modal-content > div.modal-body > p.close > a.btn-close")).click();
	    //Assert.assertEquals("Albuquerque (Uptown), NM", driver.findElement(By.cssSelector("span.store-details-store-name.flyover-src")).getText());

	}*/
	
	@Test 
	//In Stock in Current Store, Nearby Store and IFC
	public void isCSisNSisIFC () throws InterruptedException {
		//ATY:Both
		driver.get("http://23.253.140.185/wine/rose-blush-wine/c/013055?pagesize=48&lasttabname=aty_both&sort=most-popular&q=%3A35.104338%2C-106.5700392%3A517%3Amost-popular%3AstoreName%3A1302%3AbrandName%3AArmani&tab=aty_both&viewall=false");
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-ship-avail.js-ship-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-pickup-avail.js-pick-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
			
		//ATY:ShipTo
		driver.get("http://23.253.140.185/wine/rose-blush-wine/c/013055?tab=aty_shipping&viewall=true&q=:35.104338,-106.5700392:517:most-popular:storeName:1302:brandName:Armani&pagesize=48&sort=most-popular");
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-ship-avail.js-ship-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-pickup-avail.js-pick-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");

		//ATY:ISP
		driver.get("http://23.253.140.185/wine/rose-blush-wine/c/013055?tab=aty_isp&viewall=true&q=:35.104338,-106.5700392:517:most-popular:storeName:1302:brandName:Armani&pagesize=48&sort=most-popular");
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-ship-avail.js-ship-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-pickup-avail.js-pick-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");

		//FC
		driver.get("http://23.253.140.185/wine/rose-blush-wine/c/013055?pagesize=48&lasttabname=fullcatalog&sort=most-popular&q=%3A35.104338%2C-106.5700392%3A12750%3Amost-popular%3AbrandName%3AArmani&tab=fullcatalog&viewall=true");
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-ship-avail.js-ship-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
		Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-pickup-avail.js-pick-avail > img")).isDisplayed(),true,"isIFC Badge is not properly displayed");
	
	}
	
	@Test 
	//In Stock in Current Store, OOS in  Nearby Store and in stock in IFC
	public void isCSooNSisIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//OOS in Current Store, in stock in Nearby Store and IFC
	public void oosCSisNSisIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test
	//OOS in Current Store, Nearby Store and in stock IFC
	public void oosCSoosNSisIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//In Stock in Current Store, Nearby Store and OOS in IFC
	public void isCSisNSoosIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//In Stock in Current Store, OOS in Nearby Store and IFC
	public void isCSoosNSoosIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//OOS in Current Store, in stock in Nearby Store and OOS in IFC
	public void oosCSisNSoosIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//OOS in Current Store, Nearby Store and IFC
	public void oosCSoosNSoosIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test
	//Not Carried in in Current Store, Nearby Store and IFC
	public void ncCSncNSncIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//Not carried in Current Store, OOS in Nearby Store and in stock IFC
	public void ncCSoosNSisIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//Not carried in Current Store, Nearby Store and in stock IFC
	public void ncCSncNSisIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//In Stock in Current Store, Nearby Store and not carried in IFC
	public void isCSisNSncIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@Test 
	//OOS in Current Store, Nearby Store and not carried in IFC
	public void oosCSoosNSncIFC () {
		//webdriver code
		//testNG assertion
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
