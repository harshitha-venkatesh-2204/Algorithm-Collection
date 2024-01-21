import java.math.BigInteger;

public class AlaCarta {
    public static void main(String[] args) {
        // Test Case 1: 7000 * 7294
        BigInteger num1_case1 = BigInteger.valueOf(7000);
        BigInteger num2_case1 = BigInteger.valueOf(7294);
        calculateAndPrintResult(num1_case1, num2_case1);

        // Test Case 2: 25 * 5038385
        BigInteger num1_case2 = BigInteger.valueOf(25);
        BigInteger num2_case2 = BigInteger.valueOf(5038385);
        calculateAndPrintResult(num1_case2, num2_case2);

        // Test Case 3: -59724 * 783
        BigInteger num1_case3 = BigInteger.valueOf(-59724);
        BigInteger num2_case3 = BigInteger.valueOf(783);
        calculateAndPrintResult(num1_case3, num2_case3);

        // Test Case 4: 8516 * -82147953548159344
        BigInteger num1_case4 = BigInteger.valueOf(8516);
        BigInteger num2_case4 = BigInteger.valueOf(-82147953548159344L);
        calculateAndPrintResult(num1_case4, num2_case4);

        // Test Case 5: 45952456856498465985 * 98654651986546519856
        BigInteger num1_case5 = new BigInteger("45952456856498465985");
        BigInteger num2_case5 = new BigInteger("98654651986546519856");
        calculateAndPrintResult(num1_case5, num2_case5);

        // Test Case 6: -45952456856498465985 * -98654651986546519856
        BigInteger num1_case6 = new BigInteger("-45952456856498465985");
        BigInteger num2_case6 = new BigInteger("-98654651986546519856");
        calculateAndPrintResult(num1_case6, num2_case6);
    }

    private static void calculateAndPrintResult(BigInteger num1, BigInteger num2) {
        int sign = 1;

        if ((num1.compareTo(BigInteger.ZERO) < 0 && num2.compareTo(BigInteger.ZERO) > 0)
                || (num1.compareTo(BigInteger.ZERO) > 0 && num2.compareTo(BigInteger.ZERO) < 0)) {
            sign = -1;
        }

        BigInteger absoluteNum1 = num1.abs();
        BigInteger absoluteNum2 = num2.abs();

        BigInteger finalResult = BigInteger.ZERO;

        while (!absoluteNum2.equals(BigInteger.ZERO)) {
            if (absoluteNum2.testBit(0)) {
                finalResult = finalResult.add(absoluteNum1);
            }
            absoluteNum1 = absoluteNum1.shiftLeft(1);
            absoluteNum2 = absoluteNum2.shiftRight(1);
        }

        System.out.println("Result: " + BigInteger.valueOf(sign).multiply(finalResult));
    }
}
