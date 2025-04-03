package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The GamePrints class handles the loading and displaying game text files.
 *
 * @author Vojtěch Malínek
 */
public class GamePrints {

    /**
     * Default constructor for GamePrints.
     *
     * @author Vojtěch Malínek
     */
    public GamePrints() {
    }

    /**
     * Loads and prints the help text from help.txt.
     * Throws a runtime exception if the file is not found or cannot be read.
     *
     * @author Vojtěch Malínek
     */
    public void loadHelp() {
        try (BufferedReader br = new BufferedReader(new FileReader("help.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. \"help.txt\"");
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru. \"help.txt\"");
        }
    }

    /**
     * Loads and prints the start game text from startGame.txt with a delay between lines.
     * Throws a runtime exception if the file is not found or cannot be read.
     *
     * @author Vojtěch Malínek
     */
    public void loadStartGame() {
        try (BufferedReader br = new BufferedReader(new FileReader("startGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. \"startGame.txt\"");
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru. \"startGame.txt\"");
        }
    }

    /**
     * Loads and prints the doctor dialogue from doctorHayes.txt.
     * The player must press enter to continue through the dialogue.
     *
     *
     * @author Vojtěch Malínek
     */
    public void loadDoctor() {
        String x;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPro pokracovani v dialogu kliknete enter\n");

        try (BufferedReader br = new BufferedReader(new FileReader("doctorHayes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                x = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. \"doctorHayes.txt\"");
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru. \"doctorHayes.txt\"");
        }
    }

    /**
     * Loads and prints the victory message from "wonGame.txt" with a delay between lines.
     * Throws a runtime exception if the file is not found or cannot be read.
     *
     * @author Vojtěch Malínek
     */
    public void loadWon() {
        try (BufferedReader br = new BufferedReader(new FileReader("wonGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. \"wonGame.txt\"");
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru. \"wonGame.txt\"");
        }
    }

    /**
     * Loads and prints the game over message from "loseGame.txt" with a delay between lines.
     * Throws a runtime exception if the file is not found or cannot be read.
     *
     * @author Vojtěch Malínek
     */
    public void loadLoseGame() {
        try (BufferedReader br = new BufferedReader(new FileReader("loseGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. \"loseGame.txt\"");
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru. \"loseGame.txt\"");
        }
    }




    /**
     * Displays the main menu and processes user input.
     *
     * @author Vojtěch Malínek
     */
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("===================================");
            System.out.println("🚀  POSLEDNÍ OBRANA ZEMĚ  🌍");
            System.out.println("===================================");
            System.out.println("1.  Spustit hru");
            System.out.println("2.  Nápověda");
            System.out.println("3.  Preskocit intro");
            System.out.print("Vyber možnost: \n>> \n");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hra se spouští Připrav se na bitvu!");
                    loadStartGame();
                    loadDoctor();
                    return;
                case 2:
                    loadHelp();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Neplatná volba, zkus to znovu.");
            }
        }
    }


    /**
     * Delays execution for a given amount of milliseconds.
     * This method was done with help of chatGPT
     *
     * @author chatGPT
     * @param ms The number of milliseconds to delay.
     */
    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
