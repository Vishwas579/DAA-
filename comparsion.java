package pro3;
import java.util.Arrays;

public class SortingComparison {
    
    // Merge Sort Implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] originalArray = {38, 27, 43, 3, 9, 82, 10};
        int n = originalArray.length;

        // Cloning the array for fair comparison
        int[] mergeSortArray = originalArray.clone();
        int[] quickSortArray = originalArray.clone();

        // Measuring Merge Sort time
        long startMerge = System.nanoTime();
        mergeSort(mergeSortArray, 0, n - 1);
        long endMerge = System.nanoTime();

        // Measuring Quick Sort time
        long startQuick = System.nanoTime();
        quickSort(quickSortArray, 0, n - 1);
        long endQuick = System.nanoTime();

        // Printing results
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Merge Sorted Array: " + Arrays.toString(mergeSortArray));
        System.out.println("Quick Sorted Array: " + Arrays.toString(quickSortArray));

        System.out.println("\nTime Complexity Comparison:");
        System.out.println("Merge Sort Execution Time: " + (endMerge - startMerge) + " nanoseconds");
        System.out.println("Quick Sort Execution Time: " + (endQuick - startQuick) + " nanoseconds");
    }
}
