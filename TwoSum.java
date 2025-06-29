package simple;

import java.util.HashMap;

public class TwoSum {
    
    public static int findpairs(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int complement = k - arr[i];
            
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
           
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return count;
    }
}