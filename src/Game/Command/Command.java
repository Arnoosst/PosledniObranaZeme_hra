package Game.Command;

/**
 * Abstract class representing a command in the game.
 * Each command must define its own behavior for execution and whether it should exit the game.
 */
public abstract class Command {

    /**
     * Executes the command.
     * Each subclass must implement this method to define the specific behavior of the command.
     *
     * @return a string message indicating the result of executing the command.
     */
    public abstract String execute();

    /**
     * Determines if the command should exit the game.
     * Each subclass must implement this method to specify whether the game should be exited after the command is executed.
     *
     * @return {@code true} if the game should exit, {@code false} otherwise.
     */
    public abstract boolean exit();


}
