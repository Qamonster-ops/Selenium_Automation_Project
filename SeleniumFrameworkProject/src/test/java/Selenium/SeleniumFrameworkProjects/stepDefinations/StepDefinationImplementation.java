package Selenium.SeleniumFrameworkProjects.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Selenium.SeleniumFrameworkProject.pageobjectmodel.CartPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.CheckoutPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.ConfirmationPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.LandingPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.ProductCatalogue;
import Selenium.SeleniumFrameworkProjects.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplementation extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException 
	{
		landingPage  = launchApplication();
		
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username,String password)
		{
		productCatalogue =landingPage.loginApplication(username,password);
		}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_submit_the_order(String productName)
	{
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{String} message is displayed on COnfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();

	}
	@Then("^\"([^\"]*)\"message is displayed$")
	public void something_message_is_displayed(String strArg1)
	{
		Assert.assertEquals("strArg1", landingPage.getErrorMessage());
		driver.close();
	}
	
	}


