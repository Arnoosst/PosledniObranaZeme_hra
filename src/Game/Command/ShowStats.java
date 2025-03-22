package Game.Command;

import Game.Items.Inventory;
import Game.Player;

public class ShowStats extends Command {


    private Inventory inv;
    private Player player;

    public ShowStats(Inventory inv, Player player) {
        this.inv = inv;
        this.player = player;
    }

    @Override
    public String execute() {

        return "Vase hp: " + player.getHealth() + "Vas damage: " + player.getDamage() + "Vas inventar: " + inv.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
