import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	
	//declaring methods and variables as it is the parent class and using inheritance concept
	
	public void doThis()
	{
		System.out.println("I am here");
	}
	@BeforeMethod
	public void beforeRun()
	{
		System.out.println("Run me First");
	}
	@AfterMethod
	public void afterRun()
	{
		System.out.println("Run me last");
	}
	

}
