package simple;

import java.util.Scanner;

public class UppercaseLowercase {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char ch = scan.next().trim().charAt(0);
		
		if(ch >= 'a' && ch <= 'z') {
			System.out.println("lowerCase");
		}else System.out.println("uppercase");
		scan.close();
	}
}
