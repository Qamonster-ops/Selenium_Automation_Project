	import java.util.Iterator; 
	import java.util.Map; 
	import java.util.Map.Entry; 
	import java.util.Set;
public class HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap<Integer,String> hm=new HashMap<Integer,String>();--because this is not supporting
		HashMap hm=new HashMap(); 
		hm.put(0, "hello"); 
		hm.put(1, "Gudbye"); 
		hm.put(42, "morning"); 
		hm.put(3, "evening"); 
		System.out.println(hm.get(42)); 
		hm.remove(42); System.out.println(hm.get(42)); 
		Set sn= hm.entrySet(); 
		Iterator it =sn.iterator(); //hashtable -pass table set collections  
		while(it.hasNext())
		{ 
			System.out.println(it.next()); 
			Map.Entry mp=(Map.Entry)it.next();
			// System.out.println(mp.getKey());
			System.out.println(mp.getValue()); 
		}


		
	}

	private Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	private void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	private char[] get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private void put(int i, String string) {
		// TODO Auto-generated method stub
		
	}

}
