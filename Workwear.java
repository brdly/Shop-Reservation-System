import java.util.*;

/**
 * Subclass for the Accessory class.
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class Workwear extends Accessory
{
    // instance variables
    private String manufacturingStandard;
    private String colour;
    private String size;

    /**
     * Constructor for the Perishable class
     *
     * @param toolName
     * @param itemCode
     * @param position
     * @param cost
     * @param manufacturingStandard
     * @param colour
     * @param size
     */
    public Workwear(String itemName, String itemCode, String position, int cost, String manufacturingStandard, String colour, String size)
    {
        super(itemName, itemCode, position, cost);
        this.manufacturingStandard = manufacturingStandard;
        this.colour                = colour;
        this.size                  = size;
    }
    
    public Workwear() {}

    /**
     * Prints details of this tool.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Manufacturing Standard: " + manufacturingStandard);
        System.out.println("Colour: " + colour);
        System.out.println("Size: " + size);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        manufacturingStandard = fieldScanner.next();
        colour                = fieldScanner.next();
        size                  = fieldScanner.next();
        
        super.extractData(fieldScanner);
    }

    /**
     * Getters and Setters below
     */

    public String getManufacturingStandard()
    {
        return manufacturingStandard;
    }

    public String getColour()
    {
        return colour;
    }
    
    public String getSize()
    {
        return size;
    }

    public void setManufacturingStandard(String manufacturingStandard)
    {
        this.manufacturingStandard = manufacturingStandard;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }
    
    public void setSize(String size)
    {
        this.size = size;
    }
}
