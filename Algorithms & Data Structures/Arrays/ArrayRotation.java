import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
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
        System.out.println(pivot);

        findKey(5, rotatedArr, pivot);
    }

    /**
     * 
     * @param key The key we are searching for
     * @param arr 
     * @param pivot The pivot point of the array
     * @author Shaniya Malcolm
     */
    private static void findKey(int key, int[] arr, int pivot) {

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
