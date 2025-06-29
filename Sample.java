package simple;
import java.util.Scanner;
public class Sample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int reversed = 0;  // Initialize to 0
        
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;  // Multiply first, then add
            num /= 10;
        }
        
        System.out.println(reversed);
        scan.close();
    }
}