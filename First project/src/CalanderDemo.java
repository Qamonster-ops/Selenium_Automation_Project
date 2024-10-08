import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//To click specific date and month		
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		//August 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		//while loop will keep on executing until it return false
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		List<WebElement> dates= driver.findElements(By.className("day"));
	
		//Grab the common attribute and put them in to list and iterate
		int count =driver.findElements(By.className("day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
			driver.findElements(By.className("day")).get(i).click();
			break;
			}
		}
		

	}

}
