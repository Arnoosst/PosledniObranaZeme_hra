package NPC;

import Items.Item;

import java.util.ArrayList;

public class Merchant extends Item {

    private ArrayList<Item> items;

    public Merchant(String itemName, ArrayList<Item> items) {
        super(itemName);
        this.items = items;
    }

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }
    public boolean removeItem(Item item) {
        items.remove(item);
        return true;
    }



}
