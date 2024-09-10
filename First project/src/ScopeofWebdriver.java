import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeofWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//1.Count of number of links by tag names which is anchor a <a
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());	
		
//2.count the number of links in footer,so limit the scope of the webelement to only footer section by using the whole links webelement to subset of it
		//limiting webdriver scope
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
//3.count of footer section but only in first coloum
		
		WebElement coloumdriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(coloumdriver.findElements(By.tagName("a")).size());
		
//4.click on each link in the coloum and check if the pages are opening by using window handlings
		for(int i=1;i<coloumdriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumdriver.findElements(By.tagName("a")).get(i).click();
			Thread.sleep(2000);
		}
		//by using window handlings we are getting into the tabs and getting title
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
				
	

}
}