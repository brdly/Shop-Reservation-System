
/**
 * Subclass for the Tool class.
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class ElectricTool extends Tool
{
    // instance variables
    private boolean rechargable;
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
     * @param rechargable
     * @param power
     */
    public ElectricTool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean rechargable, String power)
    {
        super(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
        this.rechargable = rechargable;
        this.power = power;
    }

    /**
     * Prints details of this tool.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Rechargable: " + rechargable);
        System.out.println("Power: " + power);
    }

    /**
     * Getters and Setters below
     */

    public boolean isRechargable()
    {
        return rechargable;
    }

    public String getPower()
    {
        return power;
    }

    public void setRechargable(boolean rechargable)
    {
        this.rechargable = rechargable;
    }

    public void setPower(String power)
    {
        this.power = power;
    }
}
