package simple;

import java.util.Scanner;

public class NumberOfOccurance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int occ = -1;
		int n = scan.nextInt();
		int[] arr = new int[n];
		int target = scan.nextInt();
		int count = 0;
		
		if(n <= 0) {
			System.out.println("Invalid input");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0;i < n; i++) {
			if( arr[i] == target) {
				count++;
			}
		}
		System.out.println(count);
	}
}
