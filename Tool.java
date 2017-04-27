import java.util.*;

/**
 * Superclass for the ElectricTool and HandTool classes
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public abstract class Tool extends ShopItem
{
    // instance variables
    private int timesBorrowed;
    private boolean onLoan;
    private int weight;

    /**
     * Constructor for the Tool class
     *
     * @param timesBorrowed
     * @param onLoan
     * @param weight
     */
    public Tool(String itemName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight)
    {
        super(itemName, itemCode, cost);
        this.timesBorrowed = timesBorrowed;
        this.onLoan        = onLoan;
        this.weight        = weight;
    }
    
    public Tool() {}

    /**
     * Prints the default data that is shared between each tool type.
     */    
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s: %s\n", "Times Borrowed", timesBorrowed);
        System.out.printf("%-25s: %s\n", "On Loan", onLoan);
        System.out.printf("%-25s: %sg\n", "Weight", weight);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        timesBorrowed = fieldScanner.nextInt();
        onLoan        = fieldScanner.nextBoolean();
        super.extractData(fieldScanner);
        weight        = fieldScanner.nextInt();
    }

    /**
     * Getters and Setters below
     */

    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }

    public boolean isOnLoan()
    {
        return onLoan;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed = timesBorrowed;
    }

    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
