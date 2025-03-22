package Game.Command;


import Game.World;

import java.util.Scanner;

public class Move extends Command {

    public Move() {}



    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        int temp;

        System.out.println("Napište číslo planety, kam chcete přeletět:");
        System.out.println(World.getMap());

        while (true) {
            temp = sc.nextInt();

            if (temp < 1 || temp > 8) {
                System.out.println("Planeta neexistuje, zadejte znovu:");
                continue;
            }

            if (World.moveTo(temp)) {
                World.setCurrentLocation(temp);
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
