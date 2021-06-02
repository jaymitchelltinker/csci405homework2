
// Java program for implementation of Bubble Sort
class BubbleSort
{

    // need to count:
    // 1. num comparisons
    // 2. num assignments
    static int[] bubbleSort(int arr[])
    {
        // comp and assignment array
        int[] cmpasn = {0,0};

        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1]) // comp
                {
                    cmpasn[0]++;
                    cmpasn[1]+=3;
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j]; // ass
                    arr[j] = arr[j+1]; // ass
                    arr[j+1] = temp; // ass
                }
            }
        }
        return cmpasn;
    }
 
    /* Prints the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method to test above
    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */