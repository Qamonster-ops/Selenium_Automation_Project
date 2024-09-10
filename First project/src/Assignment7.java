import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
			driver.get("http://qaclickacademy.com/practice.php");
		    driver.findElement(By.id("autocomplete")).sendKeys("ind");
		    Thread.sleep(2000);
		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
	       

	}

}
