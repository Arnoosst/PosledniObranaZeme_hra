package Game;

import Game.Items.*;
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
    private static HashMap<Integer, Location> map = new HashMap<>();
    private  ArrayList<Entity> enemy = new ArrayList<>();
    private  ArrayList<Entity> npc = new ArrayList<>();
    private  ArrayList<Item> weapons = new ArrayList<>();
    private  ArrayList<Item> medkits = new ArrayList<>();
    private  ArrayList<Item> crates = new ArrayList<>();
    private static int currentLocation = 1;
    private static int killCount = 0;
    private static Boolean oxygen = false;
    private static Boolean underWaterSuit = false;

    public  World() {
        loadMap();
        loadEnemy();
        loadMedKits();
        loadWeapons();
        loadNpc();
    }



    public  void loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
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

    public  void loadWeapons() {
        try (BufferedReader br = new BufferedReader(new FileReader("weapon.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int damage = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                weapons.add(new Weapon(name, id, damage, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadMedKits() {
        try (BufferedReader br = new BufferedReader(new FileReader("medkits.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int health = Integer.parseInt(parts[1]);
                String name = parts[2];
                int price = Integer.parseInt(parts[3]);
                medkits.add(new Medkit(name, id, health, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadEnemy() {
        try (BufferedReader br = new BufferedReader(new FileReader("enemy.txt"))) {
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

    public  void loadNpc() {
        try (BufferedReader br = new BufferedReader(new FileReader("npc.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String speech = parts[2];

                npc.add(new FriendlyFoe(speech, name, id));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void loadCrates() {
        try (BufferedReader br = new BufferedReader(new FileReader("crates.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[2];
                int price = Integer.parseInt(parts[3]);
                crates.add(new Crates(name, id, price));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static boolean moveTo(int location) {
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


    public  void removeEnemyFromLocation(Enemy en) {
        for (int i = 0; i < enemy.size(); i++) {
            if (enemy.get(i).getId() == en.getId()) {
                killCount++;
                enemy.remove(i);
                break;
            }
        }
    }

    public Enemy returnenemyInLocation() {

        for (Entity en : enemy) {

            if (currentLocation == en.getId()) {
                return (Enemy) en;
            }
        }

        return null;
    }


    public ArrayList<Item> getCrates() {
        return crates;
    }

    public static int getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(int currentLocation) {
        World.currentLocation = currentLocation;
    }

    public ArrayList<Item> getMedkits() {
        return medkits;
    }


    public ArrayList<Item> getWeapons() {
        return weapons;
    }


    public ArrayList<Entity> getNpc() {
        return npc;
    }


    public static HashMap<Integer, Location> getMap() {
        return map;
    }


    public static int getKillCount() {
        return killCount;
    }


    public static Boolean getOxygen() {
        return oxygen;
    }

    public static void setOxygen(Boolean oxygen) {
        World.oxygen = oxygen;
    }

    public static Boolean getUnderWaterSuit() {
        return underWaterSuit;
    }

    public static void setUnderWaterSuit(Boolean underWaterSuit) {
        World.underWaterSuit = underWaterSuit;
    }

    public static void setMap(HashMap<Integer, Location> map) {
        World.map = map;
    }

    public ArrayList<Entity> getEnemy() {
        return enemy;
    }

    public void setEnemy(ArrayList<Entity> enemy) {
        this.enemy = enemy;
    }

    public void setNpc(ArrayList<Entity> npc) {
        this.npc = npc;
    }

    public void setWeapons(ArrayList<Item> weapons) {
        this.weapons = weapons;
    }

    public void setMedkits(ArrayList<Item> medkits) {
        this.medkits = medkits;
    }

    public void setCrates(ArrayList<Item> crates) {
        this.crates = crates;
    }

    public static void setKillCount(int killCount) {
        World.killCount = killCount;
    }
}
