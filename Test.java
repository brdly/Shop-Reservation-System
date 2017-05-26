import java.io.*;
import java.util.Date;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test() throws FileNotFoundException
    {
        Shop shop = new Shop("TestShop");
        System.out.println("Starting Testing");
        /**
         * Create a Customer with name Mr John T Roberts and print him.
         */
        System.out.println("----------------");
        Customer johnRoberts = new Customer("Roberts", "John", "T", "Mr");
        shop.storeCustomer(johnRoberts);
        shop.printAllCustomers();
        /**
         * Store all customers and print them.
         */
        System.out.println("----------------");
        shop.readCustomerData();
        shop.printAllCustomers();
        /**
         * Store the Customer Data in a new file then read it into a new shop object and print it
         */
        System.out.println("----------------");
        shop.writeCustomerData("new_customer_data.txt");
        Shop shop2 = new Shop("TestShop");
        shop2.readCustomerData();
        shop2.printAllCustomers();
        /**
         * Testing generating random IDs -- Will not work in future versions due to generateCustomerID being private
         */
        // System.out.println("----------------");
        // for(int i = 0; i < 88; i++)
        // {
            // String id = shop.generateCustomerID("AB-", 2);
            
            // Customer customer = new Customer(null,null,null,null);
            // customer.setIdIfUnknown(id);
            // shop.storeCustomer(customer);
            // System.out.println(id);
        // }
        /**
         * Testing generating date and using date
         */
        System.out.println("----------------");
        Date date1 = DateUtil.convertStringToDate("12-05-2017");
        Date date2 = DateUtil.convertStringToDate("23-05-2017");
        int daysBetween = DateUtil.daysBetween(date1, date2);
        System.out.println("Days between 12-05-2017 and 23-05-2017: " + daysBetween);
        /**
         * Testing creating, storing and deleting Reservations
         */
        System.out.println("----------------");
        System.out.println("Creating Reservations:");
        System.out.println("Customer ID  Item ID  Start Date  No of Days  Should Save?");
        System.out.println("AB-147441    RD4352   28-5-2017   6           Yes");
        System.out.println("AB-571499    RD3022   2-6-2017    6           Yes");
        System.out.println("AB-640928    RD4422   28-5-2017   6           No - Wrong Item ID");
        System.out.println("AB-233950    RD4352   3-6-2017    6           No - Item Already Reserved");
        shop2.makeItemReservation("AB-147441", "RD4352", "28-5-2017", 6);
        shop2.makeItemReservation("AB-571499", "RD3022", "2-6-2017", 6);
        shop2.makeItemReservation("AB-640928", "RD4422", "28-5-2017", 6);
        shop2.makeItemReservation("AB-233950", "RD4352", "3-6-2017", 6);
        shop2.printDiaryEntries("28-5-2017", "4-6-2017");
    }
}
