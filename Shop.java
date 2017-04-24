import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * Shop to store tools
 * 
 * @author George Broadley
 * @version 1.0.0
 */
public class Shop
{
    // instance variables
    private ArrayList<ShopItem> shopItemList;

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        shopItemList = new ArrayList<ShopItem>();
    }

    /**
     * Reader for the shop data. Takes file input from dialog and puts that data into the tool arraylist.
     */
    public void readData()
    {
        FileDialog fileDialog = new FileDialog(new Frame(), "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String filename = fileDialog.getDirectory() + fileDialog.getFile();
        if (filename == null)
        {
            System.out.println("Error 01: File not found, please try again with a valid file");
        }
        else
        {
            Scanner scanner = new Scanner("");
            
            try
            {
                File file = new File(filename);
                scanner   = new Scanner(file);
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Error 02: File not found, please try again with a valid file");
            }
            String typeOfData = "[Electric";
            while (scanner.hasNext())
            {
                String nextLine = scanner.nextLine().trim();
                                    
                if (checkIfEmptyOrComment(nextLine))
                {
                    //
                }
                else if (nextLine.startsWith("["))
                {
                    typeOfData = nextLine;
                }
                else
                {
                    ShopItem newItem = getItemType(typeOfData);
                                           
                    if (newItem != null)
                    {
                        Scanner fieldScanner = new Scanner(nextLine);
                       
                        fieldScanner.useDelimiter(",");
                        
                        newItem.extractData(fieldScanner);
                        shopItemList.add(newItem);
                            
                        fieldScanner.close();
                    }
                    else
                    {
                        System.out.println("Error 03: Type could not be recognised.");
                    }
                }
            }
            scanner.close();
        }
    }
    
    /**
     * Method returns true if the line inputted is either a comment (line starts with "//") or empty, else the method returns false.
     */
    private boolean checkIfEmptyOrComment(String lineToCheck)
    {
        if (lineToCheck.equals(""))
        {
            return true;
        }
        else if (lineToCheck.startsWith("//"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * method returns the type of item or null if it doesn't match the item
     */
    private ShopItem getItemType(String typeOfData)
    {
        if (typeOfData.toLowerCase().startsWith("[electric"))
        {
            return new ElectricTool();
        }
        else if (typeOfData.toLowerCase().startsWith("[hand"))
        {
            return new HandTool();
        }
        else if (typeOfData.toLowerCase().startsWith("[perishable"))
        {
            return new Perishable();
        }
        else if (typeOfData.toLowerCase().startsWith("[workwear"))
        {
            return new Workwear();
        }
        else
        {
            return null;
        }
    }

    /**
     * Method loops through each tool in the arraylist and calls that tool's printDetails method.
     */    
    public void printAllDetails()
    {
        if (shopItemList.isEmpty())
        {
            System.out.println("There are no tools to show");
        }
        else
        {
            for (ShopItem shopItem:shopItemList)
            {
                shopItem.printDetails();
            }
        }
    }

    /**
     * Getters and Setters below
     */
    public ArrayList getShopItemList()
    {
        return shopItemList;
    }

    public void setShopItemList(ArrayList<ShopItem> shopItemList)
    {
        this.shopItemList = shopItemList;
    }
}
