package Game.Command;

import Game.Items.Inventory;
import Game.World;

public class UseMedkit extends Command{

    World world = new World();

    public UseMedkit(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        for (int i = 0; i < Inventory.getInventory().size(); i++){
            if(Inventory.getInventory().get(i).getItemName().equals("Medkit")){
                world.setHealth(world.getHealth()+Inventory.getInventory().get(i);
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
