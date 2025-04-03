package Game.Command;


import Game.Items.*;
import Game.NPC.Merchant;
import Game.World;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Represents a command that allows the player to interact with a merchant in the game.
 *
 * @author Vojtěch Malínek
 */
public class MerchantCommand extends Command {

    private World world;
    private Merchant merchant;
    private Inventory inventory;
    private Scanner sc;

    public MerchantCommand(World world, Merchant merchant, Inventory inventory, Scanner scanner) {
        this.world = world;
        this.merchant = merchant;
        this.inventory = inventory;
        this.sc = scanner;
    }



    /**
     * Executes the merchant interaction command.
     * Depending on the player's choice, they can buy or sell items.
     * If the player is at location 1, the merchant is available, otherwise a message is displayed saying no merchant is present.
     *
     * The player is prompted to choose between:
     * - Buying items from the merchant (option 1),
     * - Selling items to the merchant (option 2),
     * - Exiting the merchant menu (option 3).
     * For buying and selling, the method checks if the player has sufficient coins or if the merchant has enough coins to complete the transaction.
     *
     * @author Vojtěch Malínek
     * @return a string containing the outcome of the transaction
     */
    @Override
    public String execute() {
        if (World.getCurrentLocation() == 1) {
            int choice;
            int choice2 = 0;

            merchant.loadMerchnatPrint();

            System.out.println();

            while (true) {
                try {
                    System.out.println("Chceš koupit nebo prodat? \n 1 = Koupit \n 2 = Prodat  \n 3 = Drahokamy \n 4 = Odejít \n >>");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            choice1Buy(choice2);
                            break;

                        case 2:
                            choice2Buy(choice2);
                            break;

                        case 3:
                            choice3Buy(choice2);
                            break;

                        case 4:
                            return "Měj se, cizinče!";

                        default:
                            System.out.println("Heh heh, cizinče, napiš číslo 1, 2, 3 nebo 4. Co chceš udělat?");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Neplatný vstup! Napiš číslo.");
                    sc.nextLine();
                }
            }
        } else {
            return "Tady nikdo není";
        }
    }



    private void choice1Buy(int choice2){
        System.out.println(merchant.printSortiment());
        System.out.println("Hmm… Tak jaké věci tě zajímají? Napiš ID zbraně/medkitu, který chceš koupit (nebo 0 pro návrat).");
        while (true) {
            try {
                choice2 = sc.nextInt();
                if (choice2 == 0) break;
                Item itemToBuy = merchant.locateItemFromId(choice2);
                if (itemToBuy == null) {
                    System.out.println("Hmm… To zboží nemám. Zkus jiné ID nebo napiš 0 pro návrat.");
                } else if (inventory.getCoins() < itemToBuy.getItemPrice()) {
                    System.out.println("Heh… Nemáš dost peněz, cizinče. Co třeba sehnat víc?");
                } else {
                    inventory.addItem(itemToBuy);
                    inventory.setCoins(inventory.getCoins() - itemToBuy.getItemPrice());
                    merchant.setCoins(merchant.getCoins() + itemToBuy.getItemPrice());
                    merchant.sellItem(choice2);
                    System.out.println("Kupuješ? Dobrá volba, cizinče. Užij si to.");
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Neplatný vstup! Napiš číslo.");
                sc.nextLine();
            }
        }
    }

    private void choice2Buy(int choice2){
        System.out.println(inventory.printInventory());
        System.out.println("Máš něco, co bys rád prodal? Napiš ID zbraně/medkitu, který chceš prodat (nebo 0 pro návrat).");
        while (true) {
            try {
                choice2 = sc.nextInt();
                if (choice2 == 0) break;
                Item itemToSell = inventory.locateItemFromId(choice2);
                if (itemToSell == null) {
                    System.out.println("Hmm… Ten předmět nemáš. Zkus napsat správné ID nebo napiš 0 pro návrat.");
                } else if (merchant.getCoins() < itemToSell.getItemPrice()) {
                    System.out.println("Heh… Nemám dost peněz, cizinče. Možná příště.");
                } else {
                    inventory.setCoins(inventory.getCoins() + itemToSell.getItemPrice());
                    merchant.setCoins(merchant.getCoins() - itemToSell.getItemPrice());
                    merchant.buyItem(itemToSell);
                    inventory.removeItem(itemToSell);
                    System.out.println("Heh heh… Dobrý obchod, cizinče. Teď to bude ještě lepší.");
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Neplatný vstup! Napiš číslo.");
                sc.nextLine();
            }
        }
    }

    private void choice3Buy(int choice2) {
        int choice3;
        System.out.println("Ahh, cizinče! Co kupuješ?");
        System.out.println("1. Koupit mapu pro bednu, která má drahokam");
        System.out.println("2. Prodat drahokamy");
        System.out.println("0. Návrat");

        while (true) {
            try {
                System.out.print(">> ");
                choice2 = sc.nextInt();
                sc.nextLine();

                if (choice2 == 0) {
                    System.out.println("Hehehe... Přijď zas!");
                    break;
                } else if (choice2 == 1) {
                    System.out.println("Co kupuješ?");
                    System.out.println(merchant.printMapsForCrates());

                    while (true) {
                        try {
                            System.out.println("Vyber si, cizinče! (Zadej ID mapy nebo 0 pro návrat)");
                            System.out.print(">> \n");
                            choice3 = sc.nextInt();
                            sc.nextLine();

                            if (choice3 == 0) {
                                System.out.println("Heh, změna plánu? Jak chceš!");
                                break;
                            }

                            MapForCrate mapForCrate = merchant.locateMapFromId(choice3);

                            if (mapForCrate == null) {
                                System.out.println("Hmm… To nemám na skladě. Zkus něco jiného, nebo napiš 0 pro návrat.");
                            } else if (inventory.getCoins() < mapForCrate.getItemPrice()) {
                                System.out.println("Nemáš dost mincí, cizinče. Potřebuješ víc peněz...");
                                break;
                            } else {
                                for (Crate crate : world.getCrates()) {
                                    if (mapForCrate.getItemID() == crate.getPlanetID()) {
                                        crate.setFound(true);
                                        merchant.getMapsForCrates().remove(mapForCrate);
                                        inventory.setCoins(inventory.getCoins() - mapForCrate.getItemPrice());
                                        merchant.setCoins(merchant.getCoins() + mapForCrate.getItemPrice());
                                        System.out.println("Děkuji! Hehehe... Skvělý výběr, cizinče!");
                                        break;
                                    }
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Cože? Tomu nerozumím! Zkus to znovu číslem.");
                            sc.nextLine();
                        }
                    }
                } else if (choice2 == 2) {
                    if (inventory.getGemStones().isEmpty()) {
                        System.out.println("Nemáš žádné drahokamy, cizinče. Škoda!");
                        continue;
                    }

                    int soucet = 0;
                    System.out.println("Ahhh, drahokamy! Ty mám rád! Vezmu si je všechny, hehehe!");

                    for (GemStone gem : new ArrayList<>(inventory.getGemStones())) {
                        soucet += gem.getItemPrice();
                        inventory.getGemStones().remove(gem);
                    }

                    inventory.setCoins(inventory.getCoins() + soucet);
                    System.out.println("Hehehe... Prodáno! Získal jsi " + soucet + " mincí.");
                } else {
                    System.out.println("To není v nabídce, cizinče. Zkus to znovu!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Cože? Tomu nerozumím! Zkus to znovu číslem.");
                sc.nextLine();
            }
        }
    }


    //balancovat hru
    //mozna pridat do konstruktoru ty crate idk

    @Override
    public boolean exit() {
        return false;
    }
}
