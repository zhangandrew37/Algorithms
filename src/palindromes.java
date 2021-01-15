import java.util.*;

/**
 * A class to calculate the amount of palindromes that exist within a string
 *
 * @author Andrew Zhang
 * @version 1.0
 * @since 1.8
 */

public class palindromes {

    /**
     * This is the method that iteratively calculates the number of palindromes within a string
     *
     * @param string This is the string
     * @return the number of palindromes within the string
     */
    static int iterativePalindromes(String string){
        int total = 0;
        for(int i=0; i<string.length(); i++){
            for(int j=i+1; j<=string.length(); j++){
                StringBuilder word = new StringBuilder(string.substring(i,j));
                StringBuilder reverse = word.reverse();
                if(word.length()>1 && reverse.toString().equals(string.substring(i,j))) total++;
            }
        }
        return total;
    }

    /**
     * This is the method that recursively calculates the number of palindromes within a string
     *
     * @param string This is the string
     * @return the number of palindromes within the string
     */
    static int recursivePalindromes(String string, int pointerA, int pointerB){
        boolean flag = false;
        String substring = string.substring(pointerA, pointerB+1);
        StringBuilder word = new StringBuilder(substring);
        StringBuilder reverse = word.reverse();
        if(substring.length()>1 && reverse.toString().equals(substring)) flag = true;

        pointerB--;
        if(pointerA == pointerB){
            pointerA++;
            pointerB = string.length()-1;
            if(pointerA == string.length()-1){
                if(flag) return 1; else return 0;
            }
        } else if(pointerB < 0){
            if(flag) return 1; else return 0;
        }

        if(flag) return recursivePalindromes(string, pointerA, pointerB) + 1;
        else return recursivePalindromes(string, pointerA, pointerB);
    }

    /**
     * This is the main method
     *
     * @param args The command-line arguments
     */
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().toLowerCase();
        System.out.println(iterativePalindromes(string));
        System.out.println(recursivePalindromes(string, 0, string.length()-1));
    }
}
