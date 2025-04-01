package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.Player;
import Game.World;

/**
 * Represents a command to use a medkit from the inventory.
 *
 * @author Vojtěch Malínek
 */
public class UseMedkit extends Command {

    private Inventory inventory;
    private Player player;

    public UseMedkit(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }


    /**
     * Executes the command to use a medkit from the inventory.
     * If a medkit is found, it restores health to the player and removes the medkit from the inventory.
     * If no medkit is found, a message is returned saying that the player needs to find or buy a new medkit.
     *
     * @author Vojtěch Malínek
     * @return a message containing the result of using the medkit, either health restored or no medkit found.
     */
    @Override
    public String execute() {
        for (int i = 0; i < inventory.getInventory().size(); i++) {
            Item item = inventory.getInventory().get(i);

            if (item.getItemName().equals("Medkit")) {
                Medkit medkit = (Medkit) item;
                player.setHealth(player.getHealth() + medkit.getHealthIncrease());
                inventory.getInventory().remove(i);
                return "Použil jsi medkit! Zdraví obnoveno o " + medkit.getHealthIncrease() + " HP.";
            }
        }
        return "Žádný medkit v inventáři! Najdi nebo kup nový.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
