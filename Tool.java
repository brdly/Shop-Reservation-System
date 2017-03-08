
/**
 * Superclass for the ElectricTool and HandTool classes
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class Tool
{
    // instance variables
    private String toolName;
    private String itemCode;
    private int timesBorrowed;
    private boolean onLoan;
    private int cost;
    private int weight;

    /**
     * Constructor for objects of class Tool
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
}
