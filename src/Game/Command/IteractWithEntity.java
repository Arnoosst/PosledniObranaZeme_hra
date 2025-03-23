package Game.Command;

import Game.World;

public class IteractWithEntity extends Command{

     private World world;


    public IteractWithEntity(World world) {
        this.world = world;
    }


    @Override
    public String execute() {
        for (int i = 0; i < world.getNpc().size(); i++) {
            if (World.getCurrentLocation() == world.getNpc().get(i).getId()) {
                System.out.println("👋 Ahoj, jmenuji se: " + world.getNpc().get(i).getName());
                return "💬 " + world.getNpc().get(i).getSpeach();
            }
        }
        return "❌ Tady nikdo není. Zkus jinou lokaci!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
