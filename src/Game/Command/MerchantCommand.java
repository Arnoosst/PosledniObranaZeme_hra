package Game.Command;


import Game.Items.Inventory;
import Game.Items.Item;
import Game.NPC.Merchant;
import Game.World;

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
            int choice2;

            merchant.loadMerchnatPrint();

            System.out.println();

            while (true) {
                try {
                    System.out.println("Chceš koupit nebo prodat? \n 1 = Koupit \n 2 = Prodat  \n 3 = Drahokamy \n 4 = Odejít \n >>");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
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
                            break;

                        case 2:
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
                            break;

                        case 3:

                            //dodelat metodu, pro kazdy case to sem implementovat
                            //dodelat ty vyjimky u nacitani ze souboru to throw new je blbost protoze to vyhodi novou podminku
                            //zkontrolovat ty crate jetli funguji, rozhodnout se jestli klice pujdou kupovat nebo dropovat z enemy
                            //pokud budu chtit tak kazdymu enemy dat kolik dropne coinu
                            //balancovat hru

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

    @Override
    public boolean exit() {
        return false;
    }
}
