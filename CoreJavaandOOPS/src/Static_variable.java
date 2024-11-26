
public class Static_variable {
	 String name; //instance variable
	 String address;
	 static String city= "Troy";//class variable
	 static int i ;
	 static {
		 city ="Troy";
		 i=0;
	 }
	 
	 Static_variable(String name, String address)
	 {
		 this.name = name;
		 this.address = address;
		 i++;
		 System.out.println(i);
		 
	 }
	 
	 public void getAddress()
	 {
		 System.out.println(address+" "+city);
	 }
	 
	 public static void getcity()
	 {
		 System.out.println(city);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Static_variable obj = new Static_variable("Ben","Crooks");
		Static_variable obj1 = new Static_variable("Ram","Beaver");
		obj.getAddress();
		obj1.getAddress();
		Static_variable.getcity();
		Static_variable.i=4;
		obj.address="hills";
		
		
	}

}
