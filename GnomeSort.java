
// Java Program to implement Gnome Sort
 
import java.util.Arrays;
public class GnomeSort {

    // need to count:
    // 1. num comparisons
    // 2. num assignments
    static int[] gnomeSort(int arr[], int n)
    {
        // comp and assignment array
        int[] cmpasn = {0,0};

        int index = 0;
 
        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1]) // comp
            {
                index++;
                cmpasn[0]++;
            }
            else {
                int temp = 0;
                temp = arr[index]; // ass
                arr[index] = arr[index - 1]; // ass
                arr[index - 1] = temp; // ass
                cmpasn[1] += 3;
                index--;
            }
        }
        return cmpasn;
    }
 
    // Driver program to test above functions.
    public static void main(String[] args)
    {
        int arr[] = { 34, 2, 10, -9 };
 
        gnomeSort(arr, arr.length);
 
        System.out.print("Sorted sequence after applying Gnome sort: ");
        System.out.println(Arrays.toString(arr));
    }
}
 
// Code Contributed by Mohit Gupta_OMG