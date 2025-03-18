package Game.Command;

import Game.World;

public class Search extends Command {

    public Search() {
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < World.getMedkits().size(); i++) {
            if (World.getCurrentLocation() == World.getMedkits().get(i).getItemID()) {
                result.append("Medkit found!\n");
            }
        }

        for (int i = 0; i < World.getWeapons().size(); i++) {
            if (World.getCurrentLocation() == World.getWeapons().get(i).getItemID()) {
                result.append("Weapons found!\n");
            }
        }

        for (int i = 0; i < World.getNpc().size(); i++) {
            if (World.getCurrentLocation() == World.getNpc().get(i).getId()) {
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
