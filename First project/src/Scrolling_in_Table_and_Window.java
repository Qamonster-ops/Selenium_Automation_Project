import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import dev.failsafe.internal.util.Assert;

public class Scrolling_in_Table_and_Window {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//Window scrolling 
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	//table scrolling syntax is js.executeScript("document.querySelector('cssSelector).scrollTop(0,5000)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop(0,5000)");
		
//Handling of table Grids in webpage and there summation
		//Adding (List<WebElement>)as per required but actually in code there is no need to add 
		
		List<WebElement> values = (List<WebElement>) driver.findElement(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		 for(int i =0;i<values.size();i++)
		 {
			//Converting string to Integer syntax is Interger.parseInt
			 
			 sum = sum +Integer.parseInt(values.get(i).getText());
		 }
		
		System.out.println(sum);
	//to get only the summation value use below step as we need to split the result and get only the integer value
		//.classname is the syntax of the css selector
		int total =Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		//Assertions is not installed as TestNG is not installed so comparison step is blocked
		//Assert.classassertequals(sum,total);
	}

}
