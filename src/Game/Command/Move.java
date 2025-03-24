package Game.Command;


import Game.Location;
import Game.World;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Move extends Command {

    public Move() {}



    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        int temp;

        System.out.println("🌍 Kam chceš letět? Zadej číslo planety:");
        String x;
        for (Location location : World.getMap().values()) {
            System.out.println(location);
        }


        while (true) {
            try {

                temp = sc.nextInt();

                if (temp < 1 || temp > 8) {
                    System.out.println("❌ Tahle planeta neexistuje, zkus to znovu:");
                    continue;
                }

                if (temp == 8 && World.getKillCount() <= 5) {
                    return "🚀 Musíš porazit všechny bosse, než se dostaneš na finální planetu!";
                }

                if (temp == 5 && !World.getOxygen()) {
                    return "🔴 Potřebuješ kyslíkovou nádrž, abys přežil na Titanu!";
                }

                if (temp == 6 && !World.getUnderWaterSuit()) {
                    return "🌊 Potřebuješ podvodní oblek, abys mohl přistát na Neptunu!";
                }

                if (World.moveTo(temp)) {
                    World.setCurrentLocation(temp);
                    return "✅ Přistál jsi na planetě " + World.getMap().get(temp).getName() + "!";
                } else {
                    System.out.println("🚫 Na tuto planetu nelze přistát. Zkus jinou:");
                }
            }catch (InputMismatchException e) {
                System.out.println("❌ Neplatný vstup! Zadej číslo planety:");
                sc.nextLine();
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
