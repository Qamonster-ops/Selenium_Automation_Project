package Selenium.SeleniumFrameworkProjects.TestComponent;

import org.testng.annotations.AfterMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.SeleniumFrameworkProject.pageobjectmodel.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException
	{
		
		//properties class
		
		Properties prop = new Properties();
		
		//FileInputStream fis = new FileInputStream("/Users/thotsec/eclipse-workspace/SeleniumFrameworkProject/src/main/java/Selenium/SeleniumFrameworkProject/resources/GlobalData.properties");
		//instead of the above libe of code we are using the below one to reduce the size and easily accessable and giving double slahes becoz java recognises as it is the path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Selenium//SeleniumFrameworkProject//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
				//prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			//WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
		System.setProperty("Webdriver.Chrome.driver", "/Users/thotsec/Downloads/chromedriver-mac-x64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1440,900));//this is for full size screen
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//firefox code
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//edge code
			System.setProperty("webdriver.edge.driver", "edge.exe");
			WebDriver driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String, String>> getJsonDatatoMap(String filePath) throws IOException
	{
		//read json to String
	String jsoncontent = 	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Selenium//SeleniumFrameworkProjects//Data//PurchaseOrder.json"),StandardCharsets.UTF_8);
			
		//Convert string to HashMap by using jackson dataBind
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
	return data	;
		
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("userdir")+"reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("userdir")+"reports//"+testCaseName+".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
