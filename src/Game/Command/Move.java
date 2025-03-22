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

            if (temp == 8 && World.getKillCount() < 6) {
                return "Musíš zabít všechny bosse na planetách!";
            }

            if (temp == 5 && !World.getOxygen()) {
                return "Musíš získat oxygen tank, abys mohl přistát na Titanu!";
            }

            if (temp == 6 && !World.getUnderWaterSuit()) {
                return "Musíš získat podvodní oblek, abys mohl přistát na Neptunu!";
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
