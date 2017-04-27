import java.util.*;

/**
 * Subclass of the Tool class.
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class HandTool extends Tool
{
    // instance variables
    private boolean sharpenable;

    /**
     * Constructor for the HandTool class
     *
     * @param toolName
     * @param itemCode
     * @param timesBorrowed
     * @param onLoan
     * @param cost
     * @param weight
     * @param sharpenable
     */
    public HandTool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean sharpenable)
    {
        super(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
        this.sharpenable = sharpenable;
    }
    
    public HandTool() {}

    /**
     * Prints details of this tool
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s: %s\n", "Sharpenable", sharpenable);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        sharpenable = fieldScanner.nextBoolean();
        
        super.extractData(fieldScanner);
    }

    /**
     * Getter and setter below
     */

    public boolean isSharpenable()
    {
        return sharpenable;
    }

    public void setSharpenable(boolean sharpenable)
    {
        this.sharpenable = sharpenable;
    }
}
