import java.util.ArrayList;

public class CoreJavabrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//Java Variables and Datatypes
		
		//integer is a premitive data type and string is a non-premitive data type

		int Num= 5;
		String name = "Sahitya";
		char letter = 't';
		float decimal = (float) 3.9;
		double dec = 5.99;
		boolean myans = true;
		System.out.println(Num + " is the value stored in number variable");
		System.out.println(name + " is the name is stored string variable");
		System.out.println(letter + " is the letter is stored character variable");
		System.out.println(dec + " is the value is stored decimal variable");
		
//Arrays in Java
		
	//This method id used when we don't know the values of array and when we want to take the values from web
		int[] arr = new int [5];
		
		arr[0] = 10;
		arr[1] = 70;
		arr[2] = 40;
		arr[3] = 90;
		arr[4] = 50;
		
	//This method is used when we know the values of array and when we want to hardcode them directly
		int[] arr2 = {10,70,40,90,50,20,30};
		
		System.out.println(arr2[4]);
		
	//Loops in Java
		//integer array
		
		for(int i=0; i< arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		for(int i=0; i<arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
		
		//Character array
		
		String[] namee = {"Sahitya","patel","Thota"};
		for(int i=0; i<namee.length; i++)
		{
			System.out.println(namee[i]);
		}
		//This is also same method as above but little easy
		for( String s: namee)
		{
			System.out.println(s);
		}
		
	//If else condition
		//check the array which are multiple of 2
		int[] arr3 = {10,70,40,90,50,20,30,60,80};
		for(int i=0; i<arr3.length; i++)
		{
			if(arr3[i] %2 == 0)
			{
			System.out.println(arr3[i]);
			break;//break is used whether we need to check only when the array is multiple of 2 or not once the condition is satisfied it will stop the execution 
			}
			
			else
			{
			System.out.println(arr3[i]	+ "is not a multiple of 2");
			}
		}
		
//Array list and difference between arrays and arraylist
		//in arraylist we can dynamical grow the size od an array
		//Create a object of the class -- object.method
		//class .object name = new classname();-->syntax
		
		
		//Adding the objects and removing the objects
		ArrayList a = new ArrayList();
		a.add("Sahitya");
		a.add("Patel");
		a.add("Thota");
		a.add("Ravi");
		//a.remove(2);
		
	//extracting the arrays 
		System.out.println(a.get(3));
		
//for loops in arraylist		
//in array we use length and in array list we use size
		
		for(int i=0; i<a.size(); i++)
		{
			System.out.println(a.get(i));
		}
		//Enhanced for loop
		/*
		 * for(String val :a) { System.out.println(val); }
		 */
		
		//items present in an array
		System.out.println(a.contains("Ravi"));
		
	//converting array into arraylist
	/*
	 *  String[] name1 = {"Sahitya","patel","Thota"}; // List<String>
	 * nameArrayList = Arrays.aslist(name1); // name1ArrayList.contains("Thota");
	 */	
		
//Strings in Java 
		//String is a object in java there are two tyoes of strings string literal and using allocating new memory operator as below
		 //String Literal in this case if there are same names or multiple names which are alike it wont create the new object that means t1 is not created only t and t2 are created
		String t =  "First project";
		String t1 = "First project";
		String t2 = "Hello";
				
		 //In allocating the new memory object in this case if there are same values or names  it will create the new object in the memory space
		String s = new String("Welocme Home");
		String s1 = new String("Welocme Home");
		//Split the string and converting them in to Array
		String p = "Ravi Sahitya patel Thota";
		String [] splittedstring =p.split(" ");
		System.out.println(splittedstring[0]);
		System.out.println(splittedstring[1]);
		System.out.println(splittedstring[2]);
		String [] splittedstring1 =p.split("patel");
		System.out.println(splittedstring1[0]);
		System.out.println(splittedstring1[1]);
	//to trim that left or right space we use
		System.out.println(splittedstring1[1].trim());
	//to get the charecters in a row 
		for (int i =0; i<p.length();i++)
		{
			System.out.println(p.charAt(i));
		}
			
	//To print in reverse order 
		for (int i=p.length()-1;i>=0;i--)
		{
			System.out.println(p.charAt(i));
		}
		
		
	}

}
