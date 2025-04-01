package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.World;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a command to take items from the world and add them to the player's inventory.
 *
 * @author Vojtěch Malínek
 */
public class TakeItem extends Command{
    private World world;
    private Inventory inventory;

    public TakeItem(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
    }



    /**
     * Executes the command to take items from the current location in the world.
     * The method checks for weapons and medkits in the world at the current location and adds them to the inventory.
     * If any items are found, a message is returned saying what the player found and took.
     * If no items are found, a message saying that nothing is available is returned.
     *
     * @author Vojtěch Malínek
     * @return a message containing the result of the operation
     */
    @Override
    public String execute() {
        String result = "";

        for (int i = 0; i < world.getWeapons().size(); i++) {
            if (World.getCurrentLocation() == world.getWeapons().get(i).getItemID()) {
                inventory.addItem(world.getWeapons().get(i));
                result = result + "Našel jsi zbraň: " + world.getWeapons().get(i).getItemName() + "!\n";
                world.getWeapons().remove(i);
            }
        }

        for (int i = 0; i < world.getMedkits().size(); i++) {
            if (World.getCurrentLocation() == world.getMedkits().get(i).getItemID()) {
                inventory.addItem(world.getMedkits().get(i));
                result = result + "Vzal jsi si medkit!\n";
                world.getMedkits().remove(i);
            }
        }

        if(result.isEmpty()){
            return "🔍 Nic tu není!";
        }else {
            return result;
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
