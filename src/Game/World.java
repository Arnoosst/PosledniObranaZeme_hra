package Game;

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

public abstract class  World {
    private static HashMap<Integer, Location> map = new HashMap<>();
    private static HashMap<Integer, Entity> enemy = new HashMap<>();
    private static HashMap<Integer, Entity> npc = new HashMap<>();
    private static ArrayList<Item> weapons = new ArrayList<>();
    private static ArrayList<Item> medkits = new ArrayList<>();
    private static int currentLocation = 1;

    public static void loadMap(String soubor) {
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

    public static void loadWeapons(String soubor) {
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

    public static void loadMedKits(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int health = Integer.parseInt(parts[1]);
                medkits.add(new Medkit(id, health));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void loadEnemy(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int health = Integer.parseInt(parts[2]);
                String speech = parts[3];
                int damage = Integer.parseInt(parts[4]);
                enemy.put(id, new Enemy(speech, name, id, health, damage));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void loadNpc(String soubor) {
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


    public static int getCurrentLocation() {
        return currentLocation;
    }

    public static HashMap<Integer, Location> getMap() {
        return map;
    }


}
