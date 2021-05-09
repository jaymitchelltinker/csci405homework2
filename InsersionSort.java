// Java program for implementation of Insertion Sort
class InsertionSort {
    /*Function to sort array using insertion sort*/
    public static int[] insertionSort(int[] input) {
        int[] cmpassn = {0,0};
        for (int i = 1; i < input.length; i++) { 
            int key = input[i]; 
            int j = i - 1;
            while (j >= 0 && input[j] > key) { // comparison
                cmpassn[0]++;
                input[j + 1] = input[j]; // assignment
                cmpassn[1]++;
                j = j - 1;
            }
            cmpassn[0]++;
            cmpassn[1]++;
            input[j + 1] = key;
        }

        return cmpassn;
    }
 
}
/*This code is contributed by Baeldung
https://www.baeldung.com/java-insertion-sort */