import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class itemFields {

    //LOCAL VARIABLES
    public ArrayList<String> itemName;
    public ArrayList<Double> itemPrice;
    public ArrayList<Integer> itemInventory;
    public ArrayList<String> itemTransaction;

    //CONSTRUCTOR
    public itemFields(){

        this.itemName = new ArrayList<>();
        itemName.add("Granola Bars");
        itemName.add("Chips Baked");
        itemName.add("Mini Pretzels");
        itemName.add("Peanut");
        itemName.add("Twix");
        itemName.add("Chocolate Cups");
        itemName.add("Mix of kandy");
        itemName.add("Doritos");
        itemName.add("Oreos");
        itemName.add("Cookies");
        itemName.add("Corn Nuts");
        itemName.add("Water");
        itemName.add("Coke");
        itemName.add("Sprite");
        itemName.add("Gatorade");
        itemName.add("Pepsi");

        this.itemPrice = new ArrayList<>();
        itemPrice.add(1.25);
        itemPrice.add(1.25);
        itemPrice.add(1.45);
        itemPrice.add(2.00);
        itemPrice.add(2.00);
        itemPrice.add(1.80);
        itemPrice.add(1.85);
        itemPrice.add(1.85);
        itemPrice.add(1.70);
        itemPrice.add(1.15);
        itemPrice.add(1.45);
        itemPrice.add(1.00);
        itemPrice.add(1.90);
        itemPrice.add(1.90);
        itemPrice.add(1.80);
        itemPrice.add(1.90);

        this.itemInventory = new ArrayList<>();
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);
        itemInventory.add(10);

        this.itemTransaction = new ArrayList<>();
    }

    //METHODS
    public ArrayList<String> getItemName() {
        return itemName;
    }
    public ArrayList<Double> getItemPrice() {
        return itemPrice;
    }
    public ArrayList<Integer> getItemInventory() {
        return itemInventory;
    }
    public ArrayList<String> getItemTransaction() {
        return itemTransaction;
    }
    public void setTransaction(String itemName, Double itemPrice) {
        String transaction;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
        Date date = new Date();

        String dateString = dateFormat.format(date);
        transaction = dateString + "  " + itemName + "  $" + itemPrice;
        itemTransaction.add(transaction);
    }
}//end itemFields
