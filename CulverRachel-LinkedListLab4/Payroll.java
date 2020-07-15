import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 * Payroll holds methods that will read in a file containing emmployees, outputs employee list, number of employees, women employees, 
 * those making =< 35,000 and working with company for =< 5 years, employees given a raise, list sorted in alphavetical order, 
 * updated list after employees are hired and fired to terminal window and output file.
 * 
 * @author Culver, Rachel 
 * @version 11/09/2017
 */
public class Payroll
{
    private PrintWriter pw;
    private Employee employee = new Employee();
    private ObjectList inputLLL = new ObjectList();
    private Scanner fileScan = new Scanner(new File("payfile.txt"));
    private Scanner hireFileScan = new Scanner(new File("hirefile.txt"));
    private Scanner fireFileScan = new Scanner(new File("firefile.txt"));

     /**
     * Constructor for objects of class Payroll
     * 
     * * @param   pw     PrintWriter object passed in as parameter
     */
    public Payroll(PrintWriter pw) throws IOException {
        this.pw = pw;
    }
    
    /**
     * Scans in employees from file and inputs them into linear linked list.
     *
     */
    public void getEmployees() throws IOException {
       while (fileScan.hasNext()){
           ObjectListNode node = new ObjectListNode();
           Employee employee = new Employee();    
           String buf = fileScan.nextLine();
           employee.parseString(buf);
           node.setInfo(employee);
           inputLLL.addLast(node);
       }
    }
    
        /**
         * Outputs the contents of the linear linked list to terminal window and to output file.
         *
         */
        public void outputContents() { 
       ObjectListNode p = inputLLL.getFirstNode();
       System.out.println("First Name\t" + "Last Name\t" + "Gender\t\t" + "Tenure\t\t" + "Rate\t\t" + "Salary");
       pw.println("First Name\t" + "Last Name\t" + "Gender\t\t" + "Tenure\t\t" + "Rate\t\t" + "Salary");
       while(p != null) {
            Employee info = (Employee) p.getInfo();
            System.out.println(info.getFirstName() + "\t\t" + info.getLastName() + "\t\t" + info.getGender() + "\t\t" + info.getTenure() + "\t\t" + info.getRate() + "\t\t" + info.getSalary());
            pw.println(info.getFirstName() + "\t\t" + info.getLastName() + "\t\t" + info.getGender() + "\t\t" + info.getTenure() + "\t\t" + info.getRate() + "\t\t" + info.getSalary());
            p = p.getNext();
       }
    } 
    
    /**
     * Outputs the number of employees to terminal window and to output file.
     *
     */
    public void countEmployees() {
        System.out.println(" ");
        System.out.println("Number of Employees");
        pw.println(" ");
        pw.println("Number of Employees");
        System.out.println(inputLLL.size());
        pw.println(inputLLL.size());
    }

    /**
     * Outputs all of the women employees to terminal window and to output file.
     *
     */
    public void womenEmployees() {
        ObjectListNode p = inputLLL.getFirstNode();
        System.out.println(" ");
        System.out.println("Women on Payroll");
        pw.println(" ");
        pw.println("Women on Payroll");
        while(p != null) {
         Employee info = (Employee) p.getInfo();
         if(info.getGender().equals("F")) {
             System.out.println(info.getFirstName() + " " + info.getLastName());
             pw.println(info.getFirstName() + " " + info.getLastName());
            }
         p = p.getNext();   
        }
        
    }
    
    /**
     * Outputs the first and last names and salary of employees who make more than $35000 per year and who have been with the company for at least 5 years to terminal window and to output file.
     *
     */
    public void salaryandYearsWithComp() {
        ObjectListNode p = inputLLL.getFirstNode();
        System.out.println(" ");
        System.out.println("Making $35,000 or More a Year and With Company 5 or More Years");
        pw.println(" ");
        pw.println("Making $35,000 or More a Year and With Company 5 or More Years");
        while(p != null) {
         Employee info = (Employee) p.getInfo();
         if(info.getTenure() >= 5 && info.getGender().equals("F")) {
         if(info.getRate().equals("W")) {
             double yearlySalary = 52 * (Double) info.getSalary();
             if(yearlySalary > 35000) {
                System.out.println(info.getFirstName() + " " + info.getLastName());
                pw.println(info.getFirstName() + " " + info.getLastName());
                }
            }
         else{
             double yearlySalary = 2080 * (Double) info.getSalary();
             if(yearlySalary >= 35000) {
                System.out.println(info.getFirstName() + " " + info.getLastName());
                pw.println(info.getFirstName() + " " + info.getLastName());
                }
            }  
        }
        p = p.getNext();
       }
    }
    
