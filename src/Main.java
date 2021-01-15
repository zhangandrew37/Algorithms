import java.util.*;
import java.io.*;

/**
 * Main class for a program that sorts employees based on their ID or salary
 *
 * @author Andrew Zhang
 * @version 1.0
 * @since 1.8
 */

public class Main {

    /**
     * This is the method that bubble sorts Employee ID
     *
     * @param employees This is the array that stores Employee IDs and salaries
     */
    static void bubbleSortId(Employee [] employees){
        Employee temp = new Employee(-1,-1);
        for(int i=0; i<employees.length-1; i++){
            for(int j=0; j<employees.length-i-1; j++){
                if(employees[j].getId() > employees[j+1].getId()){
                    temp.setId(employees[j+1].getId());
                    temp.setSalary(employees[j+1].getSalary());
                    employees[j+1].setId(employees[j].getId());
                    employees[j+1].setSalary(employees[j].getSalary());
                    employees[j].setId(temp.getId());
                    employees[j].setSalary(temp.getSalary());
                }
            }
        }
    }

    /**
     * This is the method that insertion sorts Employee salary
     *
     * @param employees This is the array that stores Employee IDs and salaries
     */
    static void insertionSortSalary(Employee [] employees){
        Employee temp = new Employee(-1,-1);
        for(int i=1; i<employees.length; i++){
            temp.setId(employees[i].getId());
            temp.setSalary(employees[i].getSalary());
            int j = i;
            while(j>0 && temp.getSalary()<employees[j-1].getSalary()){
                employees[j].setId(employees[j-1].getId());
                employees[j].setSalary(employees[j-1].getSalary());
                j-= 1;
            }
            employees[j].setId(temp.getId());
            employees[j].setSalary(temp.getSalary());
        }
    }

    /**
     * This is the method that uses linear search to find Employee ID based on salary
     *
     * @param employees This is the array that stores Employee IDs and salaries
     * @param salary This is the salary of the Employee
     * @return the ID of the Employee as an int| -1 if not found in employees
     */
    static int linearSearchId(Employee [] employees, int salary){
        for(Employee e: employees){
            if(e.getSalary() == salary) return e.getId();
        }
        return -1;
    }

    /**
     * This is the method that uses bubble sort to find Employee salary based on ID
     *
     * @param employees This is the array that stores Employee IDs and salaries
     * @param id This is the ID of the Employee
     * @return the salary of the Employee as an int| -1 if not found in employees
     */
    static int binarySearchSalary(Employee [] employees, int id){
        int lowerBound = 0;
        int upperBound = employees.length-1;

        while(lowerBound <= upperBound){
            int midPoint = (lowerBound + upperBound) / 2;
            if(employees[midPoint].getId() < id) lowerBound = midPoint + 1;
            else if(employees[midPoint].getId() > id) upperBound = midPoint -1;
            else return midPoint;
        }
        return -1;
    }

    /**
     * This is the main method
     *
     * @param args The command-line arguments
     * @throws IOException when there is a problem reading input or output
     */
    public static void main(String [] args) throws IOException{
        Writer fileWriter = new FileWriter("output.txt", false);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Employee [] employees = new Employee[50000];
        employees[0] = new Employee(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        for(int i=1; i<50000; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                employees[i] = new Employee(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }

        //displaying sorted array of object
        bubbleSortId(employees);
        fileWriter.write("===================================================================================" + "\n");
        fileWriter.write("Employees sorted by ID (followed by their salary)" + "\n");
        fileWriter.write("===================================================================================" + "\n");
        for(Employee e: employees){
            fileWriter.write("ID: " + e.getId() + " | Salary: $" +  e.getSalary() + "\n");
        }

//        //linear search
//        long linear0 = System.currentTimeMillis();
//        linearSearchId(employees, 0);
//        long linear1 = System.currentTimeMillis();
//        fileWriter.write( "Linear Search Time: " + (linear1-linear0) + " ms" + "\n");
//
//        //binary search
//        long binary0 = System.currentTimeMillis();
//        Arrays.sort(employees);
//        long binary1 = System.currentTimeMillis();
//        fileWriter.write("Sorting + Binary Search Time: " + (binary1-binary0) + " ms" + "\n");
//
//        //bubble sort
//        long bubble0 = System.currentTimeMillis();
//        bubbleSortId(employees);
//        long bubble1 = System.currentTimeMillis();
//        fileWriter.write("Bubble Sort Time: " + (bubble1-bubble0) + " ms" + "\n");
//
//        //insertion sort
//        long insertion0 = System.currentTimeMillis();
//        insertionSortSalary(employees);
//        long insertion1 = System.currentTimeMillis();
//        fileWriter.write("Insertion Sort Time: " + (insertion1-insertion0) + " ms" + "\n");
//
//        //built in sort
//        long sort0 = System.currentTimeMillis();
//        Arrays.sort(employees);
//        long sort1 = System.currentTimeMillis();
//        fileWriter.write(".sort Time: " + (sort1-sort0) + " ms" + "\n");

        fileWriter.close();
    }
}
