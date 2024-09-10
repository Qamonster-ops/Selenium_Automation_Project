
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//if we want to call and execute the method we need to create the object and then call them if we want to call our own class method also we have to create the object
		    MethodsDemo d = new MethodsDemo();
		//now we can d as object and call the method
		   // d.getData();
		    String name = d.getData();
		    System.out.println(name);
		    //create the object for class 2 
		    MethodsDemo2 d1 = new MethodsDemo2();
		    d1.getUserData();
		    getData2();
		    
//Without creating object to access our own class methods if we use static ,if we use this keyword then it belongs to class not the object we remove d also it will work
		
		
	}
	
	//Those method can be accessed by another class also if we use public
	//void is general used as not to  return any output,if we want to return the integer then we can use integer and string 
	//we just changed from void to string because we are returning the string variable,this string variable can be called and stored in new variable while we are executing
	//we added the static keyword to access the our own class method without using the object
	
	public  String getData()
	{
	System.out.println("Hyderabad");
	return "Sahitya";
	}
	
	
	public static String getData2()
	{
	System.out.println("karimnagar");
	return "Sahitya";
	}
	
	
	

}
