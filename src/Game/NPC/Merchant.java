package Game.NPC;


import Game.Items.Item;
import Game.Items.Medkit;
import Game.Items.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Merchant {

    private int coins;
    private ArrayList<Item> sortiment;


    public Merchant() {
        this.coins = 400;
        sortiment = new ArrayList<>();
        loadWeapons();
        loadMedKits();
    }




    public boolean buyItem(Item item) {
        if (item == null) {
            return false;

        }
        if (sortiment.contains(item)) {
            return false;
        }
        sortiment.add(item);
        return true;
    }

    public Item sellItem(int id) {
        Item item2;
        for (Item item : sortiment) {
            if (item.getItemID() == id) {
                item2 = item;
                sortiment.remove(item);
                return item2;
            }
        }
        return null;
    }



    public  void loadMedKits() {
        try (BufferedReader br = new BufferedReader(new FileReader("medkitsMerchant.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int health = Integer.parseInt(parts[1]);
                String name = parts[2];
                int price = Integer.parseInt(parts[3]);
                sortiment.add(new Medkit(name, id, health, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadWeapons() {
        try (BufferedReader br = new BufferedReader(new FileReader("weaponsMerchant.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int damage = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                sortiment.add(new Weapon(name, id, damage, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    @Override
    public String toString() {
        return "Merchant{" +
                "coins=" + coins +
                ", sortiment=" + sortiment +
                '}';
    }
}
