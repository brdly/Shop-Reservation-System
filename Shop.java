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
    private ArrayList<Tool> toolsList;

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        toolsList = new ArrayList<Tool>();
    }

    public void readElectricToolData()
    {
        FileDialog fileDialog = new FileDialog(new Frame(), "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String filename = fileDialog.getDirectory() + fileDialog.getFile();        
        if (filename == null) {
            System.out.println("Error 01: File not found, please try again with a valid file");
        }
        else
        {
            try
            {
                File file = new File(filename);
                Scanner scanner = new Scanner(file);
        
                while (scanner.hasNext())
                {
                    String nextLine = scanner.nextLine().trim();
                                        
                    if (!checkIfEmptyOrComment(nextLine))
                    {
                        Scanner fieldScanner = new Scanner(nextLine);
                        fieldScanner.useDelimiter(",");
                        boolean rechargeable = fieldScanner.nextBoolean();
                        String power = fieldScanner.next();
                        String toolName = fieldScanner.next();
                        String itemCode = fieldScanner.next();
                        int timesBorrowed = fieldScanner.nextInt();
                        boolean onLoan = fieldScanner.nextBoolean();
                        int cost = fieldScanner.nextInt();
                        int weight = fieldScanner.nextInt();
                        
                        toolsList.add(new ElectricTool(toolName, itemCode, timesBorrowed, onLoan, cost,weight, rechargeable, power));
                    }
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Error 02: File not found, please try again with a valid file");
            }
        }
    }
    
    private boolean checkIfEmptyOrComment(String lineToCheck)
    {
        if (lineToCheck.equals(""))
        {
            return true;
        }
        else if (lineToCheck.substring(0,2).equals("//"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printAllDetails()
    {
        for (Tool tool:toolsList)
        {
            tool.printDetails();
        }
    }

    /**
     * Getters and Setters below
     */

    public ArrayList getToolsList()
    {
        return toolsList;
    }

    public void setToolsList(ArrayList<Tool> toolsList)
    {
        this.toolsList = toolsList;
    }
}
