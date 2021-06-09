import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        // int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int n = arr.length;     //Size of the array
        // int d = 0;              //The number of elements we are rotating
        // int [] rotatedArr = rotate(arr, d, n);
        // System.out.println(Arrays.toString(rotatedArr));
        
        // int key = 4;
        // search(rotatedArr, key);

        int[] arr = new int[]{11, 15, 6, 8, 9, 10};
        int sum = 16;
        findPair(arr, sum);
        arr = new int[]{11, 15, 26, 38, 9, 10};
        sum = 35;
        findPair(arr, sum);
        arr = new int[]{11, 15, 26, 38, 9, 10};
        sum = 45;
        findPair(arr, sum);
    }

    /**
     * Searching for a pair with a given sum in a sorted and rotated array
     * @param arr The given array
     * @param sum The given sum 
     */
    public static void findPair(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++){
            int value = sum - arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] == value){
                    System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                    return;
                }
            }    
        }
        System.out.println("There is no pair with the sum " + sum);
    }

    /**
     * Rotates an array of size n by d elements
     * @param arr   The array we are rotating
     * @param d     The number of elements we are rotating by in the array
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

        return rotatedArr;
    }

    /**
     * Searches for a value in a sorted and rotated array
     * @param rotatedArr The rotated array
     * @author Shaniya Malcolm
     */
    public static void search(int[] rotatedArr, int key){
        int pivot = findPivot(rotatedArr);
        if(pivot == -2){System.out.println("An error occured while finding the pivot point.");  System.exit(0);}
        
        int index;
        if(pivot == -1){
            index = findKey(key, rotatedArr);       //If the array is already sorted we can simply find the key
            printSearchResults(key, index, 0);
        }else{
            int [] arr = rotate(rotatedArr, pivot+1, rotatedArr.length);    //Rotate the array until it is sorted
            index = findKey(key, arr);                                      //We can then call binary search on the sorted array
            printSearchResults(key, index, pivot+1);                        
        }
    }

    /**
     *  Prints the results of the binary search. If the key was found, prints the index of the key.
     * If the key was not found displays a key not found message.
     * @param key    The value we are searching for in the array
     * @param index  The index where the key was found in the sorted array
     * @param i      The number added to index to determine where the key was found in the rotated array
     */
    private static void printSearchResults(int key, int index, int i) {
        if(index == -1)
            System.out.println("The key was not found");
        else
            System.out.println("The key (" + key + ") was found at index " + (index+i));
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
            else{return mid;}                        // If the key was found, return the mid index                   
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
            else
                return -1;                  // There is no pivot point.
        }

        return -2;      // An error occured.
    }
    
}
