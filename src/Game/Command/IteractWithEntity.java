package Game.Command;

import Game.World;

public class IteractWithEntity extends Command{

    public IteractWithEntity() {
    }

    @Override
    public String execute() {

        for (int i = 0; i < World.getNpc().size(); i++) {
            if (World.getCurrentLocation() == World.getNpc().get(i).getId()) {
                System.out.println("Ahoj jmenuji se:" + World.getNpc().get(i).getName());
                return World.getNpc().get(i).getSpeach();
            }
        }
        return "Tady nikdo neni";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
