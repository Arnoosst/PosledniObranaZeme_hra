package Game.Command;

/**
 * Abstract class representing a command in the game.
 * Each command must define its own behavior for execution and whether it should exit the game.
 *
 * @author Vojtěch Malínek
 */
public abstract class Command {

    /**
     * Executes the command.
     * Each subclass must implement this method to define the specific behavior of the command.
     *
     * @author Vojtěch Malínek
     * @return a string message indicating the result of executing the command.
     */
    public abstract String execute();

    /**
     * Determines if the command should exit the game.
     * Each subclass must implement this method to specify whether the game should be exited after the command is executed.
     *
     * @author Vojtěch Malínek
     * @return true if the game should exit, false otherwise.
     */
    public abstract boolean exit();


}
