package Selenium.SeleniumFrameworkProject.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkProject.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent  {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		//super keyword is used to send driver from child class to parent class and it has to add in every child class
		//Initialization of driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css=".hero-primary")
WebElement conformationMessage;


public String getConfirmationMessage()
{
	return conformationMessage.getText();
}



}
