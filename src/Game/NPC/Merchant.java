package Game.NPC;

import Game.Items.Item;

import java.util.ArrayList;

public class Merchant extends Item {

    private ArrayList<Item> items;

    public Merchant(String itemName, int itemID, int planetItemID, ArrayList<Item> items) {
        super(itemName, itemID, planetItemID);
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
