package Game.Items;

public class Item {
    private String itemName;
    private int itemID;


    public Item(int itemID) {

    }

    public Item(String itemName, int itemID) {
        this.itemName = itemName;
        this.itemID = itemID;
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
}
