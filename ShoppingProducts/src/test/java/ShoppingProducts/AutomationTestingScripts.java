package ShoppingProducts;
import ShoppingProducts.ShoppingProducts.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class AutomationTestingScripts {
	
	public static WebDriver driver;
  @Test
  public void openOnecognizantPortal() {
	  
		try {
			driver=DriverSetup.getDriver("chrome");  // for getting chrome driver
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//To open onecognizant.cognizant.com portal
		   WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.globoforce.net/microsites/t/home?client=cognizant&setCAG=true");
		(new WebDriverWait(driver, 1000)).until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver d) {
		        return driver.findElement(By.name("loginfmt")).getAttribute("value").length() == 20;
		    }
		});
		driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div/div[4]/div/div/div/div[2]/input")).click();
  //wait until password not enter
		(new WebDriverWait(driver, 1000)).until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver d) {
		        return driver.findElement(By.name("passwd")).getAttribute("value").length() == 12;
		    }
		});
  // wait until otp not enter		
	driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/div/div/div/div/input")).click();
  
	(new WebDriverWait(driver, 1000)).until(new ExpectedCondition<Boolean>() {
	    public Boolean apply(WebDriver d) {
	        return driver.findElement(By.name("otc")).getAttribute("value").length() == 6;
	    }
	});
	
	driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div[6]/div/div/div/div/input")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("idSIButton9")).click();
	String title=driver.getTitle();
	System.out.println(title);
  }
}
