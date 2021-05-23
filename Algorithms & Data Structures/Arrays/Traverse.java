public class Traverse{
    
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 10, 20, 17};
        traverse1(arr);
        traverse2(arr);
    }

    // Loops through each element in an array and prints it using a for loop
    private static void traverse2(int[] arr) {
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + "  ");
        System.out.println();
    }

    // Loops through each element in an array and prints it using a for each statement
    private static void traverse1(int[] arr) {
        for(int element: arr) System.out.print(element + "  ");
        System.out.println();
    }
}