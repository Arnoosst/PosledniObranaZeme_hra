package Game.Command;

public class Exit extends Command{

    public Exit() {
    }

    @Override
    public String execute() {
        return "❌ Hra byla ukončena.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
