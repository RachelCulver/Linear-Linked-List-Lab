import java.io.*;
/**
 * Driver implements Payroll class
 * 
 * @author Culver, Rachel
 * ID# 009164179
 * 
 * @date 11/10/2017
 */
public class Driver
{
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Payroll payroll = new Payroll(pw);
        payroll.getEmployees(); 
        payroll.outputContents(); 
        payroll.countEmployees(); 
        payroll.womenEmployees(); 
        payroll.salaryandYearsWithComp();
        payroll.raise();
        payroll.sort(); 
        payroll.hiredEmployees(); 
        payroll.firedEmployees(); 
        pw.close(); 
    }
}