import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.ConnectionType;


public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//waits - 2-3 , 2
		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");	
		ChromeDriver driver = new ChromeDriver();	
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Network.emulateNetworkConditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
			
		});
		long startTime = System.currentTimeMillis();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.id("input")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.className(" default-ltr-cache-jmnaey euy28770")).getText();
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		//14960  2054
		
		
		
		
		
		
		
		
		
		
		
	}

}

