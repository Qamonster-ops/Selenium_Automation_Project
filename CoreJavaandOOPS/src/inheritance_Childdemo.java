
public class inheritance_Childdemo extends inheritance_Parentdemo {


		String name ="QAClickAcademy";

		public inheritance_Childdemo()
		{
		super();// this should be always be at first line
		System.out.println("child class construtor");

		}
		public void getStringdata()
		{
		System.out.println(name);
		System.out.println(super.name);
		}


		public void getData()
		{
		super.getData();
		System.out.println("I am in child class");
		}
		public static void main(String[] args) {
		// TODO Auto-generated method stub



			inheritance_Childdemo cd = new inheritance_Childdemo();

		cd.getStringdata();
		cd.getData();
		}

}
