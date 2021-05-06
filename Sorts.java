import java.util.Random;
import java.util.Math;

import ShellSort;
import ShannonSort;
import InsersionSort;

public class Sorts {

    /*  unsortArray
     *      takes an array that is already sorted and unsorts a percentage of it given as a parameter
     */
    public static void unsortArray(int[] arr, int percentSort) {
        if (percentSort > 100 || percentSort < 0)
        {
            System.out.println("percentSort is incorrect");
            return;
        }
    }

    /*  createArray
     *      creates an returns a completely sorted array of size, sz
     */
    public static int[] createArray(int sz) {
        int[] arr = new int[sz];

        return arr;
    }

    /*  reverseArray
     *      takes a given array and reverses the order of a percentage of the array
     */
    public static void reverseArray(int[] arr, int percentSort) {
        if (percentSort > 100 || percentSort < 0)
        {
            System.out.println("percentSort is incorrect");
            return;
        }
    }

    public static void main(String args[]) {

    }
}