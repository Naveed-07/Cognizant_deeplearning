package Hashmap;

 class Hash {

	private num[] nums;
	
	
	public Hash() {
		
	}
}

public class Hashmap{
	
	public static void main(String[] args) {
		HashMap<String,Integer> map=new HashMap<>();
		HashMap<String,Integer>map2=new HashMap<>();
		map2.put("kishore", 42);
		map2.put("suresh", 60);
		map2.put("gopal", 78);
		map2.put("muthu", 90);
		map2.put("boopathy", 88);
		map2.put("muthu", 90);
		
		
		map.put("naveed",99);
		map.put("yousuf", 66);
		map.put("Abdu", 44);
		map.put("Lokesh", 88);
		map.put("naveed", 66);
		map.putIfAbsent("Loki", 050);
		System.out.println(map.containsValue(66));
		map.putAll(map2);
//		
//		System.out.println(map);
//		
//		map.clear();
//		
//		System.out.println("after"+map);
		
//		TreeMap<String,Integer> map=new TreeMap<>();
//		TreeMap<String,Integer>map2=new TreeMap<>();
//		map2.put("kishore", 42);
//		map2.put("suresh", 60);
//		map2.put("gopal", 78);
//		map2.put("muthu", 90);
//		map2.put("boopathy", 88);
//		map2.put("muthu", 90);
//		
//		
//		map.put("naveed",99);
//		map.put("yousuf", 66);
//		map.put("Abdu", 44);
//		map.put("Lokesh", 88);
//		map.put("naveed", 66);
//		map.putIfAbsent("Loki", 050);
//		System.out.println(map.containsValue(66));
//		map.putAll(map2);
//		
//		System.out.println(map);
//		
//		map.clear();
//		
//		System.out.println("after"+map);
		
		
//		HashSet<Integer> set=new HashSet<>();
//		set.add(4);
//		set.add(5);
//		set.add(9);
//		set.add(90);
//		
//		System.out.print(set);
//		
//		set.clear();
//		
//		System.out.println(set);
//		
		
	}
}