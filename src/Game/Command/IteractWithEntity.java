package Game.Command;

import Game.World;


/**
 * Represents a command that allows the player to interact with an NPC in the game.
 * If there is an NPC at the current location of the player, the player can interact with them.
 *
 * @author Vojtěch Malínek
 */
public class IteractWithEntity extends Command{

     private World world;


    public IteractWithEntity(World world) {
        this.world = world;
    }

    /**
     * Executes the interaction with an NPC.
     * The method checks if there is an NPC at the current location of the player.
     * If there is, the players interaction with the NPC is displayed (NPCs name and speech are displayed).
     * If no NPC is found, the player is informed that they must try a different location.
     *
     * @author Vojtěch Malínek
     * @return a string that contains the outcome of the interaction
     */
    @Override
    public String execute() {
        for (int i = 0; i < world.getNpc().size(); i++) {
            if (World.getCurrentLocation() == world.getNpc().get(i).getId()) {
                System.out.println("Ahoj, jmenuji se: " + world.getNpc().get(i).getName());
                return "💬 " + world.getNpc().get(i).getSpeach();
            }
        }
        return "Tady nikdo není. Zkus jinou lokaci!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
