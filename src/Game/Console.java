package Game;

import Game.Command.*;
import Game.Items.Inventory;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;
    private Inventory inventory;
    private Player player;


    public Console() {
    }


    private void initialization() {
        commands = new HashMap<>();
        world = new World();
        inventory = new Inventory();
        player = new Player();
        scanner = new Scanner(System.in);
        commands.put("jdi", new Move());
        commands.put("prohledat", new Search(world));
        commands.put("mluvit", new IteractWithEntity(world));
        commands.put("vzit", new TakeItem(world, inventory));
        commands.put("vyhodit", new ThrowOutItem(inventory));
        commands.put("pomoc", new Help());
        commands.put("medkit", new UseMedkit(inventory, player));
        commands.put("konec", new Exit());
        commands.put("zautocit", new Attack(world, player, inventory));
        commands.put("inventar", new ShowInv(inventory));

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
