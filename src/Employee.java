/**
 * A class holding Employee's ID and salary
 *
 * @author Andrew Zhang
 * @version 1.0
 * @since 1.8
 */
public class Employee implements Comparable<Employee> {
    private int id;
    private int salary;

    /**
     * This is the constructor method for Employee
     *
     * @param id This is the ID of the Employee
     * @param salary his is the salary of the Employee
     */
    public Employee(int id, int salary){
        this.id = id;
        this.salary = salary;
    }

    /**
     * Setter for id field
     *
     * @param id This is the id of the object
     */

    public void setId(int id){
        this.id = id;
    }

    /**
     * Getter for id field
     *
     * @return the ID of the employee as an int
     */

    public int getId(){
        return id;
    }

    /**
     * Setter for salary field
     *
     * @param salary This is the salary of the object
     */

    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * Getter for salary field
     *
     * @return the salary of the employee as an int
     */

    public int getSalary(){
        return salary;
    }

    /**
     * This method represents the object as a String instead of a Hashcode value
     *
     * @return The string representation of the object
     */
    @Override
    public String toString(){
        return "Employee | ID: " + id + ", salary: " + salary;
    }

    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
