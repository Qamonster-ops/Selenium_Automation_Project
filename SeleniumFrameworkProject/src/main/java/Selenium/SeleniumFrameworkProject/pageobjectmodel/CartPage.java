package Selenium.SeleniumFrameworkProject.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkProject.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css= ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css= ".cartSection h3")
	private List<WebElement> cartProducts;
	
	
	public CartPage(WebDriver driver)
	{
		//super keyword is used to send driver from child class to parent class and it has to add in every child class
		//Initialization of driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match  = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
	
	
}
