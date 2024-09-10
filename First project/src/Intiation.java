import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Intiation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*Invoking  of browsers
			for firefox driver download geko driver and use the below code	and import the driver
			System.setProperty("Webdriver.Firefox.driver", "/Users/thotsec/Downloads/gekodriver");	
			WebDriver driver = new FirefoxDriver();	
					
			for microsoft Edge driver download msedge driver and use the below code	 and import the driver
			System.setProperty("Webdriver.edge.driver", "/Users/thotsec/Downloads/msedgedriver");	
		    WebDriver driver = new EdgeDriver();*/	
		
		
					
	//SeleniumManager	
	System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
	WebDriver driver = new ChromeDriver();
	driver.get("Https://walmart.com");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	//Thread.sleep(2000);
	//Instead of thread.sleep we can give implicit wait and explicit wait here am taking implicit wait which mean we can give the time limit and the function will wait that amount of time period
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.findElement(By.name("q")).sendKeys("chocolates");
	driver.findElement(By.className("ld ld-Search absolute")).click();
	Thread.sleep(2000);
	driver.close();
		
		
		
		
		
		
	}

}
