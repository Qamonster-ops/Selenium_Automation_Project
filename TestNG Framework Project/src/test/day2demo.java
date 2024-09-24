package test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day2demo {
	//This depend on method indicates that it depends on another test case which means loginapi will execute first and then after weblogincar
@Test(dependsOnMethods = {"LoginAPIcarloan","Mobilelogincarloan"})

public void Weblogincarloan()
{
	//selenium
	System.out.println("Weblogincarloan");
}
//If we use this annotation it will execute before the every test case in the particular class 
//in the same way we have after method too
@BeforeMethod
public void Bfeverymethod()
{
	System.out.println("Will excute before every test method in day 3 class");

}

@Test(groups= {"smoke"})
public void Mobilelogincarloan()
{
	//Appium
	System.out.println("Mobilelogincarloan");	
}
//if we use this helper then it will skip this test case from execution instead of commenting
@Test(enabled=false)
public void LoginAPIcarloan()
{
	//Rest API
	System.out.println("LoginAPIcarloan");
}
//It will execute in the first before all the folders and packages test cases are begin
@BeforeSuite
public void Bfsuite()
{
	System.out.println("Am First");

}
}
