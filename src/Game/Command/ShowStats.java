package Game.Command;

import Game.Items.Inventory;
import Game.Player;


/**
 * Represents a command to show the player's stats, including health, damage, coins, inventory
 */
public class ShowStats extends Command {


    private Inventory inv;
    private Player player;

    public ShowStats(Inventory inv, Player player) {
        this.inv = inv;
        this.player = player;
    }


    /**
     * Executes the command to display the player's stats and inventory.
     * The player's health, damage (with any increases from items in the inventory), and coins are shown.
     * The player's inventory is also shown.
     *
     * @return a message containing the player's stats and the inventory.
     */
    public String execute() {
        System.out.println(inv.printInventory());

        return "❤️ Zdraví: " + player.getHealth() + "\n" +
                "⚔️ Poškození: " + (player.getDamage() + player.damageIncrease(inv)) + "\n" +
                "💰 Mince: " + inv.getCoins() + "\n";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
