import java.math.BigInteger;

public class AlaCarteMultiplication {

    public static BigInteger alaCarte(BigInteger x, BigInteger y) {
        if (x.bitLength() <= 64 || y.bitLength() <= 64) {
            return x.multiply(y);
        }

        int n = Math.max(x.bitLength(), y.bitLength());
        int halfN = (n + 1) / 2;

        BigInteger xHigh = x.shiftRight(halfN);
        BigInteger xLow = x.subtract(xHigh.shiftLeft(halfN));
        BigInteger yHigh = y.shiftRight(halfN);
        BigInteger yLow = y.subtract(yHigh.shiftLeft(halfN));

        BigInteger z0 = alaCarte(xLow, yLow);
        BigInteger z2 = alaCarte(xHigh, yHigh);
        BigInteger z1 = alaCarte(xLow.add(xHigh), yLow.add(yHigh)).subtract(z0).subtract(z2);

        return z2.shiftLeft(2 * halfN).add(z1.shiftLeft(halfN)).add(z0);
    }

    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("7000");
        BigInteger num2 = new BigInteger("7294");
        BigInteger result1 = alaCarte(num1, num2);
        System.out.println("Test Case 1: " + result1);

        num1 = new BigInteger("25");
        num2 = new BigInteger("5038385");
        BigInteger result2 = alaCarte(num1, num2);
        System.out.println("Test Case 2: " + result2);

        num1 = new BigInteger("-59724");
        num2 = new BigInteger("783");
        BigInteger result3 = alaCarte(num1, num2);
        System.out.println("Test Case 3: " + result3);

        num1 = new BigInteger("8516");
        num2 = new BigInteger("-82147953548159344");
        BigInteger result4 = alaCarte(num1, num2);
        System.out.println("Test Case 4: " + result4);

        num1 = new BigInteger("45952456856498465985");
        num2 = new BigInteger("98654651986546519856");
        BigInteger result5 = alaCarte(num1, num2);
        System.out.println("Test Case 5: " + result5);

        num1 = new BigInteger("-45952456856498465985");
        num2 = new BigInteger("-98654651986546519856");
        BigInteger result6 = alaCarte(num1, num2);
        System.out.println("Test Case 6: " + result6);
    }
}


