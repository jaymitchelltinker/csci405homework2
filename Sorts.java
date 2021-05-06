import java.util.Random;
// import java.util.Math;

// import ShellSort;
// import ShannonSort;
// import InsersionSort;

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
        Random rand = new Random();
        int sortVal = 100/percentSort;

        for (int i = 0; i < (arr.length/sortVal); i++) {
            arr[i] = rand.ints(arr.length * -2, (arr.length/sortVal)).limit(1).findFirst().getAsInt();
        }

    }

    /*  createArray
     *      creates an returns a completely sorted array of size, sz
     */
    public static int[] createArray(int sz) {
        int[] arr = new int[sz];

        for (int i = 0; i < sz; i++) {
            arr[i] = i;
        }

        return arr;
    }

    /*  reverseArray
     *      takes a given array and reverses the order of a percentage of the array
     */
    public static void reverseArray(int[] arr, int percentSort) {

        if (percentSort > 100 || percentSort <= 0)
        {
            System.out.println("percentSort must be larger than 0 and less than 100.");
            return;
        }

        int sortVal = 100/percentSort;

        for (int i = 0; i < (arr.length/sortVal)/2; i++) {
            int temp = arr[i];
            arr[i] = arr[((arr.length/sortVal) - 1) - i];
            arr[((arr.length/sortVal) - 1) - i] = temp;
        }
    }

    public static void main(String args[]) {
        int[] myArr = createArray(15);

        // reverseArray(myArr, 20);
        unsortArray(myArr, 50);

        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }

        System.out.println();
    }
}