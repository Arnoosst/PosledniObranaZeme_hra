package Game.Command;

import Game.World;

public class Search extends Command{

    World world = new World();

    public Search(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        return "Na planetě " + (world.searchPlanetForMedkits() ? "je" : "není") + " medkit.\n" +
                "Na planetě " + (world.searchPlanetForNpc() ? "je" : "není") + " NPC.\n" +
                "Na planetě " + (world.searchPlanetForWeapons() ? "je" : "není") + " weapon.\n";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
