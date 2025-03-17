package Game.Command;

import Game.Items.Inventory;
import Game.World;

import java.util.Scanner;

public class ThrowOutItem extends Command{
    World world = new World();

    public ThrowOutItem(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jaky item chcete vyhodit z invu");
        System.out.println(Inventory.getInventory());
        System.out.println("Zadejte id itemu");
        int id = sc.nextInt();
        if(world.removeItemFromInventory(id)){
            return "Item byl ostranen";
        }
        return "spatny id";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
