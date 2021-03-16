package CalculateTripCost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup{
	
 public static WebDriver driver;
	
 public static WebDriver getDriver(String browserName) throws Exception
	 {
	 
	    if(browserName.equalsIgnoreCase("chrome"))     //chrome browser
	    {
	    	//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();  
		
		}
	    else if(browserName.equalsIgnoreCase("firefox"))   // get firefox browser
	    {
	    	//create firefox instance
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();
	    }
	    else if(browserName.equalsIgnoreCase("Edge"))  //get Edge browser
	    {
	    	//set path to Edge.exe
			System.setProperty("webdriver.edge.driver","driver\\MicrosoftWebDriver.exe");
			//create Edge instance
			driver = new EdgeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("internet explorer"))    //get intenet explorer browser
	    {
	   
	    }   
	    return driver;
	 }
  }
