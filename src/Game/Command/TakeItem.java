package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.World;

import java.util.ArrayList;
import java.util.List;

public class TakeItem extends Command{

    public TakeItem() {
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < World.getWeapons().size(); i++) {
            if (World.getCurrentLocation() == World.getWeapons().get(i).getItemID()) {
                Inventory.addItem(World.getWeapons().get(i));
                result.append("Vzal jsi zbraň: ").append(World.getWeapons().get(i).getItemName());
                World.getWeapons().remove(i);
            }
        }

        for (int i = 0; i < World.getMedkits().size(); i++) {
            if (World.getCurrentLocation() == World.getMedkits().get(i).getItemID()) {
                Inventory.addItem(World.getMedkits().get(i));
                result.append("Vzal jsi medkit.");
                World.getMedkits().remove(i);
            }
        }

        return result.isEmpty() ? "Nothing is here!" : result.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
