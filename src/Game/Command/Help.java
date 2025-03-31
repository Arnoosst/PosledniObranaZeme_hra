package Game.Command;

import Game.GamePrints;


/**
 * Represents a command that provides help to the player in the game.
 */
public class Help extends Command{

    private GamePrints gamePrints;

    public Help(GamePrints gamePrints) {
        this.gamePrints = gamePrints;
    }



    /**
     * Executes the help command.
     * This method calls the loadHelp() method from the GamePrints object
     * to load and display the help information for the player.
     *
     * @return an empty string, as the help information is displayed via the loadHelp() method.
     */
    @Override
    public String execute() {
        gamePrints.loadHelp();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
