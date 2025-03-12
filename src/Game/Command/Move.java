package Game.Command;


import Game.World;

import java.util.Scanner;

public class Move extends Command{
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        boolean exist = true;
        int temp;
        System.out.println("Napiste cislo planety kam chete preletet");
        System.out.println(World.getMap());
        while(exist){
            temp = sc.nextInt();
            if(temp <1 && temp > 8){
                System.out.println("Planeta neexistuje zadejte znovu");
            }else {
                exist = false;
            }
        }
        return "Presun na planetu byl uspesny";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
