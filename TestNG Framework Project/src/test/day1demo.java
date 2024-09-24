package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;



public class day1demo {
	
@Test(groups= {"smoke"})	
	public void ploan()
	{
		System.out.println("Ploan");
	
	}
	//if we use this before annotation then this test case will execute first 
@BeforeTest
 	
public void prerequiste()
{
	System.out.println("I'll execute first");
}

@AfterTest
	
//if we use this after annotation then this test case will execute last in that class and folder
//but not after all the classes
public void postrequiste()
{
	System.out.println("I'll execute last");
}

	}

