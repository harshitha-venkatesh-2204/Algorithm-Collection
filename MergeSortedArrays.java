public class MergeSortedArrays {
    public static int[] mergeArrays(int[] A, int[] B, int m, int n) {
        int i = 0, j = 0, k = 0;
        int[] aux = new int[m + n];
        
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                aux[k] = A[i];
                k++;
                i++;
            } else {
                aux[k] = B[j];
                k++;
                j++;
            }
        }
        
        while (i < m) {
            aux[k] = A[i];
            k++;
            i++;
        }
        
        while (j < n) {
            aux[k] = B[j];
            k++;
            j++;
        }
        
        return aux;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] A1 = {};
        int[] B1 = {3, 7, 9};
        int m1 = A1.length;
        int n1 = B1.length;
        int[] mergedArray1 = mergeArrays(A1, B1, m1, n1);
        System.out.println("Test Case 1:");
        printArray(mergedArray1);

        int[] A2 = {2, 7, 9};
        int[] B2 = {1};
        int m2 = A2.length;
        int n2 = B2.length;
        int[] mergedArray2 = mergeArrays(A2, B2, m2, n2);
        System.out.println("\nTest Case 2:");
        printArray(mergedArray2);

        int[] A3 =  {1, 7, 10, 15};
        int[] B3 = {3, 8, 12, 18};
        int m3 = A3.length;
        int n3 = B3.length;
        int[] mergedArray3 = mergeArrays(A3, B3, m3, n3);
        System.out.println("\nTest Case 3:");
        printArray(mergedArray3);

        int[] A4 =  {1, 3, 5, 5, 15, 18, 21};
        int[] B4 = {5, 5, 6, 8, 10, 12, 16, 17, 17, 20, 25, 28};
        int m4 = A4.length;
        int n4 = B4.length;
        int[] mergedArray4 = mergeArrays(A4, B4, m4, n4);
        System.out.println("\nTest Case 4:");
        printArray(mergedArray4);

        

    }
}
