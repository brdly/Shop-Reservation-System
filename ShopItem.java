import java.util.*;

/**
 * Superclass for the Tool and Accessory classes
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public abstract class ShopItem
{
    // instance variables
    private String itemName;
    private String itemCode;
    private int cost;

    /**
     * Constructor for the ShopItem class
     *
     * @param itemName
     * @param itemCode
     * @param cost
     */
    public ShopItem(String itemName, String itemCode, int cost)
    {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.cost     = cost;
    }
    
    public ShopItem() {}

    /**
     * Prints the default data that is shared between each shop item.
     */    
    public void printDetails()
    {
        System.out.println("Item Name: " + itemName);
        System.out.println("");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Cost: £" + (float) cost / 100);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        itemName = fieldScanner.next();
        itemCode = fieldScanner.next();
        cost     = fieldScanner.nextInt();
    }

    /**
     * Getters and Setters below
     */

    public String getItemName()
    {
        return itemName;
    }

    public String getItemCode()
    {
        return itemCode;
    }

    public int getCost()
    {
        return cost;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }
}

