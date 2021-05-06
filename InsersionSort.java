// Java program for implementation of Insertion Sort
class InsertionSort {
    /*Function to sort array using insertion sort*/
    public static void sort(int arr[])
    {
        Integer comparisons = 0;
        Integer assignments = 0;

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) { // comp
                comparisons++;
                arr[j + 1] = arr[j]; // assignment
                assignments++;
                j = j - 1;
            }
            arr[j + 1] = key; // assignment
            assignments++;
        }
        System.out.println("COMPS = " + comparisons);
        System.out.println("ASSNG = " + assignments);
    }
 
    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 

    static void addOne(Integer i) {
        i = i+1;
    }
    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
 
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
 
        printArray(arr);
    }
} /* This code is contributed by Rajat Mishra. */