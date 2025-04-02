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

        for(int i = 0; i < world.getCrates().size(); i++) {
            if (World.getCurrentLocation() == world.getCrates().get(i).getPlanetID()){
                if(world.getCrates().get(i).isFound()){
                    if(inventory.getKeys() >= 1){
                        inventory.setKeys(inventory.getKeys() - 1);
                        inventory.addGemStone(world.getCrates().get(i).getGemStone());
                        System.out.println("Pridal se ti drahokam: " + world.getCrates().get(i).getGemStone().getItemName());
                        world.getCrates().remove(world.getCrates().get(i).getGemStone());
                        return "Tento drahokam z velkou pravdepodobostim uzes donest obchodnikovi";
                    }
                }
            }
        }
        return "Nic tu neni";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
