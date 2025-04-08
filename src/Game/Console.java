package Game;

import Game.Command.*;
import Game.Items.Inventory;
import Game.NPC.Merchant;

import java.util.HashMap;
import java.util.Scanner;


/**
 * Represents the console for interacting with the game.
 * This class using user input, executes commands.
 * It initializes commands for actions (moving, searching, talking to NPCs, and interacting with items).
 *
 * @author Vojtěch Malínek
 */
public class Console {

    private Scanner scanner;
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;
    private Inventory inventory;
    private Player player;
    private Merchant merchant;
    private GamePrints gamePrints = new GamePrints();


    public Console() {
    }


    /**
     * Initializes scanner for the game and commands,
     * world, inventory, player, merchant, and scanner.
     *
     * @author Vojtěch Malínek
     */
    private void initialization() {
        commands = new HashMap<>();
        world = new World();
        inventory = new Inventory();
        player = new Player();
        merchant = new Merchant();
        scanner = new Scanner(System.in);
        commands.put("jdi", new Move(scanner));
        commands.put("prohledat", new Search(world));
        commands.put("mluvit", new IteractWithEntity(world));
        commands.put("vzit", new TakeItem(world, inventory));
        commands.put("vyhodit", new ThrowOutItem(inventory, world, scanner));
        commands.put("pomoc", new Help(gamePrints));
        commands.put("medkit", new UseMedkit(inventory, player));
        commands.put("konec", new Exit());
        commands.put("zautocit", new Attack(world, player, inventory, gamePrints));
        commands.put("staty", new ShowStats(inventory, player));
        commands.put("obchod", new MerchantCommand(world, merchant, inventory, scanner));
        commands.put("bedna", new UnlockCrate(world, inventory));
        commands.put("mapa", new UseMap(inventory));

    }

    /**
     * Executes the user command by from the input.
     * If the command is not correctly written, it will return the user that he used wrong command.
     *
     * @author Vojtěch Malínek
     */
    public void executeCommand() {
        System.out.println(">>");
        String command = scanner.next();
        if (commands.containsKey(command)) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).exit();
        } else {
            System.out.println("Neplatný příkaz. Zkuste to znovu.");
        }
    }



    /**
     * Starts the game by displaying the main menu, initialization the method,
     *
     * @author Vojtěch Malínek
     */
    public void start() {
        gamePrints.mainMenu();
        initialization();
        do {
            executeCommand();
        } while (!exit);
    }
}
