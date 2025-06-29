package Recursion;
import java.util.Scanner;

public class Minimumvalue{
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0; i <size; i++) {
			arr[i] =scan.nextInt();
		}
		
		int ans = Findmin(arr,0);
		System.out.println(ans);
		
	}
	
	 static int Findmin(int[] arr, int index) {
		
		 if(index == arr.length-1) {
		 return arr[index];
		 }
		 int min = Findmin(arr , index+1);
		 if (arr[index] < min) {
			 return arr[index];
		 }else {
			 return min;
		 }
	 }
}