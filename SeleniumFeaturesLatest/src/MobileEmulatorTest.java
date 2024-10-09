import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		ChromeDriver driver = new ChromeDriver();		
		DevTools devTools = driver.getDevTools();	
		devTools.createSession();		
		//send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools
		//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), java.util.Optional.empty()));//we can just put  like this also.null, null, null, null, null, null, null, null, null, null, null
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();	
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		//Network.getRequestPostData
		
	
		
		
	}

}
