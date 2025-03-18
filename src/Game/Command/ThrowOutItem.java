package Game.Command;

import Game.Items.Inventory;
import Game.World;

import java.util.Scanner;

public class ThrowOutItem extends Command{

    public ThrowOutItem() {}

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jaky item chcete vyhodit z invu");
        System.out.println(Inventory.getInventory());
        System.out.println("Zadejte id itemu");
        int id = sc.nextInt();
        for (int i = 0; i < Inventory.getInventory().size() ; i++) {
            if (id == Inventory.getInventory().get(i).getItemID()) {
                Inventory.removeItem(Inventory.getInventory().get(i));
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
