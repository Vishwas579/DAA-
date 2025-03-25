package daaa;
import java.util.Scanner;
import java.util.Arrays;

public class binarysearch {

    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is smaller, ignore right half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is greater, ignore left half
            else {
                left = mid + 1;
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array (binary search requires sorted array)
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Input target element to search
        System.out.print("Enter the element to search: ");
        int target = sc.nextInt();

        // Perform binary search
        int result = binarySearch(arr, target);

        // Output result
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        sc.close();
    }
}
