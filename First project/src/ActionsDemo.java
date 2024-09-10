import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//move to specific element (mouse over) and do right click
		a.moveToElement(move).contextClick().build().perform();
		
		//Drag and drop
		driver.get("https://jqueryui.com/droppable/");
		//number of frames can be seen by below code
		driver.findElement(By.tagName("iframe")).getSize();
		//frames with webelement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//driver.findElement(By.id("draggable")).click();
		WebElement source = driver.findElement(By.id("draggable"));		
		WebElement target = driver.findElement(By.id("droppable"));		
		a.dragAndDrop(source, target).build().perform();
		//frames with index is 0 or 1 or 2,this is not suggested
		//driver.switchTo().frame(0);
	//TO come back to window from frame use the below code
		driver.switchTo().defaultContent();
		
		
	}

}
