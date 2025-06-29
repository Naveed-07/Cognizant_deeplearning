package simple;
import java.util.Scanner;
public class ReverseInteger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ans = 0;
		
		while(n > 0) {
			int rem = n % 10;
			n = n / 10;
			
			ans = ans * 10 + rem;
		}
		
		System.out.println(ans);
	}
}
