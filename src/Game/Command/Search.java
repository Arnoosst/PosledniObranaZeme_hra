package Game.Command;

import Game.Items.Item;
import Game.Items.Medkit;
import Game.NPC.Entity;
import Game.World;


/**
 * Represents a command to search the current location for items (medkits, weapons) and NPCs.
 *
 * @author Vojtěch Malínek
 */
public class Search extends Command {

    private World world;

    public Search(World world) {
        this.world = world;
    }


    /**
     * Executes the command to search the current location for medkits, weapons, and NPCs.
     *
     * @author Vojtěch Malínek
     * @return a message indicating what was found at the current location
     */
    @Override
    public String execute() {
        String result = "";

        for (Item medkit : world.getMedkits()) {
            if (World.getCurrentLocation() == medkit.getItemID()) {
                result = result + "Našel jsi Medkit!\n";
            }
        }

        for (Item weapon : world.getWeapons()) {
            if (World.getCurrentLocation() == weapon.getItemID()) {
                result = result + "Našel jsi zbraň!\n";
            }
        }

        for (Entity npc : world.getNpc()) {
            if (World.getCurrentLocation() == npc.getId()) {
                result = result + "Narazil jsi na přeživšího!\n";
            }
        }

        if(result.isEmpty()){
            return "Nic jsi nenašel!";
        }else {
            return result;
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
