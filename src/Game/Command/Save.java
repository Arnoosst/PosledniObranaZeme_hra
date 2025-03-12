package Game.Command;

public class Save extends Command {

    @Override
    public String execute() {

        return "Hra ulozena";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
