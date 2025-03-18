package Game.Command;

public class Help extends Command{

    public Help() {
    }

    @Override
    public String execute() {
        return "dostupne prikazy: " +
                "\n  jdi [lokace] " +
                "\n  vezmi [předmět] " +
                "\n vyhod[předmět] " +
                "\n pouzij [předmět] " +
                "\n mluv [postava] " +
                "\n prozkoumej [místnost] " +
                "\n utok [nepřítel] " +
                "\n konec " +
                "\n pomoc";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
