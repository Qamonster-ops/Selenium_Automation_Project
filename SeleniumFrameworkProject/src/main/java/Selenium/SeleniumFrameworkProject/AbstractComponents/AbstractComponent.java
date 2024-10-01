package Selenium.SeleniumFrameworkProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.SeleniumFrameworkProject.pageobjectmodel.CartPage;
import Selenium.SeleniumFrameworkProject.pageobjectmodel.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	
	//constructor is created because the driver has to initialize from the child class that is landing class
		public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
		
		@FindBy(css="[routerlink+='cart']")
		WebElement cartHeader;
		
		@FindBy(css="[routerlink+='myorders']")
		WebElement orderHeader;

		public void waitForElementToAppear(By findBy)
		{
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		
		public void waitForWebElementToAppear(WebElement findBy)
		{
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));
		}
		
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		//4 seconds _application defect or else we can use thread.sleep
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
}
