package CalculateTripCost;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class ValidateAll {
	public static WebDriver driver;
	public static ArrayList<String> arr = new ArrayList<String>();
	public static ArrayList<String> arr1 = new ArrayList<String>();
	public static ArrayList<String> arr2 = new ArrayList<String>();

	@Test
	public void validateToOpenWebsite() throws IOException
	{
		try {
			driver=DriverSetup.getDriver("chrome");  // for getting chrome driver
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	//To get Tripadvisor Website
		
	String expectedTitle = "Tripadvisor Official Site";
	String url = "https://www.tripadvisor.in/";
	driver.get(url);
	if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
	  System.out.println("Web page is opened");
	}
	else{
	  System.out.println("Web page could not open.");
	}
	
   }
	@Test
	public void screenMaximize()
	{
		driver.manage().window().maximize();
	}

	@Test
	
	public void goToHolidayHomePage()    //to go holiday page And search Nairobi Location
	{
		driver.findElement(By.xpath("//span[text()='Holiday Homes']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement page=driver.findElement(By.xpath("/html/body/div[2]/div/form/input[1]"));
		page.sendKeys("Nairobi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//div[text()='Nairobi']")).click();
	}
	
	
	@Test
	public void validateNirobiPage()
	{
		String expectedTitle = "THE 10 BEST Nairobi Houses, Apartments of 2021 | Tripadvisor - Book Villas in Nairobi, Kenya";
		if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
		  System.out.println("Nairobi page is opened");
		}
		else{
		  System.out.println("Nairobi page could not open.");
		}
			
	}
	@Test
	
	//     sorting hotels by hight rating on top
	public void sortByHighRating()
	{
		driver.findElement(By.xpath("//span[text()='Tripadvisor Sort']")).click();
		driver.findElement(By.xpath("//span[text()='Price: High to Low']")).click();		
	}

	@Test
	
	//date send to holiday home page
	public void calculateTripCost()
	{
        	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]")).click();
	      driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/div/div/div[2]/div/div[3]/div[3]/div[2]")).click();
	      driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[3]/div[5]")).click();
	}
	
	
	@Test
	public void displayAllHotels()
	{
		
		List<WebElement> hotelNames=new ArrayList<>();	
		List<WebElement> hotelPricePerNight=driver.findElements(By.className("_33TIi_t4"));
		List<WebElement> totalAmount=driver.findElements(By.className("_3f9mHAKH"));
		 int listsize= hotelPricePerNight.size();
		 int listsize1=hotelNames.size();
		 hotelNames=driver.findElements(By.className("_2K0y-IXo"));
		 
		 System.out.print("Htel Names"+"     ");
		 System.out.print("Hotel Prices Per Night"+"     ");
		 System.out.println("Total Amount for 3 Holiday Night");
			
		 
		 // get hotel names
		 for(WebElement e: hotelNames)
		 {
			 arr1.add(e.getText());
				 
		 }
		 
		 // get hotel price per night
		 for(WebElement e1: hotelPricePerNight)
		 {
			 arr.add(e1.getText());
				 
		 }
		  
		 //get total amount of hotels for 3 night
		 for(WebElement e2: totalAmount)
		 {
			 arr2.add(e2.getText());
				 
		 }
		
		   for(int i=0;i<100;i++)       //display charges per night and total amount for 3 night
		 {
			  if(i*2<100)
			  {
			  System.out.print(arr1.get(i*2)+"  ");     //display hotel names
			  }
			 if(i<50)
			 {
			  System.out.print(arr.get(i)+"  ");      //display charges per night
			  
			  System.out.println(arr2.get(i));      //display total amount for 3 night
			 }
		
			}
		}
	@Test
	public void pickCruiseLine()
	{
		driver.findElement(By.xpath("//span[text()='Cruises']")).click();
		String expectedTitle = "Cruises - Cheap Cruise Holidays: 2021 Destinations & Ports - Tripadvisor";
		if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
		  System.out.println("Cruises page is opened");
		}
		else{
		  System.out.println("Crusies page could not open.");
		}
		
	}
	@Test
	public void selectCruiseLineAndShip()
	{
		driver.findElement(By.xpath("//span[text()='Cruise line']")).click();
		driver.findElement(By.xpath("//span[text()='AIDA']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[3]/span/button")).click();
	}
}
