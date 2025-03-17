package Game.Command;


import Game.World;

import java.util.Scanner;

public class Move extends Command {

    World world = new World();

    public Move(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        int temp;

        System.out.println("Napište číslo planety, kam chcete přeletět:");
        System.out.println(world.getMap());

        while (true) {
            temp = sc.nextInt();

            if (temp < 1 || temp > 8) {
                System.out.println("Planeta neexistuje, zadejte znovu:");
                continue;
            }

            if (world.moveTo(temp)) {
                return "Přesun na planetu " + temp + " byl úspěšný.";
            } else {
                System.out.println("Na tuto planetu nelze přiletět. Zadejte znovu:");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
