import java.util.*;

/**
 * Subclass for the Tool class.
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class ElectricTool extends Tool
{
    // instance variables
    private boolean rechargeable;
    private String power;

    /**
     * Constructor for the ElectricTool class
     *
     * @param toolName
     * @param itemCode
     * @param timesBorrowed
     * @param onLoan
     * @param cost
     * @param weight
     * @param rechargeable
     * @param power
     */
    public ElectricTool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean rechargeable, String power)
    {
        super(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
        this.rechargeable = rechargeable;
        this.power        = power;
    }
    
    public ElectricTool() {}

    /**
     * Prints details of this tool.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Rechargeable: " + rechargeable);
        System.out.println("Power: " + power);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        rechargeable = fieldScanner.nextBoolean();
        power        = fieldScanner.next();
        
        super.extractData(fieldScanner);
    }

    /**
     * Getters and Setters below
     */

    public boolean isRechargeable()
    {
        return rechargeable;
    }

    public String getPower()
    {
        return power;
    }

    public void setRechargeable(boolean rechargeable)
    {
        this.rechargeable = rechargeable;
    }

    public void setPower(String power)
    {
        this.power = power;
    }
}
