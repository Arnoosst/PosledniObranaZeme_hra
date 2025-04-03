package Game.Command;

import Game.Items.Inventory;
import Game.World;

public class UnlockCrate extends Command{

    private World world;
    private Inventory inventory;

    public UnlockCrate(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
    }

    @Override
    public String execute() {

        for (int i = 0; i < world.getCrates().size(); i++) {
            if (World.getCurrentLocation() == world.getCrates().get(i).getPlanetID()) {
                if (world.getCrates().get(i).isFound()) {
                    if (inventory.getKeys() >= 1) {
                        inventory.setKeys(inventory.getKeys() - 1);
                        inventory.addGemStone(world.getCrates().get(i).getGemStone());
                        System.out.println("Podařilo se ti získat nový drahokam: " + world.getCrates().get(i).getGemStone().getItemName());
                        world.getCrates().remove(world.getCrates().get(i).getGemStone());
                        return "Tento vzácný drahokam může být klíčem k novým obchodním příležitostem.";
                    }
                } else {
                    return "V této oblasti není nic zajímavého.";
                }
            }
        }
        return "Nic tu není, pokračuj hledat jinde!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
