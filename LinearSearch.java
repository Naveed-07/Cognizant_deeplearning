package Recursion;

import java.util.Scanner;

public class LinearSearch {
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = scan.nextInt();
		}
		
		int target = scan.nextInt();
		int ans = linearSearch(arr , target);
		System.out.println(ans);
		scan.close();
	}

	private static int linearSearch(int[] arr, int target) {
		
		if(arr.length == 0) {
			return -1;
		}
		
		for(int index = 0; index < arr.length ; index++) {
			
			if(arr[index] == target) {
				return index;
			}
		}
		return 0;
	}
}
