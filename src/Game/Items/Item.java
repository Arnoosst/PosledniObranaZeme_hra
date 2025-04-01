package Game.Items;


/**
 * Represents item with a name, id and price.
 * This class is a base for other types of items.
 *
 * @author Vojtěch Malínek
 */
public class Item {
    private String itemName;
    private int itemID;
    private int itemPrice;


    public Item(String itemName, int itemID, int itemPrice) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
