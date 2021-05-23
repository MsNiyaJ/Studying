import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 2, 3, 15, 4, 5, 20, 17};
        int key = 4;
        binarySearch(arr, key);
    }

    /**
     * Searches for a key in a sorted array.
     * @param arr The array we are searching,
     * @param key The key we are looking for in the array.
     * @return index where the key was found or null if the key doesn't exist in the array.
     */
    private static void binarySearch(int[] arr, int key) {
        Arrays.sort(arr);   //Must sort the array before performing a binary search
        
        int min = 0;                //The smallest index
        int max = arr.length - 1;   //The highest index
        int mid = (min + max) / 2;  //The midpoint of the array
        
    }
}
