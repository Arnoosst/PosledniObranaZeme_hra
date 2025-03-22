package Game.Items;

public class Item {
    private String itemName;
    private int itemID;
    private int itemPrice;


    public Item(int itemID) {

    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return itemID == item.itemID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(itemID);
    }
}
