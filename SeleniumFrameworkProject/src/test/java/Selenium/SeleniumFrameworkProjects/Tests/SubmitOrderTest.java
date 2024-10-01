package Selenium.SeleniumFrameworkProjects.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.SeleniumFrameworkProject.pageobjectmodel.CartPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.CheckoutPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.ConfirmationPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.LandingPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.OrderPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.ProductCatalogue;
import Selenium.SeleniumFrameworkProjects.TestComponent.BaseTest;

public class SubmitOrderTest extends BaseTest{

	//public static void main(String[] args) {
		//Converting this test into TestNg test case
	String productName = "ZARA COAT 3";	
	@Test(dataProvider= "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));	
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("sara.jones@gmail.com", "Sahitya@95");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrdersDisplay(productName));
				
	}
	
	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("userdir")+"reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("userdir")+"reports//"+testCaseName+".png";
	}
	//Extend Reports
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map = new  HashMap<String,String>();
//		map.put("email", "sara.jones@gmail.com");
//		map.put("password", "Sahitya@95");
//		map.put("productName", "ZARA COAT 3");
		
		List<HashMap<String , String>> data = getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//Selenium//SeleniumFrameworkProjects//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{"can give random details and product"}};
		
	}
	
	
//	public Object[][] getData()
//	{
//		
//		return new Object[][] {{"sara.jones@gmail.com","Sahitya@95","ZARA COAT 3"},{"can give random details and product name"}};
//	}
	
	
}




	


