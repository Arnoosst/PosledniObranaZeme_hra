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

    public String execute() {
        System.out.println(inv.printInventory());

        return "❤️ Zdraví: " + player.getHealth() + "\n" +
                "⚔️ Poškození: " + player.getDamage() + "\n";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
