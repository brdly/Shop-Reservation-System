
/**
 * Superclass for the ElectricTool and HandTool classes
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public abstract class Tool
{
    // instance variables
    private String toolName;
    private String itemCode;
    private int timesBorrowed;
    private boolean onLoan;
    private int cost;
    private int weight;

    /**
     * Constructor for the Tool class
     *
     * @param toolName
     * @param itemCode
     * @param timesBorrowed
     * @param onLoan
     * @param cost
     * @param weight
     */
    public Tool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight)
    {
        this.toolName      = toolName;
        this.itemCode      = itemCode;
        this.timesBorrowed = timesBorrowed;
        this.onLoan        = onLoan;
        this.cost          = cost;
        this.weight        = weight;
    }

    /**
     * Prints the default data that is shared between each tool type.
     */    
    public void printDetails()
    {
        System.out.println("Tool Name: " + toolName);
        System.out.println("");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Times Borrowed: " + timesBorrowed);
        System.out.println("On Loan: " + onLoan);
        System.out.println("Cost: £" + (float) cost / 100);
        System.out.println("Weight: " + weight + "g");
    }

    /**
     * Getters and Setters below
     */

    public String getToolName()
    {
        return toolName;
    }

    public String getItemCode()
    {
        return itemCode;
    }

    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }

    public boolean isOnLoan()
    {
        return onLoan;
    }

    public int getCost()
    {
        return cost;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setToolName(String toolName)
    {
        this.toolName = toolName;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed = timesBorrowed;
    }

    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
