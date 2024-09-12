import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class PS1  extends PS  {
	
@Test
public void testRun()
{

	PS2 ps2 = new PS2(3);//constructor -creating a class object with parameters then we have to call the constructor 
							//for that create the constructor in child class
	int a=3;
	doThis();//parent class
	System.out.println(ps2.increment());
	System.out.println(ps2.decrement());
	//PS3 ps3 = new PS3(3);
	System.out.println(ps2.multiplythree());
	
	
}	
	
}
