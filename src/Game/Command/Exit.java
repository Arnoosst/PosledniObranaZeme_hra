package Game.Command;


/**
 * Represents a command that ends the game.
 *
 * @author Vojtěch Malínek
 */
public class Exit extends Command{

    public Exit() {
    }


    /**
     * Executes the exit command.
     * This method returns a message indicating that the game has been ended.
     *
     * @author Vojtěch Malínek
     * @return a string message stating that the game has been exited.
     */
    @Override
    public String execute() {
        return "Hra byla ukončena.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
