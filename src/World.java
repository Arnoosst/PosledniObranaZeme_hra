import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class World {
    private static HashMap<Integer, Location> map = new HashMap<>();


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
}
