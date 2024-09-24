package test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class day3demo {
	//It will execute in the last after all the folders and packages test cases are done
	@AfterSuite
	public void Afsuite()
	{
		
		System.out.println("Am last");

	}	
//It will execute in the Before all the methods have executed in the particular class
//In the same way we have after class too which will execute after all the methods have executed in the class
	@BeforeClass
	public void BFclass()
	{	
		System.out.println("Before executing all the methods in the class");

	}	
		
@Test(groups= {"smoke"})
public void Webloginhomeloan()
{
	//selenium
	System.out.println("Webloginhomeloan");
}
//@Parameters({"URL","APIKey/username"}) we can call them like this
@Test
public void Mobileloginhomeloan(String urlname,String key)
{
	//Appium
	System.out.println("Mobileloginhomeloan");
	System.out.println("urlname");
	System.out.println("key");

}
//this helps when the execution is taking time or it is failing then we can use this and say to wait till 4 sec more helpful in rest api
@Test(timeOut=4000)
public void LoginAPIhomeloan()
{
	//Rest API
	System.out.println("LoginAPIhomeloan");
}
//we are callind data here for this test case
@Test(dataProvider="getData")
public void LoginAPIhomeeloan(String Username,String password)
{
	//Rest API
	System.out.println("LoginAPIhomeeloan");
}
//This method is used for test data for for the test cases
@DataProvider
public Object[][] getData()
{
	//1st  combination - username password -good credit history
	//2nd -username password-no credit history
	//3rd fraudelent credit history
//we are depending upon the multidimentional object array[rows][coloums]	
Object[][] data = new Object[3][2];
//1st set
data[0][0]="firstsetusername";
data[0][1]="password";
//coloumns in the row are nothing but values for that particular combination(row)

//2nd set
data[1][0]="secondsetusername";
data[1][1]="secondpassword";

//3rd set
data[2][0]="thirdsetusername";
data[2][1]="thirdsetpassword";
return data;

}

}
