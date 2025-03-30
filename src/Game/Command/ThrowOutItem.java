package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.World;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowOutItem extends Command{

    private Inventory inventory;
    private World world;
    private Scanner sc;

    public ThrowOutItem(Inventory inventory, World world, Scanner scanner) {
        this.inventory = inventory;
        this.world = world;
        this.sc = scanner;
    }

    @Override
    public String execute() {
        System.out.println("Jaký předmět chceš vyhodit z inventáře?");
        System.out.println("Tvůj aktuální inventář:");


        inventory.printInventory();

        System.out.print("Zadej ID předmětu: \n>> \n");

        int id;

        while (true) {
            try {
                id = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Neplatný vstup, zadej číslo!");
                sc.nextLine();
            }
        }


        Item itemToRemove = null;
        for (Item item : inventory.getInventory()) {
            if (item.getItemID() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove == null) {
            return "Špatné ID, žádný takový předmět v inventáři není!";
        }

        if (itemToRemove instanceof Medkit) {
            inventory.locateItemFromId(itemToRemove.getItemID()).setItemID(World.getCurrentLocation());
            world.getMedkits().add(itemToRemove);
        } else {
            inventory.locateItemFromId(itemToRemove.getItemID()).setItemID(World.getCurrentLocation());
            world.getWeapons().add(itemToRemove);
        }

        inventory.removeItem(itemToRemove);

        return "Předmět " + itemToRemove.getItemName() + " (ID: " + id + ") byl odstraněn z inventáře.";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