    /**
     * Gives a raise of $.75 per hour to all employees making less than $10 on an hourly wage and less than $350 per week. Outputs first name, last name, and new wage to terminal window and output file.
     *
     */
    public void raise() {
        System.out.println(" ");
        System.out.println("Employees given Raise");
        pw.println(" ");
        pw.println("Employees given Raise");
        hourlyRaise();
        yearlyRaise();
    }
    
    /**
     * Gives a raise of $.75 per hour to all employees making less than $10 on an hour.
     *
     */
    private void hourlyRaise() { 
        ObjectListNode p = inputLLL.getFirstNode();
         while(p != null) {
         Employee info = (Employee) p.getInfo();
         if(info.getRate().equals("H") && (Double) info.getSalary() < 10.00) {
             info.setSalary((Double) info.getSalary() + .75);
             System.out.println(info.getFirstName() + " " + info.getLastName() + " " + info.getSalary());
             pw.println(info.getFirstName() + " " + info.getLastName() + " " + info.getSalary());
            }
         p = p.getNext();   
        }
    }
    
    /**
     * Gives a raise of $.75 per hour to all employees making less than $350 per week. 
     *
     */
    private void yearlyRaise() { 
        ObjectListNode p = inputLLL.getFirstNode();
         while(p != null) {
         Employee info = (Employee) p.getInfo();
        
         if(info.getRate().equals("W") && (Double) info.getSalary() < 350.00) {
             info.setSalary((Double) info.getSalary() + 50.00);
             System.out.println(info.getFirstName() + " " + info.getLastName() + " " + info.getSalary());
             pw.println(info.getFirstName() + " " + info.getLastName() + " " + info.getSalary());
            }
         p = p.getNext();   
        }
    }

    /**
     * Sorts the nodes of the linear linked list into alphabetical order according to last name and outputs them to terminal window and output file.
     *
     */
    public void sort() {
        ObjectListNode p = inputLLL.getFirstNode();
        ObjectList newList = new ObjectList();
        while(p != null) {
            Employee sortEmployees = (Employee) inputLLL.removeFirst();
            newList.insert(sortEmployees);
            p = p.getNext();
        }
        inputLLL = newList;
        System.out.println(" ");
        System.out.println("Alphabetically Sorted Employees ");
        pw.println(" ");
        pw.println("Alphabetically Sorted Employees ");
               
        ObjectListNode q = inputLLL.getFirstNode();
         while(q != null) {
            Employee info = (Employee) q.getInfo();
            System.out.println(info.getFirstName() + "\t\t" + info.getLastName() + "\t\t" + info.getSalary());
            pw.println(info.getFirstName() + "\t\t" + info.getLastName() + "\t\t" + info.getSalary());
            q = q.getNext();
        }
    }
    
    /**
     * Adds all hired employees to the employee list and outputs them to the terminal window and output file.
     *
     */
    public void hiredEmployees() throws IOException{
        while (hireFileScan.hasNext()){
           ObjectListNode node = new ObjectListNode();
           Employee employee = new Employee();    
           String buf = hireFileScan.nextLine();
           employee.parseString(buf);
           node.setInfo(employee);
           inputLLL.insert(node);
       }
       System.out.println(" ");
       System.out.println("Hired Employees Added to List");
       pw.println(" ");
       pw.println("Hired Employees Added to List");
       ObjectListNode q = inputLLL.getFirstNode();
       while(q != null) {
            Employee info = (Employee) q.getInfo();
            System.out.println(info.getFirstName() + "\t\t" + info.getLastName());
            pw.println(info.getFirstName() + "\t\t" + info.getLastName());
            q = q.getNext();
     }
    }
    
    /**
     * Removes all hired employees to the employee list and outputs them to the terminal window and output file.
     *
     */
    public void firedEmployees() throws IOException {
                while (fireFileScan.hasNext()){
           ObjectListNode node = new ObjectListNode();
           Employee employee = new Employee();    
           String buf = fireFileScan.nextLine();
           employee.parseNames(buf);
           node.setInfo(employee);
           inputLLL.remove(employee);
       }
       System.out.println(" ");
       System.out.println("Fired Employees Removed From  List");
       pw.println(" ");
       pw.println("Fired Employees Removed From  List");
       ObjectListNode q = inputLLL.getFirstNode();
         while(q != null) {
            Employee info = (Employee) q.getInfo();
            System.out.println(info.getFirstName() + "\t\t" + info.getLastName());
            pw.println(info.getFirstName() + "\t\t" + info.getLastName());
            q = q.getNext();
       }
    }
  
}
