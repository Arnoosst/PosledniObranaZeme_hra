package Game;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.NPC.Enemy;
import Game.NPC.Entity;
import Game.NPC.FriendlyFoe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  World {
    private  HashMap<Integer, Location> map = new HashMap<>();
    private  ArrayList<Entity> enemy = new ArrayList<>();
    private  HashMap<Integer, Entity> npc = new HashMap<>();
    private  ArrayList<Item> weapons = new ArrayList<>();
    private  ArrayList<Item> medkits = new ArrayList<>();
    private  int currentLocation = 1;
    private int health = 100;

    public World() {
        loadMap("map.txt");
        loadEnemy("enemy");
        loadMedKits("medkits");
        loadWeapons("weapon");
        loadNpc("npc");
    }

    public  void loadMap(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String nazev = parts[1];
                ArrayList<Integer> neighbor = new ArrayList<>();
                for (String s : parts[2].split(",")) {
                    neighbor.add(Integer.parseInt(s));
                }
                map.put(id, new Location(id, nazev, neighbor));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadWeapons(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int damage = Integer.parseInt(parts[2]);
                weapons.add(new Weapon(name, id, damage));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadMedKits(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int health = Integer.parseInt(parts[1]);
                String name = parts[2];
                medkits.add(new Medkit(name, id, health));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadEnemy(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int health = Integer.parseInt(parts[2]);
                String speech = parts[3];
                int damage = Integer.parseInt(parts[4]);
                enemy.add(new Enemy(speech, name, id, health, damage));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadNpc(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String speech = parts[2];
                int idPlanet = Integer.parseInt(parts[3]);

                npc.put(id, new FriendlyFoe(speech, name, id, idPlanet));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public  boolean moveTo(int location) {
        Location loc = map.get(currentLocation);
        if (map.containsKey(location)) {
            for (int neighbor : loc.getNeighbor()) {
                if (neighbor == location) {
                    currentLocation = location;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean searchPlanetForMedkits(){
        for(int i = 0; i < medkits.size(); i++) {
            if (currentLocation == medkits.get(i).getItemID()) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


    public boolean searchPlanetForWeapons(){
        for(int i = 0; i < weapons.size(); i++) {
            if (currentLocation == weapons.get(i).getItemID()) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean searchPlanetForNpc(){
        for(int i = 0; i < npc.size(); i++) {
            if (currentLocation == npc.get(i).getId()) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public List<String> getItemFromLocation() {
        List<String> addedItems = new ArrayList<>();

        for (int i = 0; i < weapons.size(); i++) {
            if (currentLocation == weapons.get(i).getItemID()) {
                Inventory.addItem(weapons.get(i));
                weapons.remove(i);
                addedItems.add("Weapon: " + weapons.get(i).getItemName());
            }

            if (currentLocation == medkits.get(i).getItemID()) {
                Inventory.addItem(medkits.get(i));
                medkits.remove(i);
                addedItems.add("Medkit: " + medkits.get(i).getItemName());
            }
        }

        return addedItems;
    }

    public boolean removeItemFromInventory(int itemID) {
        for (int i = 0; i < Inventory.getInventory().size() ; i++) {
            if (itemID == Inventory.getInventory().get(i).getItemID()) {
                Inventory.removeItem(Inventory.getInventory().get(i));
                return true;
            }
        }
        return false;
    }



    public  int getCurrentLocation() {
        return currentLocation;
    }

    public  HashMap<Integer, Location> getMap() {
        return map;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
