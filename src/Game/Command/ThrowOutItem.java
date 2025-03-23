package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.World;

import java.util.Scanner;

public class ThrowOutItem extends Command{

    private Inventory inventory;

    public ThrowOutItem(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("🗑️ Jaký předmět chceš vyhodit z inventáře?");
        System.out.println("📜 Tvoje aktuální inventář:");

        for (Item item : inventory.getInventory()) {
            System.out.println("➡️ " + item.getItemID() + ": " + item.getItemName());
        }

        System.out.print("✏️ Zadej ID předmětu: ");
        int id = sc.nextInt();

        for (int i = 0; i < inventory.getInventory().size(); i++) {
            if (id == inventory.getInventory().get(i).getItemID()) {
                inventory.removeItem(inventory.getInventory().get(i));
                return "✅ Předmět " + id + " byl odstraněn z inventáře.";
            }
        }
        return "❌ Špatné ID, žádný takový předmět v inventáři není!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
