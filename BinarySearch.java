package DSA;

import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();
        
        int result = search(arr, target);
        
        if (result == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index: " + result);
        }
        
        scanner.close();
    }
}