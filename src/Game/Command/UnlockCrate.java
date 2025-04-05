package Game.Command;

import Game.Items.Inventory;
import Game.World;

/**
 * Represents a command that allows the player to unlock a crate if the crate is at the current location.
 * If a crate is found and the player has at least one key, it uses the key and gives the player a gemstone.
 *
 * @author Vojtěch Malínek
 */
public class UnlockCrate extends Command{

    private World world;
    private Inventory inventory;

    public UnlockCrate(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
    }


    /**
     * Trying to unlock a crate at the current location.
     * If a crate is found at the current location and has not yet been opened (gemstone is not null),
     * and if the player has at least one key, the key is removed and the gemstone is added to the players inventory.
     * The gemstone is then removed from the crate to prevent re-taking.
     *
     * @return a message describing the result of the unlock attempt
     * @author Vojtěch Malínek
     */
    @Override
    public String execute() {

        for (int i = 0; i < world.getCrates().size(); i++) {
            if (World.getCurrentLocation() == world.getCrates().get(i).getPlanetID()) {
                if (world.getCrates().get(i).isFound()) {
                    if(world.getCrates().get(i).getGemStone() == null) {
                        return "Tuto bednu si už otevřel";
                    }
                    if (inventory.getKeys() >= 1) {
                        inventory.setKeys(inventory.getKeys() - 1);
                        System.out.println(world.getCrates().get(i).getGemStone().getItemName());
                        inventory.addGemStone(world.getCrates().get(i).getGemStone());
                        System.out.println("Podařilo se ti získat nový drahokam: " + world.getCrates().get(i).getGemStone().getItemName());
                        world.getCrates().get(i).setGemStone(null);
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
