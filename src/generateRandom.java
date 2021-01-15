import java.io.*;
import java.util.*;

/**
 * Class to randomly generate input
 *
 * @author Andrew Zhang
 * @version 1.0
 * @since 1.8
 */

public class generateRandom {

    /**
     * This is the main method
     *
     * @param args The command-line arguments
     * @throws IOException when there is a problem reading input or output
     */
    public static void main(String args[]) throws IOException {
        Writer fileWriter = new FileWriter("/Users/AndrewZ/Desktop/School Work/ICS4U0/Algorithms/src/input.txt", false);
        int min = 1;
        int max = 100000;
        int min1 = 10000;
        int max1 = 1000000;
        int [] arr = new int [100000];
        for(int i=0; i<50000; i++) {
            int randomInt = 0;
            while(true) {
                randomInt = (int) (Math.random() * (max - min + 1) + min);
                if(arr[randomInt]!=1){
                    arr[randomInt] = 1;
                    break;
                }
            }
            int random2 = (int) (Math.random() * (max1 - min1 + 1) + min1);
            fileWriter.write(randomInt + " " + random2 + "\n");
        }
        fileWriter.close();
    }
}

