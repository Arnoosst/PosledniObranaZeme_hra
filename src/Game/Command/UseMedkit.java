package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.Player;
import Game.World;

public class UseMedkit extends Command {

    private Inventory inventory;
    private Player player;

    public UseMedkit(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }

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
