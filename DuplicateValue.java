package simple;
import java.util.HashMap;
public class DuplicateValue {
	public static int FirstDuplicate(int[] arr, int n) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int minvalue = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i ++ ) {
			if (map.containsKey(arr[i])) {
				minvalue = Math.min(map.get(arr[i]), minvalue);
			}
			else map.put(arr[i], i);
		}
		return minvalue;
	}
}
