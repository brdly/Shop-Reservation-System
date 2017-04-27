import java.util.*;
import java.io.*;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    /**
     * Empty Constructor for file input
     */
    public Customer() {}
    
    /**
     * Manual entry constructor
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        customerID =         "unknown";
        this.surname =       surname;
        this.firstName =     firstName;
        this.otherInitials = otherInitials;
        this.title =         title;
    }
    
    /**
     * 
     */
    public void printDetails()
    {
        System.out.println("");
        System.out.printf("%-25s: %s\n", "Customer ID", customerID);
        System.out.printf("%-25s: %s\n", "Surname", surname);
        System.out.printf("%-25s: %s\n", "First Name", firstName);
        System.out.printf("%-25s: %s\n", "Other Initials", otherInitials);
        System.out.printf("%-25s: %s\n", "Title", title);
    }
    
    public void setIdIfUnknown(String newID)
    {
        if (customerID.equals("unknown"))
        {
            customerID = newID;
        }
    }
    
    public void readData(Scanner fieldScanner)
    {
        customerID    = fieldScanner.next().trim();
        surname       = fieldScanner.next().trim();
        firstName     = fieldScanner.next().trim();
        otherInitials = fieldScanner.next().trim();
        title         = fieldScanner.next().trim();
    }
    
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title); 
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getOtherInitials()
    {
        return otherInitials;
    }
    
    public String getTitle()
    {
        return title;
    }
}
