package Game.Command;

import Game.MainMenu;

public class Help extends Command{

    private MainMenu mainMenu;

    public Help(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public String execute() {
        mainMenu.loadHelp();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
