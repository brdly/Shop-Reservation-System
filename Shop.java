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
    //private List<ShopItem> shopItemMap;
    //private List<Customer> customerMap;
    private HashMap<String, ShopItem> shopItemMap;
    private HashMap<String, Customer> customerMap;
    private HashMap<String, ShopItemReservation> itemReservationMap;
    private Random randomGenerator;

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        shopItemMap        = new HashMap<String, ShopItem>();
        customerMap        = new HashMap<String, Customer>();
        itemReservationMap = new HashMap<String, ShopItemReservation>();
        randomGenerator    = new Random();
    }

    public void storeCustomer(Customer customer)
    {
        customerMap.put(customer.getCustomerID(), customer);
    }
    
    public void storeItemReservation(ShopItemReservation shopItemReservation)
    {
        itemReservationMap.put(shopItemReservation.getReservationNo(), shopItemReservation);
    }

    public void printAllCustomers()
    {
        if (customerMap.isEmpty())
        {
            System.out.println("There are no customers to show");
        }
        else
        {
            for (Customer customer:customerMap.values())
            {
                customer.printDetails();
            }
        }
    }

    public void readCustomerData()
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
            while (scanner.hasNext())
            {
                String nextLine = scanner.nextLine().trim();
                                    
                if (checkIfEmptyOrComment(nextLine))
                {
                    //
                }
                else
                {
                    Customer customer = new Customer();
                                           
                    Scanner fieldScanner = new Scanner(nextLine);
                       
                    fieldScanner.useDelimiter(",");
                        
                    customer.readData(fieldScanner);
                    customer.setIdIfUnknown(generateCustomerID("AB-", 6));
                    customerMap.put(customer.getCustomerID(), customer);
                        
                    fieldScanner.close();
                }
            }
            scanner.close();
        }
    }
    
    public void readItemReservationData()
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
            while (scanner.hasNext())
            {
                String nextLine = scanner.nextLine().trim();
                                    
                if (checkIfEmptyOrComment(nextLine))
                {
                    //
                }
                else
                {
                    ShopItemReservation shopItemReservation = new ShopItemReservation();
                                           
                    Scanner fieldScanner = new Scanner(nextLine);
                       
                    fieldScanner.useDelimiter(",");
                        
                    shopItemReservation.readData(fieldScanner);
                    itemReservationMap.put(shopItemReservation.getReservationNo(), shopItemReservation);
                        
                    fieldScanner.close();
                }
            }
            scanner.close();
        }
    }
    
    public void writeCustomerData(String fileName) throws FileNotFoundException
    {
        PrintWriter pWriter = new PrintWriter(fileName);
        
        if (!customerMap.isEmpty())
        {
            for (Customer customer:customerMap.values())
            {
                customer.writeData(pWriter);
            }
            
            //pWriter.println();
            pWriter.close();
        }
        else
        {
            System.out.println("There is no data to write");
        }
    }
    
    public void writeItemReservationData(String fileName)
    {
        PrintWriter pWriter = null;
        
        try 
        {
            pWriter = new PrintWriter(fileName);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File does not exist");
        }
        
        if (!itemReservationMap.isEmpty())
        {
            for (ShopItemReservation shopItemReservation:itemReservationMap.values())
            {
                shopItemReservation.writeData(pWriter);
            }
            
            //pWriter.println();
            pWriter.close();
        }
        else
        {
            System.out.println("There is no data to write");
        }
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
                        shopItemMap.put(newItem.getItemCode(), newItem);
                            
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
    
    public ShopItemReservation getItemReservation(String reservationNo)
    {
        return itemReservationMap.get(reservationNo);
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
        if (shopItemMap.isEmpty())
        {
            System.out.println("There are no tools to show");
        }
        else
        {
            for (ShopItem shopItem:shopItemMap.values())
            {
                shopItem.printDetails();
            }
        }
    }
    
    /**
     * Method loops through each reservation in the hashmap and calls that reservation's printDetails method.
     */    
    public void printItemReservationsDetails()
    {
        if (itemReservationMap.isEmpty())
        {
            System.out.println("There are no reservations to show");
        }
        else
        {
            for (ShopItemReservation shopItemReservation:itemReservationMap.values())
            {
                shopItemReservation.printDetails();
            }
        }
    }
    
    private String generateCustomerID(String prefix, int length)
    {
        String id = prefix + (randomGenerator.nextInt(9) + 1);
        for (int i = 1; i < length; i++)
        {
            id = id + randomGenerator.nextInt(10);
        }
        
        for(Customer customer: customerMap.values())
        {
            if (customer.getCustomerID().equals(id))
            {
                id = generateCustomerID(prefix, length);
                return id;
            }
        }
        return id;
    }
    
    private String generateReservationNo()
    {
        Scanner scanner = new Scanner("");
        int lastId      = 0;
        
        try
        {
            File file = new File("reservationNo.txt");
            scanner   = new Scanner(file);
            lastId    = scanner.nextInt();
            
            scanner.close();
            
            PrintWriter pWriter = new PrintWriter("reservationNo.txt");
            pWriter.println(lastId+1);
            pWriter.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error 03: No reservation file, generating file.");
            try
            {
                PrintWriter pWriter = new PrintWriter("reservationNo.txt");
                pWriter.println(1);
                pWriter.close();
            }
            catch(FileNotFoundException f)
            {
                System.out.println("Error 04: Generating reservation file failed.");
            }
        }        
        String id = Integer.toString(lastId+1);
        
        while (id.length() < 6)
        {
            id = "0" + id;
        }
        
        return id;
    }
    
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays)
    {
        String reservationNo = generateReservationNo();
        
        if (!customerMap.containsKey(customerID))
        {
            return false;
        }
        else if (!shopItemMap.containsKey(itemID))
        {
            return false;
        }
        else if (!DateUtil.isValidDateString(startDate))
        {
            return false;
        }
        else if (noOfDays < 0)
        {
            return false;
        }
        else
        {
            itemReservationMap.put(reservationNo, new ShopItemReservation(reservationNo, itemID, customerID, startDate, noOfDays));
        
            return true;
        }
    }

    /**
     * Getters and Setters below
     */
    public HashMap getShopItemList()
    {
        return shopItemMap;
    }

    public void setShopItemList(HashMap<String, ShopItem> shopItemMap)
    {
        this.shopItemMap = shopItemMap;
    }
    
    public ShopItem getItem(String id)
    {
        return shopItemMap.get(id);
    }
    
    public Customer getCustomer(String id)
    {
        return customerMap.get(id);
    }
}
