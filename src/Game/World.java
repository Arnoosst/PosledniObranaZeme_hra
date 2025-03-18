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
    private static HashMap<Integer, Location> map = new HashMap<>();
    private static ArrayList<Entity> enemy = new ArrayList<>();
    private static HashMap<Integer, Entity> npc = new HashMap<>();
    private static ArrayList<Item> weapons = new ArrayList<>();
    private static ArrayList<Item> medkits = new ArrayList<>();
    private static int currentLocation = 1;

    public  World() {
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


    public static void removeEnemyFromLocation(Enemy en) {
        for (int i = 0; i < enemy.size(); i++) {
            if (enemy.get(i).getId() == en.getId()) {
                enemy.remove(i);
                System.out.println("Nepřítel odstraněn z lokace.");
                break;
            }
        }
    }




    public static int getCurrentLocation() {
        return currentLocation;
    }

    public static HashMap<Integer, Location> getMap() {
        return map;
    }


    public static ArrayList<Entity> getEnemy() {
        return enemy;
    }

    public static HashMap<Integer, Entity> getNpc() {
        return npc;
    }

    public static ArrayList<Item> getWeapons() {
        return weapons;
    }

    public static ArrayList<Item> getMedkits() {
        return medkits;
    }
}
