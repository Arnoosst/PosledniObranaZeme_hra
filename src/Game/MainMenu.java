package Game;

import java.util.Scanner;

public class MainMenu {


    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("===================================");
            System.out.println("🚀  POSLEDNÍ OBRANA ZEMĚ  🌍");
            System.out.println("===================================");
            System.out.println("1️⃣  Spustit hru");
            System.out.println("2️⃣  Nápověda");
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
        delay(2000);

        talkToDoctor();
    }


    private static void talkToDoctor(){
        System.out.println("🥼 [Dr. Evelyn Hayes]");
        System.out.println("\"Takže… Ty jsi ten, co nás zachrání?! Vypadáš, že víš, do čeho jdeš. Nebo se to aspoň snažíš předstírat.\"");
        delay(1500);
        System.out.println("\n📦 \"Tady. Ber tuhle zbraň a mince jako malou šanci na přežití. Víc ti teď dát nemůžu.\"");
        delay(1500);
        System.out.println("\n🛒 \"Jestli to myslíš vážně, měl bys navštívit obchodníka. Najdeš ho na Zemi. Má vybavení, co ti může zachránit život – pokud na to máš.\"");
        delay(1500);
        System.out.println("\n🌌 \"Tam venku jsou světy, které neznáš. Každý z nich má svého vládce. A žádný z nich nenechá Zemi jen tak být.\"");
        delay(1500);
        System.out.println("\n🎯 \"Musíš je najít. A postarat se, aby už nepředstavovali hrozbu.\"");
        delay(1500);
        System.out.println("\n🔒 \"Cesta k tomu, kdo za tím vším stojí, je zavřená. Dokud nesplníš svůj úkol.\"");
        delay(1500);
        System.out.println("\n🛰️ \"Ale nebude to tak jednoduché. Některá místa tě bez správného vybavení prostě nepustí dál:\"");
        System.out.println("   🔴 \"Neprun je pro tebe teď nedostupný. Potřebuješ speciální vybavení, jinak se tam ani nedostaneš.\"");
        System.out.println("   🔵 \"Titan? Bez pořádné ochrany bys tam nepřežil ani minutu.\"");
        delay(1500);
        System.out.println("\n🔎 \"Prozkoumávej všechno. Každý kus vybavení, každý náznak, cokoliv, co by ti mohlo dát výhodu.\"");
        System.out.println("\n🤖 \"Tohle je všechno, co ti můžu říct. Jestli to zvládneš, nebo ne… to už záleží na tobě.\"");
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
