package Game.Items;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Item> inventory;
    private int coins;

    public static boolean addItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.add(item);
            return true;
        }
    }

    public static boolean removeItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.remove(item);
            return true;
        }
    }

    public static ArrayList<Item> getInventory() {
        return inventory;
    }


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
