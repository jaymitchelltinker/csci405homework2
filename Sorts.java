import java.util.Random;

import jdk.jfr.Percentage;

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
        double percentDouble = percentSort;
        double ratio = percentDouble/100;
        
        for (int i = 0; i < (arr.length*ratio)/2; i++) {
            arr[i] = rand.ints(arr.length * -2, (int)(arr.length*ratio)).limit(1).findFirst().getAsInt();
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

        double percentDouble = percentSort;
        double ratio = percentDouble/100;

        for (int i = 0; i < (arr.length*ratio)/2; i++) {
            int temp = arr[i];
            arr[i] = arr[((int)(arr.length*ratio) - 1) - i];
            arr[((int)(arr.length*ratio) - 1) - i] = temp;
        }
    }
    
    public static void main(String args[]) {
        int arrSize = 1000;
        String mode = "Reverse Sorted";
        int percentage = 100;

        int[] shannonDummy = new int[arrSize];
        int[] insertionDummy = new int[arrSize];
        int[] shellDummy = new int[arrSize];
        
        /* Processor time
        *
        * need to keep track of processor time at the beginning and the
        * end of the sorting algorithms to see how much time is spent on each
        * we can include a graph consisting of the processor-time/comps/assgns
         * so grab processor time at the beginning and then processor time at
         * the end.
         */
        
        long start = 0;
        long end = 0;
        
        long shannonTotalTime = 0;
        long insertionTotalTime = 0;
        long shellTotalTime = 0;
        
        int shannonComparisonCountTotal     = 0;
        int insertionComparisonCountTotal   = 0;
        int shellSortComparisonCountTotal   = 0;
        
        int shannonAssignmentCountTotal     = 0;
        int insertionAssignmentCountTotal   = 0;
        int shellSortAssignmentCountTotal   = 0;
        
        /* run test 101 times
        *
        * the first time is to load classes and static blocks.
        * the next 100 times are to take actual data.
        */
        for (int i = 0; i < 101; i++)
        {
            int[] myArr = createArray(arrSize);
            reverseArray(myArr, percentage);

            System.arraycopy(myArr, 0, shannonDummy, 0, arrSize);
            System.arraycopy(myArr, 0, insertionDummy, 0, arrSize);
            System.arraycopy(myArr, 0, shellDummy, 0, arrSize);
            
            //shannon sort
            start = System.nanoTime(); // begin the sort now
            int[] shannonData = ShannonSort.Shannon(shannonDummy);
            end = System.nanoTime() - start; // after finishing the sort
            if (i != 0)
            {
                shannonTotalTime += end;
                shannonComparisonCountTotal += shannonData[0];
                shannonAssignmentCountTotal += shannonData[1];
            }
            
            //insertion sort
            start = System.nanoTime(); // begin the sort now
            int[] insertionData = InsertionSort.insertionSort(insertionDummy);
            end = System.nanoTime() - start; // after finishing the sort
            if (i != 0)
            {
                insertionTotalTime += end;
                insertionComparisonCountTotal += insertionData[0];
                insertionAssignmentCountTotal += insertionData[1];
            }

            //shell sort
            start = System.nanoTime(); // begin the sort now
            int[] shellData = ShellSort.sort(shellDummy);
            end = System.nanoTime() - start; // after finishing the sort
            if (i != 0)
            {
                shellTotalTime += end;
                shellSortComparisonCountTotal += shellData[0];
                shellSortAssignmentCountTotal += shellData[1];
            } 
        }

        shannonComparisonCountTotal     = shannonComparisonCountTotal/100;
        shannonAssignmentCountTotal     = shannonAssignmentCountTotal/100;
        shannonTotalTime                = shannonTotalTime/100;
        
        insertionComparisonCountTotal   = insertionComparisonCountTotal/100;
        insertionAssignmentCountTotal   = insertionAssignmentCountTotal/100;
        insertionTotalTime              = insertionTotalTime/100;

        shellSortComparisonCountTotal   = shellSortComparisonCountTotal/100;
        shellSortAssignmentCountTotal   = shellSortAssignmentCountTotal/100;
        shellTotalTime                  = shellTotalTime/100;
        
        System.out.println("========== " + percentage + "% " + mode + " =================");

        System.out.println("======================================================");
        System.out.println("Shannon Sort Stats:: ");
        System.out.println("Comparisons:: " + shannonComparisonCountTotal);
        System.out.println("Assignments:: " + shannonAssignmentCountTotal);
        System.out.println("Average Time: " + shannonTotalTime);
        System.out.println("======================================================");

        System.out.println("Insertion Sort Stats:: ");
        System.out.println("Comparisons:: " + insertionComparisonCountTotal);
        System.out.println("Assignments:: " + insertionAssignmentCountTotal);
        System.out.println("Average Time: " + insertionTotalTime);
        System.out.println("======================================================");

        System.out.println("Shell Sort Sort Stats:: ");
        System.out.println("Comparisons:: " + shellSortComparisonCountTotal);
        System.out.println("Assignments:: " + shellSortAssignmentCountTotal);
        System.out.println("Average Time: " + shellTotalTime);
        System.out.println("======================================================");

        // for (int i = 0; i < insertionDummy.length; i++)
        // {
        //     System.out.print(insertionDummy[i] + " ");
        // }

    }
}