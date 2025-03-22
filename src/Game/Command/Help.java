package Game.Command;

public class Help extends Command{

    public Help() {
    }

    @Override
    public String execute() {
        return  "Dostupné příkazy: " +
                "\n jdi [lokace] - Přesun do jiné lokace" +
                "\n prohledat [místnost] - Prohledání místnosti" +
                "\n mluvit [postava] - Konverzace s postavou" +
                "\n vezmi [předmět] - Vezme předmět do inventáře" +
                "\n vyhodit [předmět] - Zahodí předmět z inventáře" +
                "\n zautocit [nepřítel] - Zaútočí na nepřítele" +
                "\n medkit - Použije medkit pro léčení" +
                "\n staty - Zobrazí statistiky hráče a inventáře" +
                "\n konec - Ukončí hru" +
                "\n pomoc - Zobrazí tuto nápovědu";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
