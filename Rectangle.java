import java.math.BigInteger;
import java.util.Scanner;

public class Rectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test Case 1: 7000 * 7294
        BigInteger num1_case1 = new BigInteger("7000");
        BigInteger num2_case1 = new BigInteger("7294");
        calculateAndPrintResult(num1_case1, num2_case1);

        // Test Case 2: 25 * 5038385
        BigInteger num1_case2 = new BigInteger("25");
        BigInteger num2_case2 = new BigInteger("5038385");
        calculateAndPrintResult(num1_case2, num2_case2);

        // Test Case 3: -59724 * 783
        BigInteger num1_case3 = new BigInteger("-59724");
        BigInteger num2_case3 = new BigInteger("783");
        calculateAndPrintResult(num1_case3, num2_case3);

        // Test Case 4: 8516 * -82147953548159344
        BigInteger num1_case4 = new BigInteger("8516");
        BigInteger num2_case4 = new BigInteger("-82147953548159344");
        calculateAndPrintResult(num1_case4, num2_case4);

        // Test Case 5: 45952456856498465985 * 98654651986546519856
        BigInteger num1_case5 = new BigInteger("45952456856498465985");
        BigInteger num2_case5 = new BigInteger("98654651986546519856");
        calculateAndPrintResult(num1_case5, num2_case5);

        // Test Case 6: -45952456856498465985 * -98654651986546519856
        BigInteger num1_case6 = new BigInteger("-45952456856498465985");
        BigInteger num2_case6 = new BigInteger("-98654651986546519856");
        calculateAndPrintResult(num1_case6, num2_case6);

        scanner.close();
    }

    private static void calculateAndPrintResult(BigInteger num1, BigInteger num2) {
        int sign = num1.signum() * num2.signum();

        BigInteger absoluteNum1 = num1.abs();
        BigInteger absoluteNum2 = num2.abs();

        // Initialize the rectangle array with BigInteger.ZERO
        int rows = absoluteNum2.toString().length();
        int cols = absoluteNum1.toString().length() + rows;  // Extra space for potential carry
        BigInteger[][] rectangle = new BigInteger[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rectangle[i][j] = BigInteger.ZERO;
            }
        }

        // Multiplication
        for (int i = 0; i < rows; i++) {
            int currentCol = cols - i - 1;  // Adjust currentCol based on row index
            BigInteger carry = BigInteger.ZERO;

            for (int j = absoluteNum1.toString().length() - 1; j >= 0; j--) {
                BigInteger product = rectangle[i][currentCol].add(absoluteNum1.remainder(BigInteger.TEN).multiply(absoluteNum2.remainder(BigInteger.TEN))).add(carry);
                rectangle[i][currentCol] = product.mod(BigInteger.TEN);
                carry = product.divide(BigInteger.TEN);
                currentCol--;
                absoluteNum1 = absoluteNum1.divide(BigInteger.TEN);
            }

            if (!carry.equals(BigInteger.ZERO)) {
                rectangle[i][currentCol] = carry;
            }

            absoluteNum2 = absoluteNum2.divide(BigInteger.TEN);
            absoluteNum1 = num1.abs();  // Reset absoluteNum1 for the next row
        }

        // Summation
        BigInteger[] result = new BigInteger[cols];
        BigInteger carry = BigInteger.ZERO;

        for (int currentCol = cols - 1; currentCol >= 0; currentCol--) {
            BigInteger sum = carry;

            for (int currentRow = 0; currentRow < rows; currentRow++) {
                sum = sum.add(rectangle[currentRow][currentCol]);
            }

            result[currentCol] = sum.mod(BigInteger.TEN);
            carry = sum.divide(BigInteger.TEN);
        }

        // Handle Sign
        if (sign == -1) {
            System.out.print("-");
        }

        // Output Result
        boolean leadingZeros = true;
        for (BigInteger digit : result) {
            if (!digit.equals(BigInteger.ZERO) || !leadingZeros) {
                System.out.print(digit);
                leadingZeros = false;
            }
        }

        if (leadingZeros) {
            System.out.print("0");
        }

        System.out.println();
    }
}
