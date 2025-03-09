import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    public boolean addItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.add(item);
            return true;
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
