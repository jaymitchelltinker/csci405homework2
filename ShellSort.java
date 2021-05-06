// Java implementation of ShellSort
public class ShellSort
{
    /* An utility function to print array of size n*/
    // static void printArray(int arr[])
    // {
    //     int n = arr.length;
    //     for (int i=0; i<n; ++i)
    //         System.out.print(arr[i] + " ");
    //     System.out.println();
    // }
  
    /* function to sort arr using shellSort */
    public int sort(int arr[])
    {
        int comparisons = 0;
        int assignments = 0;

        int n = arr.length;
  
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];
  
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) { // 2 comps
                    comparisons+=2;
                    arr[j] = arr[j - gap]; // assign
                    assignments++;
                }
  
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp; // assign
                assignments++;
            }
        }

        System.out.println("COMPS= " + comparisons + "\nASSNG= " + assignments);
        return 0;
    }
  
    // Driver method
    // public static void main(String args[])
    // {
    //     int arr[] = {12, 34, 54, 2, 3};
    //     System.out.println("Array before sorting");
    //     printArray(arr);
  
    //     ShellSort ob = new ShellSort();
    //     ob.sort(arr);
  
    //     System.out.println("Array after sorting");
    //     printArray(arr);
    // }
} 
/*This code is contributed by Rajat Mishra */