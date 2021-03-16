import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import CalculateTripCost.DriverSetup;
import CalculateTripCost.TestCase;
import CalculateTripCost.ValidateAll;

public class CalculateTripCostTest {
  @Test
  public void f() {
  }
  public static WebDriver driver;
	public static ArrayList<String> arr = new ArrayList<String>();
	public static ArrayList<String> arr1 = new ArrayList<String>();
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
	public void goToHolidayHomePage()    //to go holiday page And search Nairobi Location
	{
		driver.findElement(By.xpath("//span[text()='Holiday Homes']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/form/input[1]")).sendKeys("Nairobi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//div[text()='Nairobi']")).click();
	}
	
	@Test
	public void calculateTripCost()
	{
      	System.out.println("hello");
      	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]")).click();
	      driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/div/div/div[2]/div/div[3]/div[3]/div[2]")).click();
	      driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[2]")).click();
	}
	
	@Test
	public void displayAllHotels()
	{
		List<WebElement> hotelNames=new ArrayList<>();
		List<WebElement> hotelPricePerNight=driver.findElements(By.className("_33TIi_t4"));
		 int listsize= hotelPricePerNight.size();
		 int listsize1=hotelNames.size();
		 hotelNames=driver.findElements(By.className("_2K0y-IXo"));
		 
		 System.out.print("Htel Names"+" ");
		 System.out.println("Hotel Prices Per Night");
		 for(WebElement e: hotelNames)
		 {
			 arr1.add(e.getText());
				 
		 }
		 for(WebElement e1: hotelPricePerNight)
		 {
			 arr.add(e1.getText());
				 
		 }
		
		  for(int i=0;i<100;i++)
		 {
			  if(i*2<100)
			  {
			  System.out.print(arr1.get(i*2)+"  ");
			  }
			 if(i<50)
			 {
			  System.out.println(arr.get(i));
			 }
		
			}	
		}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	}
	
