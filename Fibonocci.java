package simple;

import java.util.Scanner;

public class Fibonocci {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int prev = 0,next = 1,count = 2,ans = 0;
		
		while( count < num) {
			ans = prev + next;
		    prev = next;
			next = ans;
			count++;
		}
		System.out.println(ans);
	}
}
