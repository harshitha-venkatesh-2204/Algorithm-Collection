public class merged {

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {};
        int[] arr2 = {3, 7, 9};
        arr1 = mergeAndSort(arr1, arr2);
        printArray(arr1);

        int[] arr3 = {2, 7, 9};
        int[] arr4 = {1};
        arr3 = mergeAndSort(arr3, arr4);
        printArray(arr3);

        int[] arr5 = {1, 7, 10, 15};
        int[] arr6 = {3, 8, 12, 18};
        arr5 = mergeAndSort(arr5, arr6);
        printArray(arr5);

        int[] arr7 = {1, 3, 5, 5, 15, 18, 21};
        int[] arr8 = {5, 5, 6, 8, 10, 12, 16, 17, 17, 20, 25, 28};
        arr7 = mergeAndSort(arr7, arr8);
        printArray(arr7);
    }

    // Function to merge two sorted subarrays into a single sorted array
    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < m) {
            result[k++] = arr1[i++];
        }

        while (j < n) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
