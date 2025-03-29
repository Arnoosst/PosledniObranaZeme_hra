package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GamePrints {

    public GamePrints() {
    }

    public  void loadHelp() {
        try (BufferedReader br = new BufferedReader(new FileReader("help.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public  void loadStartGame() {
        try (BufferedReader br = new BufferedReader(new FileReader("startGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public  void loadDoctor() {
        String x;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pro pokracovani v monologu kliknete enter \n");

        try (BufferedReader br = new BufferedReader(new FileReader("doctorHayes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                x = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadWon() {
        try (BufferedReader br = new BufferedReader(new FileReader("wonGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadLoseGame() {
        try (BufferedReader br = new BufferedReader(new FileReader("loseGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                delay(1000);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }









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


    // chagpt mi poradil jak udelam delay
    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
