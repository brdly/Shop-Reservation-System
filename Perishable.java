import java.util.*;

/**
 * Subclass for the Accessory class.
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class Perishable extends Accessory
{
    // instance variables
    private boolean isIrritant;
    private String useByDate;
    private int volume;

    /**
     * Constructor for the Perishable class
     *
     * @param toolName
     * @param itemCode
     * @param position
     * @param cost
     * @param isIrritant
     * @param useByDate
     * @param volume
     */
    public Perishable(String itemName, String itemCode, String position, int cost, boolean isIrritant, String useByDate, int volume)
    {
        super(itemName, itemCode, position, cost);
        this.isIrritant = isIrritant;
        this.useByDate  = useByDate;
        this.volume     = volume;
    }
    
    public Perishable() {}

    /**
     * Prints details of this tool.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Is Irritant: " + isIrritant);
        System.out.println("Use By Date: " + useByDate);
        System.out.println("Volume: " + volume);
    }
    
    public void extractData(Scanner fieldScanner)
    {
        isIrritant = fieldScanner.nextBoolean();
        useByDate  = fieldScanner.next();
        volume     = fieldScanner.nextInt();
        
        super.extractData(fieldScanner);
    }

    /**
     * Getters and Setters below
     */

    public boolean isIrritant()
    {
        return isIrritant;
    }

    public String getUseByDate()
    {
        return useByDate;
    }
    
    public int getVolume()
    {
        return volume;
    }

    public void setIrritant(boolean isIrritant)
    {
        this.isIrritant = isIrritant;
    }

    public void setUseByDate(String useByDate)
    {
        this.useByDate = useByDate;
    }
}
