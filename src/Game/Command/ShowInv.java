package Game.Command;

import Game.Items.Inventory;

public class ShowInv extends Command {


    public ShowInv() {
    }

    @Override
    public String execute() {

        return "Vas inventar: " + Inventory.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
