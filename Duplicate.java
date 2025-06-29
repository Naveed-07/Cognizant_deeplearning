package Recursion;

public class Duplicate {
	public static void main(String[] args) {
		int[] arr = {1,1,3,4,2,3,2,1};
		int unique = 0;
		
		for (int num : arr ) {
			unique ^= num;
		}
		System.out.println(unique);
	}
}
