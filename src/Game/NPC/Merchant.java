package Game.NPC;


import Game.Items.Item;
import Game.Items.Medkit;
import Game.Items.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * Represents a merchant that sells and buys items.
 */
public class Merchant {

    private int coins;
    private int keyToSell;
    private ArrayList<Item> sortiment;

    /**
     * Creates a merchant with default coins and items to sell.
     */
    public Merchant() {
        this.coins = 400;
        this.keyToSell = 2;
        sortiment = new ArrayList<>();
        loadWeapons();
        loadMedKits();
    }

    /**
     * Finds an item in the merchant's inventory by its ID.
     *
     * @param id The ID of the item.
     * @return The item if found, otherwise null.
     */
    public Item locateItemFromId(int id){
        for(int i = 0; i < sortiment.size(); i++){
            if (id == sortiment.get(i).getItemID() ){
                return sortiment.get(i);
            }
        }
        return null;
    }




    /**
     * Allows the merchant to buy an item and add it to the inventory.
     *
     * @param item The item to be purchased.
     * @return True if the item was successfully bought, otherwise false.
     */
    public boolean buyItem(Item item) {
        if (item == null) {
            return false;

        }
        if (sortiment.contains(item)) {
            return false;
        }
        sortiment.add(item);
        return true;
    }


    /**
     * Sells an item from the merchant's inventory.
     *
     * @param id The ID of the item to sell.
     * @return The sold item if it exists, otherwise null.
     */
    public Item sellItem(int id) {
        Item item2;
        for (Item item : sortiment) {
            if (item.getItemID() == id) {
                item2 = item;
                sortiment.remove(item);
                return item2;
            }
        }
        return null;
    }



    /**
     * Loads medkits from a file and adds them to the merchant's inventory.
     */
    public  void loadMedKits() {
        try (BufferedReader br = new BufferedReader(new FileReader("medkitsMerchant.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int health = Integer.parseInt(parts[1]);
                String name = parts[2];
                int price = Integer.parseInt(parts[3]);
                sortiment.add(new Medkit(name, id, health, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Loads weapons from a file and adds them to the merchant's inventory.
     */
    public  void loadWeapons() {
        try (BufferedReader br = new BufferedReader(new FileReader("weaponsMerchant.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int damage = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                sortiment.add(new Weapon(name, id, damage, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    /**
     * Prints the merchant's inventory.
     *
     * @return A string representing the items available for sale.
     */
    public String printSortiment() {
        String x;
        x = "### Sortiment Merchanta ### \n";
        for (Item item : sortiment) {
            x += "Název: " + item.getItemName() + "\n" ;
            x += "ID: " + item.getItemID() + "\n";
            x += "Cena: " + item.getItemPrice()+ "\n";
            x+= "------------------------- \n";
        }
        return x;
    }


    public int getKeyToSell() {
        return keyToSell;
    }

    public void setKeyToSell(int keyToSell) {
        this.keyToSell = keyToSell;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Item> getSortiment() {
        return sortiment;
    }

    public void setSortiment(ArrayList<Item> sortiment) {
        this.sortiment = sortiment;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "sortiment=" + sortiment +
                '}';
    }
}
