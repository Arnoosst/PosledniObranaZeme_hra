package Game;

import Game.Command.*;
import Game.Items.Inventory;
import Game.Items.Item;
import Game.NPC.Merchant;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;
    private Inventory inventory;
    private Player player;
    private Merchant merchant;
    private MainMenu mainMenu= new MainMenu();


    public Console() {
    }


    private void initialization() {
        commands = new HashMap<>();
        world = new World();
        inventory = new Inventory();
        player = new Player();
        merchant = new Merchant();
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
        commands.put("staty", new ShowStats(inventory, player));
        commands.put("obchod", new MerchantCommand(world, merchant, inventory));

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
        mainMenu.mainMenu();
        initialization();
        do {
            executeCommand();
        } while (!exit);
    }
}
