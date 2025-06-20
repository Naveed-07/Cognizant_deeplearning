package DSA;

import java.util.Scanner;

public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();
        
        int result = search(arr, target);
        
        if (result == -1) {
            System.out.println("Element not found in array");
        } else {
            System.out.println("Element found at index: " + result);
        }
        
        scanner.close();
    }
}