package Game.Command;

import Game.Items.Inventory;

public class ShowInv extends Command {


    private Inventory inv;

    public ShowInv(Inventory inv) {
        this.inv = inv;
    }

    @Override
    public String execute() {

        return "Vas inventar: " + inv.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
