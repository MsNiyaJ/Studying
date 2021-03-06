import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        startSearch();
    }

    private static void startSearch() {
        int arr[] = new int[]{10, 2, 3, 15, 4, 5, 20, 17};
        int key = 7;
        binarySearch(arr, key);
    }

    // Prints a message that shows if the key exists or not.
    private static void print(int index, int key, String search) {
        if(index != -1) System.out.println(key + " was found at index " + index + "! (" + search + ")");
        else System.out.println(key + " was not found.");
    }

    /**
     * Searches for a key in a sorted array. (log n - # of passes)
     * @param arr The array we are searching,
     * @param key The key we are looking for in the array.
     * @return index where the key was found or -1 if the key doesn't exist in the array.
     */
    private static void binarySearch(int[] arr, int key) {
        Arrays.sort(arr);   //Must sort the array before performing a binary search
        
        int min = 0;                //The smallest index
        int max = arr.length - 1;   //The highest index
        int index = -1;

        //Makes the array smaller while searching for the key
        while(min <= max){
            int mid = (min + max) / 2;  //The midpoint of the array
        
            if(key < arr[mid]) max = mid - 1;        // Updates max if the key is on the left of the mid
            else if(key > arr[mid]) min = mid + 1;   // Updates min if the key is on the left of the mid
            else {
                index = mid;                         // If the key was found, store the index and end the while loop
                break;
            }
        }
        print(index, key, "binary search");         // Prints the result of the search
    }
}
