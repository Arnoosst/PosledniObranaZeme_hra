package Game.Command;


import Game.Items.Inventory;
import Game.Items.Item;
import Game.NPC.Merchant;
import Game.World;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    @Override
    public String execute() {
        if (World.getCurrentLocation() == 1) {
            int choice;
            int choice2;

            System.out.println("Heh heh heh… Vítej, cizinče! Vidím, že máš zájem o pořádný arzenál. \n" +
                    "Máš něco, co bys chtěl prodat? \n Nebo hledáš něco, co by ti pomohlo na tvé krvavé cestě? \n" +
                    "Heh heh… Podívej se, co tady mám! Každý kousek je mistrovské dílo… ale jak se říká, všechno má svou cenu. \n" +
                    "Tak co, cizinče? Máš zájem o nějaké věci?");

            while (true) {
                try {
                    System.out.println("Chceš koupit nebo prodat? \n 1 = Koupit \n 2 = Prodat \n 3 = Odejít \n >>");
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
                            return "Měj se, cizinče!";

                        default:
                            System.out.println("Heh heh, cizinče, napiš číslo 1, 2 nebo 3. Co chceš udělat?");
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
