package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.Player;
import Game.World;

public class UseMedkit extends Command {

    public UseMedkit() {
    }

    @Override
    public String execute() {
        for (int i = 0; i < Inventory.getInventory().size(); i++) {
            Item item = Inventory.getInventory().get(i);

            if (item.getItemName().equals("Medkit")) {
                Medkit medkit = (Medkit) item;
                Player.setHealth(Player.getHealth() + medkit.getHealthIncrease());
                Inventory.getInventory().remove(i);
                return "Použil jsi Medkit! Zdraví zvýšeno o " + medkit.getHealthIncrease() + ".";
            }
        }
        return "Nemáš žádný Medkit!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
