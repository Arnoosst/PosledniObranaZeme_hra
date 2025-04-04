package Game.Items;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Represents a crate that is an unmovable object in the world.
 * The crate can be opened, and it will give to the player a gemstone.
 *
 * @author Vojtěch Malínek
 */
public class Crate {
    private GemStone gemStone;
    private boolean found;
    private int planetID;
    private String name;


    public Crate(int planetID, String name) {
        this.found = false;
        this.planetID = planetID;
        this.name = name;
    }



    public GemStone getGemStone() {
        return gemStone;
    }

    public void setGemStone(GemStone gemStone) {
        this.gemStone = gemStone;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getPlanetID() {
        return planetID;
    }

    public void setPlanetID(int planetID) {
        this.planetID = planetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
