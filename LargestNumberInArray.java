package simple;
import java.util.Scanner;
public class LargestNumberInArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = -1;
		int n =scan.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(x <= arr[i]) {
				x = arr[i];
			}
		}
		System.out.println(x);
		scan.close();
	}
}
