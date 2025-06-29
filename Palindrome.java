package simple;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		System.out.println(isPalindrome(str1));
		
	}

	private static boolean isPalindrome(String str1) {
		
		if(str1 == null || str1.length() == 0) {
			return true;
		}
		
		int left = 0;
		int right = str1.length()-1;
		
		while(left < right) {
			if(str1.charAt(left) != str1.charAt(right)) {
				return false;
			}
			left ++;
			right --;
		}
		return true;
	}
}
