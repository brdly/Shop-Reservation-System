import java.util.*;
import java.awt.*;

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
        String filename = fileDialog.getFile();

        System.out.println(filename);
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

    public void setToolsList(ArrayList toolsList)
    {
        this.toolsList = toolsList;
    }
}
