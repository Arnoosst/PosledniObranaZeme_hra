package Game.Items;

import java.util.ArrayList;

/**
 * Represents an inventory system that can have Item objects.
 * The inventory has a limit of 5 items and tracks coins and keys.
 *
 * @author Vojtěch Malínek
 */
public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<GemStone> gemStones = new ArrayList<>();
    private int coins;
    private int keys;


    public Inventory() {
        this.inventory = new ArrayList<>();
        this.gemStones = new ArrayList<>();
        this.keys = 1;
        this.coins = 10000;
    }



    /**
     * Adds an Item to the inventory.
     * If the item is null or the inventory is full, the item will not be added.
     *
     * @author Vojtěch Malínek
     * @param item the item to be added to the inventory.
     * @return true if the item was successfully added, false otherwise.
     */
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


    /**
     * Removes an Item from the inventory.
     * If the item is null, nothing will be removed.
     *
     * @param item the item to be removed from the inventory.
     * @return code true if the item was successfully removed, false otherwise.
     */
    public  boolean removeItem(Item item){
        if(item == null){
            return false;
        }else {
            inventory.remove(item);
            return true;
        }
    }


    /**
     * Locates an Item by its unique ID in the inventory.
     *
     * @param id the ID of the item to be located.
     * @return the item with the specified ID, or null if no item with the given ID is found.
     */
    public Item locateItemFromId(int id){
        for (Item item : inventory) {
            if (item.getItemID() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean addGemStone(GemStone gemStone) {
        if (gemStone == null) {
            return false;
        }
        gemStones.add(gemStone);
        return true;
    }




    /**
     * Returns a string representation of the inventory contents.
     * The list includes each item’s name, ID, and price.
     *
     * @return a formatted string representing the inventory.
     */
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

    public ArrayList<GemStone> getGemStones() {
        return gemStones;
    }

    public void setGemStones(ArrayList<GemStone> gemStones) {
        this.gemStones = gemStones;
    }
}
