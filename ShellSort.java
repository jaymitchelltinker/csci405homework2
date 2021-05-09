// Java implementation of ShellSort
public class ShellSort
{
    /* function to sort arr using shellSort */
    public static int[] sort(int arrayToSort[])
    {
        int comparisons = 0;
        int assignments = 0;

        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    comparisons++;
                    arrayToSort[j] = arrayToSort[j - gap];
                    assignments++;
                    j -= gap;
                }
                comparisons++;
                arrayToSort[j] = key;
                assignments++;
            }
        }

        int[] cmpasn = {comparisons, assignments};

        return cmpasn;
    }
} 
/*This code is contributed by Baeldung
https://www.baeldung.com/java-shell-sort */