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
     * @param n     The size 
     */
    public static void rotate(int[] arr, int d, int n) {
        System.out.println("rotating the elements");
    }
    
}
