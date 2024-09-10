import java.net.HttpURLConnection;
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		//broken Url
		//step-1 is to get the all url's tied up to the links using selenium
		//Java method will call the URL's and gets you the status code
		//if status code >400 than that url is not working --> link which tied to the url is broken
		  //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

     List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
     //problem in assets 
     SoftAssert a =new SoftAssert();
     for(WebElement link : links)

     {
      String url= link.getAttribute("href");

         HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
         conn.setRequestMethod("HEAD");
         conn.connect();
         int respCode = conn.getResponseCode();
         System.out.println(respCode);
         a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

     }

     a.assertAll();
     
    
 

}



private static Object getReturnCode(WebElement link) {

//TODO Auto-generated method stub

return null;

}



}

