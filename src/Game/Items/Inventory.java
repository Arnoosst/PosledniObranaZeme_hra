package Game.Items;

import java.util.ArrayList;

public class Inventory {

    private  ArrayList<Item> inventory = new ArrayList<>();
    private int coins;
    private int keys;


    public Inventory() {
        this.inventory = new ArrayList<>();
        this.coins = 500;
    }

    public boolean addItem(Item item) {
        if (item == null) {
            return false;
        }
        if (inventory.size() >= 5) {
            System.out.println("Inventář je plný! Nemůžeš přidat další předmět.");
            return false;
        }
        inventory.add(item);
        return true;
    }

    public  boolean removeItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.remove(item);
            return true;
        }
    }

    public Item locateItemFromId(int id){
        for (Item item : inventory) {
            if (item.getItemID() == id) {
                return item;
            }
        }
        return null;
    }




    public String printInventory() {
        String x;
        x = "🎒 Inventář: \n";
        for (Item item : inventory) {
            x += "Název: " + item.getItemName() + "\n" ;
            x += "ID: " + item.getItemID() + "\n";
            x += "Cena: " + item.getItemPrice()+ "\n";
            x+= "------------------------- \n";
        }
        return x;
    }


    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public  ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
