package Game.Command;

import Game.Items.Inventory;
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
        System.out.println("Jaky item chcete vyhodit z invu");
        System.out.println(inventory.getInventory());
        System.out.println("Zadejte id itemu");
        int id = sc.nextInt();
        for (int i = 0; i < inventory.getInventory().size() ; i++) {
            if (id == inventory.getInventory().get(i).getItemID()) {
                inventory.removeItem(inventory.getInventory().get(i));
                return "Item byl ostranen";
            }
        }
        return "spatny id";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
