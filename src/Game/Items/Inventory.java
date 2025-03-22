package Game.Items;

import java.util.ArrayList;

public class Inventory {

    private  ArrayList<Item> inventory = new ArrayList<>();
    private int coins;

    public  boolean addItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.add(item);
            return true;
        }
    }

    public  boolean removeItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.remove(item);
            return true;
        }
    }

    public  ArrayList<Item> getInventory() {
        return inventory;
    }


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
