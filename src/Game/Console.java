package Game;

import Game.Command.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;

    private void initialization() {
        commands = new HashMap<>();
        world = new World();
        scanner = new Scanner(System.in);
        commands.put("jdi", new Move());
        commands.put("prohledat", new Search());
        commands.put("mluvit", new IteractWithEntity());
        commands.put("vzit", new TakeItem());
        commands.put("vyhodit", new ThrowOutItem());
        commands.put("pomoc", new Help());
        commands.put("medkit", new UseMedkit());
        commands.put("konec", new Exit());
        commands.put("zautocit", new Attack());
        commands.put("invetar", new ShowInv());

    }

    public void executeCommand() {
        System.out.println(">>");
        String command = scanner.next();
        if (commands.containsKey(command)) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).exit();
        } else {
            System.out.println("spatny prikaz");
        }
    }


    public void start() {
        initialization();
        do {
            executeCommand();
        } while (!exit);
    }
}
