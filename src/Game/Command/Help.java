package Game.Command;

import Game.GamePrints;

public class Help extends Command{

    private GamePrints gamePrints;

    public Help(GamePrints gamePrints) {
        this.gamePrints = gamePrints;
    }

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
