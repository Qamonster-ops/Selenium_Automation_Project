package Selenium.SeleniumFrameworkProject.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkProject.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//super keyword is used to send driver from child class to parent class that means landing page to abstract page and there it automatically creates the constructor
		//Initialization of driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//WebElement userEmail = driver.findElement(By.id("userEmail"));
//PageFactory .The above same step is written below by using page factory.So commenting the above step

@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement passwordEle;

@FindBy(id="login")
WebElement submit;

@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;

public ProductCatalogue loginApplication(String email,String password)
{
	userEmail.sendKeys(email);
	passwordEle.sendKeys(password);
	submit.click();
	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	return productCatalogue;
}
public String getErrorMessage()
{
	waitForWebElementToAppear(errorMessage);
	return errorMessage.getText();
	
}



public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}


}