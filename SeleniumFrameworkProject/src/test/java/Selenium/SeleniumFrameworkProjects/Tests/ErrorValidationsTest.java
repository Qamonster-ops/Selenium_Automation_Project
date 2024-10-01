package Selenium.SeleniumFrameworkProjects.Tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
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
import Selenium.SeleniumFrameworkProject.pageobjectmodel.ProductCatalogue;
import Selenium.SeleniumFrameworkProjects.TestComponent.BaseTest;
import Selenium.SeleniumFrameworkProjects.TestComponent.Retry;

public class ErrorValidationsTest extends BaseTest{

	//public static void main(String[] args) {
		//Converting this test into TestNg test case
	//if we want to run the failed test cases one more time then we can add retryAnalyzer = Retry.class beside the error handling coloum
	
	@Test(groups = {"ErrorHandling"})
	public void loginerrorvalidation() throws IOException, InterruptedException
	{
		
		String productName = "ZARA COAT 3";			
		landingPage.loginApplication("sara.jones@gmail.com", "Sahitya@95");	
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void producterrorvalidation() throws IOException, InterruptedException
	{
		
String productName = "ZARA COAT 3";	
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("sara.jones@gmail.com", "Sahitya@95");	
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
	
	
	
	
	}

	


