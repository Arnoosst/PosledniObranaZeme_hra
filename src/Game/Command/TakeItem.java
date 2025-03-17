package Game.Command;

import Game.Items.Item;
import Game.World;

public class TakeItem extends Command{

    World world = new World();

    public TakeItem(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        return "Bylo pridano: " + world.getItemFromLocation();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
