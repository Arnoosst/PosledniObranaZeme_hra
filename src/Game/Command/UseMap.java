package Game.Command;

import Game.Items.Inventory;
import Game.World;


/**
 * Command that allows the player to use a map from their inventory.
 * Displays information about all maps currently in inventory.
 * Extends the Command.
 *
 * @author Vojtěch Malínek
 */
public class UseMap extends Command {

    private Inventory inventory;


    public UseMap(Inventory inventory) {
        this.inventory = inventory;
    }


    /**
     * Executes the command to display information about all crate maps in the inventory.
     *
     * @author Vojtěch Malínek
     * @return a formatted string with info about each map, or a message if no maps are available.
     */
    @Override
    public String execute() {
        if (inventory.getMapForCrates().isEmpty()) {
            return "Žádnou mapu nemáš.";
        }

        String temp = "";
        for (int i = 0; i < inventory.getMapForCrates().size(); i++) {
            temp += inventory.getMapForCrates().get(i).getInfoAboutMap() + "\n" + "\n";
        }

        return temp;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
