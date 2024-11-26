
public class Keyword_childdemo extends Keyword_parentdemo{
	String name = "QA Testing";
	public Keyword_childdemo()
	{
		super();//this should be always be the first line of the constructor
		System.out.println("I am in child class constructor");
	}
	
	
	public void getStringdata()
	{
		System.out.println(name);
		System.out.println(super.name);

	}
	
	public void getdata() {
		super.getdata();
		System.out.println("I am in child class");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Keyword_childdemo cd = new Keyword_childdemo();
	cd.getStringdata();
	cd.getdata();	
		

	}

}
