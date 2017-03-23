import java.util.*;

/**
 * Superclass for the Perishable and Workwear classes
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public abstract class Accessory extends ShopItem
{
    // instance variables
    private String position;

    /**
     * Constructor for the Accessory class
     *
     * @param position
     */
    public Accessory(String itemName, String itemCode, String position, int cost)
    {
        super(itemName, itemCode, cost);
        this.position = position;
    }
    
    public Accessory() {}

    /**
     * Prints the default data that is shared between each tool type.
     */    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Position: " + position);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        position = fieldScanner.next();
        super.extractData(fieldScanner);
    }

    /**
     * Getters and Setters below
     */

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }
}
