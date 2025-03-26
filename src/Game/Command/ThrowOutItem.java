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

    public ThrowOutItem(Inventory inventory, World world) {
        this.inventory = inventory;
        this.world = world;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jaký předmět chceš vyhodit z inventáře?");
        System.out.println("Tvůj aktuální inventář:");

        // Výpis inventáře
        for (Item item : inventory.getInventory()) {
            System.out.println("➡️ " + item.getItemID() + ": " + item.getItemName());
        }

        System.out.print("Zadej ID předmětu: \n>> \n");


        int id;
        try {
            id = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            return "Neplatný vstup! Zadej číslo.";
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
