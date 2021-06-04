import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;     //Size of the array
        int d = 2;              //The number of elements we are rotating
        int [] rotatedArr = rotate(arr, d, n);
        search(rotatedArr);
    }

    /**
     * Rotates an array of size n by d elements
     * @param arr   The array we are rotating
     * @param d     The number of elements in the array
     * @param n     The size of the array
     * @author      Shaniya Malcolm
     * @return      The rotated array
     */
    public static int[] rotate(int[] arr, int d, int n) {
        int[] rotatedArr = new int[n];  // Create a new array of the same size
        
        // For each element, increase the index by the size of d and take the modulo to get the first elements in the array 
        for(int i = 0; i < n; i++){
            rotatedArr[i] = arr[(i + d) % n];
        }

        System.out.println(Arrays.toString(rotatedArr));
        return rotatedArr;
    }

    /**
     * Searches for a value in a sorted and rotated array
     * @param rotatedArr The rotated array
     * @author Shaniya Malcolm
     */
    public static void search(int[] rotatedArr){
        int pivot = findPivot(rotatedArr);
        if(pivot == -1){System.out.println("An error occured while finding the pivot point.");  System.exit(0);}
        
        // Initializing the two sub arrays.
        int size = pivot + 1;       // The size of the first subarray
        int[] a = Arrays.copyOfRange(rotatedArr, 0, size);
        int[] b = Arrays.copyOfRange(rotatedArr, size, rotatedArr.length);
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        int key = 5;
        int i = findKey(key, a); 
        int j = findKey(key, b);

        if(i != -1)
            printSearchResults(key, i);
        else if(j != -1)
            printSearchResults(key, j);
        else
            System.out.println("The key was not found.");
    }

    private static void printSearchResults(int key, int index) {
        System.out.println("The key (" + key + ") was found at index " + index);
    }

    /**
     * Searches for a key in an array.
     * @param key The key we are searching for in the array
     * @param arr The array given
     * @author Shaniya Malcolm
     * @return the index of the key in the array (-1 if key wasn't found)
     */
    private static int findKey(int key, int[] arr) {
       return binarySearch(arr, key);
    }

    private static int binarySearch(int[] arr, int key) {
        int min = 0;                //The smallest index
        int max = arr.length - 1;   //The highest index
        
        //Makes the array smaller while searching for the key
        while(min <= max){
            int mid = (min + max) / 2;  //The midpoint of the array
        
            if(key < arr[mid]) max = mid - 1;        // Updates max if the key is on the left of the mid
            else if(key > arr[mid]) min = mid + 1;   // Updates min if the key is on the left of the mid
            else {
                return mid;                         // If the key was found, store the index and end the while loop
            }
        }
        return -1;
    }

    /**
     * Searches for the pivot point in a sorted and rotated array.
     * @param arr  The rotated array
     * @return The index where the pivot was found.
     * @author Shaniya Malcolm
     */
    private static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid + 1]){
                return mid;                 //The pivot is the index where the element next to it is smaller than it.
            }
            else if(arr[mid] < arr[low]){       
                high = mid;                     //If the mid < low we will search for the pivot on the left of the mid
            }
            else if(arr[mid] > arr[high]){      //If the mid > high we will search for the pivot on the right of the mid
                low = mid;
            }
        }

        return -1;      // An error occured.
    }
    
}
