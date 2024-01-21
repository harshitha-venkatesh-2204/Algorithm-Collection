import java.math.BigInteger;

public class RectangleMultiplication {

    public static BigInteger rectangleMultiply(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("7000");
        BigInteger num2 = new BigInteger("7294");
        BigInteger result1 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 1: " + result1);

        num1 = new BigInteger("25");
        num2 = new BigInteger("5038385");
        BigInteger result2 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 2: " + result2);

        num1 = new BigInteger("-59724");
        num2 = new BigInteger("783");
        BigInteger result3 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 3: " + result3);

        num1 = new BigInteger("8516");
        num2 = new BigInteger("-82147953548159344");
        BigInteger result4 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 4: " + result4);

        num1 = new BigInteger("45952456856498465985");
        num2 = new BigInteger("98654651986546519856");
        BigInteger result5 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 5: " + result5);

        num1 = new BigInteger("-45952456856498465985");
        num2 = new BigInteger("-98654651986546519856");
        BigInteger result6 = rectangleMultiply(num1, num2);
        System.out.println("Test Case 6: " + result6);
    }
}
