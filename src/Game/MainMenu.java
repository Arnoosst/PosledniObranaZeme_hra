package Game;

import java.util.Scanner;

public class MainMenu {

    public MainMenu() {
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("===================================");
            System.out.println("🚀  POSLEDNÍ OBRANA ZEMĚ  🌍");
            System.out.println("===================================");
            System.out.println("1️⃣  Spustit hru");
            System.out.println("2️⃣  Nápověda");
            System.out.println("3️⃣  Ukončit hru");
            System.out.print("💡 Vyber možnost: \n>> \n");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("🛸 Hra se spouští... Připrav se na bitvu!");
                    startGame();
                    return;
                case 2:
                    System.out.println("📜 Nápověda:");
                    System.out.println("Tvým úkolem je chránit Zemi před mimozemskou invazí!");
                    System.out.println("➡️ Prozkoumávej planety, bojuj s nepřáteli a vylepšuj své vybavení.");
                    System.out.println("🔧 Používej strategii, abys přežil a zvítězil!");
                    System.out.println();
                    System.out.println("📜 DOSTUPNÉ PŘÍKAZY: " +
                            "\n 🔹 jdi [lokace] - Přesun do jiné lokace (pouze mezi Zemí a jinou planetou)" +
                            "\n 🔹 prohledat [místnost] - Prohledání místnosti" +
                            "\n 🔹 mluvit [postava] - Konverzace s postavou" +
                            "\n 🔹 vzit [předmět] - Vezme předmět do inventáře" +
                            "\n 🔹 vyhodit [předmět] - Zahodí předmět z inventáře" +
                            "\n 🔹 zautocit [nepřítel] - Zaútočí na nepřítele" +
                            "\n 🔹 medkit - Použije medkit pro léčení" +
                            "\n 🔹 staty - Zobrazí statistiky hráče a inventáře" +
                            "\n 🔹 obchod - Otevře obchod (Dostupné pouze na Zemi)" +
                            "\n 🔹 konec - Ukončí hru" +
                            "\n 🔹 pomoc - Zobrazí tuto nápovědu");
                    break;
                case 3:
                    // nevim jak ukoncit hru, zeptam se na hodine
                    System.out.println("👋 Díky za hraní! Ukončuji hru.");
                    return;
                default:
                    System.out.println("❌ Neplatná volba, zkus to znovu.");
            }
        }
    }



    public static void startGame() {
        System.out.println("=====================================");
        System.out.println("🚀  PŘÍPRAVA NA OBRANU ZEMĚ  🌍");
        System.out.println("=====================================");
        System.out.println("🛸 Kalibruji systémy...");
        delay(1000);
        System.out.println("🔧 Kontrola vybavení...");
        delay(1000);
        System.out.println("🛰️ Připojení k velitelskému centru...");
        delay(1500);
        System.out.println("✅ Vše připraveno! Bitva začíná!");
        System.out.println("=====================================");
    }


    // chagpt mi poradil jak udelam delay
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
