import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int n = arr.length;     //Size of the array
        int d = 2;              //The number of elements we are rotating
        rotate(arr, d, n);
    }

    /**
     * Rotates an array of size n by d elements
     * @param arr   The array we are rotating
     * @param d     The number of elements in the array
     * @param n     The size of the array
     * @author      Shaniya Malcolm
     */
    public static void rotate(int[] arr, int d, int n) {
        int[] rotatedArr = new int[n];  // Create a new array of the same size
        
        // For each element, increase the index by the size of d and take the modulo to get the first elements in the array 
        for(int i = 0; i < n; i++){
            rotatedArr[i] = arr[(i + d) % n];
        }

        System.out.println(Arrays.toString(rotatedArr));
    }
    
}
