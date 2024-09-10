import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Maxwin_deletecookies_deletescreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//to delete one cookie
		driver.manage().deleteCookieNamed("abcd");
		//delete session cookie 
		driver.manage().deleteCookieNamed("sessionkey");
		//then click on link and login and that should be fine
		driver.get("https://google.com");
		//take the screenshot
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("Users/thotsec/Desktop://screenshot.png"));
		
		
	}

}
