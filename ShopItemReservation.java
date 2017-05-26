import java.util.Date;
import java.util.*;
import java.io.*;

/**
 * Write a description of class ShopItemReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShopItemReservation
{
    // instance variables
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;

    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {
        
        
        this.reservationNo = reservationNo;
        this.itemID        = itemID;
        this.customerID    = customerID;
        this.startDate     = DateUtil.convertStringToDate(startDate);
        this.noOfDays      = noOfDays;
    }
    
    public ShopItemReservation() {}
       
    public void printDetails()
    {
        System.out.println("");
        System.out.printf("%-25s: %s\n", "Reservation No", reservationNo);
        System.out.printf("%-25s: %s\n", "Item ID", itemID);
        System.out.printf("%-25s: %s\n", "Customer ID", customerID);
        System.out.printf("%-25s: %s\n", "Start Date", DateUtil.convertDateToShortString(startDate));
        System.out.printf("%-25s: %s\n", "Reservation Length", noOfDays + " days");
    }
    
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(reservationNo + ", " + itemID + ", " + customerID + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays); 
    }
    
    public void readData(Scanner fieldScanner)
    {
        reservationNo = fieldScanner.next().trim();
        itemID        = fieldScanner.next().trim();
        customerID    = fieldScanner.next().trim();
        startDate     = DateUtil.convertStringToDate(fieldScanner.next().trim());
        noOfDays      = fieldScanner.nextInt();
    }
    
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    public String getItemID()
    {
        return itemID;
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public int getNoOfDays()
    {
        return noOfDays;
    }
}
