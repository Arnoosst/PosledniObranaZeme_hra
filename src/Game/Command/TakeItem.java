package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.World;

import java.util.ArrayList;
import java.util.List;

public class TakeItem extends Command{
    private World world;
    private Inventory inventory;

    public TakeItem(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < world.getWeapons().size(); i++) {
            if (World.getCurrentLocation() == world.getWeapons().get(i).getItemID()) {
                inventory.addItem(world.getWeapons().get(i));
                result.append("🔫 Našel jsi zbraň: ").append(world.getWeapons().get(i).getItemName()).append("!\n");
                world.getWeapons().remove(i);
            }
        }

        for (int i = 0; i < world.getMedkits().size(); i++) {
            if (World.getCurrentLocation() == world.getMedkits().get(i).getItemID()) {
                inventory.addItem(world.getMedkits().get(i));
                result.append("🩹 Vzal jsi si medkit!\n");
                world.getMedkits().remove(i);
            }
        }

        return result.isEmpty() ? "🔍 Nic tu není!" : result.toString().trim();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
