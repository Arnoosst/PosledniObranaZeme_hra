package Game.Command;

import Game.World;

public class Search extends Command {

    private World world;

    public Search(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < world.getMedkits().size(); i++) {
            if (world.getCurrentLocation() == world.getMedkits().get(i).getItemID()) {
                result.append("Medkit found!\n");
            }
        }

        for (int i = 0; i < world.getWeapons().size(); i++) {
            if (world.getCurrentLocation() == world.getWeapons().get(i).getItemID()) {
                result.append("Weapons found!\n");
            }
        }

        for (int i = 0; i < world.getNpc().size(); i++) {
            if (world.getCurrentLocation() == world.getNpc().get(i).getId()) {
                result.append("Friendly entity found!\n");
            }
        }

        return result.isEmpty() ? "Nothing found!" : result.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
