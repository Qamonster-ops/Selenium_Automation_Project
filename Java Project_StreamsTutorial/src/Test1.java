import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
	
	//count the number of names starting with alphabet A in the list
	
	public void regular()
	{
	ArrayList<String>	 names = new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");	
	names.add("Alekhya");	
	names.add("Adam");	
	names.add("Ram");	
	int count =0;
	for (int i=0;i<names.size();i++)
	{
		String actual = names.get(i);
		if(actual.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println(count);	
		
	}

	
	public void streamFilter()
	
	{
		ArrayList<String>	 names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");	
		names.add("Alekhya");	
		names.add("Adam");	
		names.add("Ram");
		//there is no life for intermediate operations if there is no terminal operations
		//terminal operations will execute only if internal operations(filters)returns true
		//We can create stream
		//how to use filter in stream API
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		
		long d= Stream.of("Abhijeet", "Don", "Alekhya","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(d);
		
		//print all the names of ArrayList
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//print only one name of the list
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	
	public void streamMap()
	
	{	
		ArrayList<String>	 names = new ArrayList<String>();
		names.add("Man");
		names.add("Don");	
		names.add("women");
		//Print names which has last letter as "a" with Uppercase
		Stream.of("Abhijeet", "Don", "Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//print names which have first letter as a with uppercase and sorted
		//first convert arrays to arraylist
		List<String>names1 =Arrays.asList("Abhijeet", "Don", "Alekhya","Adam","Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merge two lists in to one array list and then sort	
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		//In the stream we need to check if the name  is matched or not
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Ad09am"));
		System.out.println(flag);
		//as asserts is not able to import block the below statement
		//Assert.assertTrue(flag);
		
	}	
	
	public void streamCollect()
	{
		//Take the array convert in to list and do the modifications and manupulations and againconvert them back in to list
		List<String>ls = Stream.of("Abhijeet", "Don", "Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//print unique numbers from the array and sort them and output 3rd index
		List<Integer>values = Arrays.asList(3,2,2,4,4,5,1,7,8,9,9);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
		
	}
}