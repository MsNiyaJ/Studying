import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 2, 3, 15, 4, 5, 20, 17};
        int key = 4;
        int index = binarySearch(arr, key);
        print(index, key);
    }

    // Prints a message that shows if the key exists or not.
    private static void print(int index, int key) {
        if(index != -1) System.out.println(key + " was found at index " + index + "!");
        else System.out.println(key + " not found.");
    }

    /**
     * Searches for a key in a sorted array. (log n - # of passes)
     * @param arr The array we are searching,
     * @param key The key we are looking for in the array.
     * @return index where the key was found or -1 if the key doesn't exist in the array.
     */
    private static int binarySearch(int[] arr, int key) {
        Arrays.sort(arr);   //Must sort the array before performing a binary search
        
        int min = 0;                //The smallest index
        int max = arr.length - 1;   //The highest index
        
        //Makes the array smaller while searching for the key
        while(min <= max){
            int mid = (min + max) / 2;  //The midpoint of the array
        
            if(key < arr[mid]) max = mid - 1;        // Updates max if the key is on the left of the mid
            else if(key > arr[mid]) min = mid + 1;   // Updates min if the key is on the left of the mid
            else return mid;                         // Returns the mid when min, max, and mid equal each other
        }
        return -1;      // Returns -1 if the key wasn't found
    }
}
