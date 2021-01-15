import java.util.*;

/**
 * A class to calculate a non-negative integer's sum of digits
 *
 * @author Andrew Zhang
 * @version 1.0
 * @since 1.8
 */

public class sumdigits {
    /**
     * This is the method that iteratively calculates sum of digits of a non-negative integer
     *
     * @param number This is the non-negative integer
     * @return the sum of the digits of the number as an int
     */
    static int iterativeSumDigits(int number) {
        int sum = 0;
        String string = Integer.toString(number);
        for (int i = 0; i < string.length(); i++) {
            sum += string.charAt(i) - 48; //ASCII conversion
        }
        return sum;
    }

    /**
     * This is the method that recursively calculates sum of digits of a non-negative integer
     *
     * @param number This is the non-negative integer
     * @return the sum of the digits of the number as an int
     */
    static int recursiveSumDigits(int number) {
        if(number<=9) return number;
        return recursiveSumDigits(number/10) + (number%10);
    }

    /**
     * This is the main method
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(iterativeSumDigits(num));
        System.out.println(recursiveSumDigits(num));
    }
}
