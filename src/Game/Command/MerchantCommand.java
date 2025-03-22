package Game.Command;


import Game.Items.Inventory;
import Game.Items.Item;
import Game.NPC.Merchant;
import Game.World;

import java.util.Scanner;

public class MerchantCommand extends Command {

    private World world;
    private Merchant merchant;
    private Inventory inventory;

    public MerchantCommand(World world, Merchant merchant, Inventory inventory) {
        this.world = world;
        this.merchant = merchant;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        if(World.getCurrentLocation() == 1){
            int choice;
            int choice2;
            boolean temp = true;
            boolean temp2 = true;


            System.out.println("Vítej, cizinče! Heh heh heh… Vidím, že jsi na lovu pořádnýho arzenálu. \n" +
                    "Máš něco, co bys chtěl prodat? \n Nebo tě spíš zajímá smrtící výbava, co z tvojí mise udělá krvavou podívanou? \n" +
                    "Heh heh… Podívej se, co tu mám! Každá zbraň je mistrovský kousek… a ty nejlepší přijdou za odpovídající cenu! \n " +
                    "Tak co, kupuješ?");



            while (temp2) {
                System.out.println("Chces koupit nebo prodat? \n 1 = koupit \n 2 = prodat \n >>");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        merchant.toString();
                        System.out.println("Napis id zbrane/medkitu, ktery chces");
                        choice2 = sc.nextInt();
                        while (temp) {
                            if (merchant.sellItem(choice2) == null) {
                                System.out.println("Napis id zbrane/medkitu, ktery chces");
                                choice2 = sc.nextInt();
                            } else {
                                inventory.addItem(merchant.sellItem(choice2));
                                temp = false;
                                return "Zakoupil jsi item";
                            }
                        }
                        break;
                    case 2:
                        inventory.toString();
                        System.out.println("Napis id zbrane/medkitu, ktery chces prodat");
                        choice2 = sc.nextInt();
                        while (temp) {
                            if (inventory.locateItemFromId(choice2) == null) {
                                System.out.println("Napis id zbrane/medkitu, ktery chces prodat");
                                choice2 = sc.nextInt();
                            } else {
                                merchant.buyItem(inventory.locateItemFromId(choice2));
                                inventory.removeItem(inventory.locateItemFromId(choice2));
                                temp2 = false;
                                return "Zakoupil jsi item";
                            }
                        }
                        break;
                    default:
                        System.out.println("napis jedna nebo dva");
                        break;
                }
            }
        }

        return "Chyba";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
