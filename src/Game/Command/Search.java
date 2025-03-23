package Game.Command;

import Game.Items.Item;
import Game.Items.Medkit;
import Game.NPC.Entity;
import Game.World;

public class Search extends Command {

    private World world;

    public Search(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        for (Item medkit : world.getMedkits()) {
            if (World.getCurrentLocation() == medkit.getItemID()) {
                result.append("🩹 Našel jsi Medkit!\n");
            }
        }

        for (Item weapon : world.getWeapons()) {
            if (World.getCurrentLocation() == weapon.getItemID()) {
                result.append("🔫 Našel jsi zbraň!\n");
            }
        }

        for (Entity npc : world.getNpc()) {
            if (World.getCurrentLocation() == npc.getId()) {
                result.append("🧑‍🚀 Narazil jsi na přeživšího!\n");
            }
        }

        return result.isEmpty() ? "🔍 Nic jsi nenašel!" : result.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
