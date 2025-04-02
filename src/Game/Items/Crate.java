package Game.Items;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public boolean setGemStone(GemStone gemStone) {
        if(gemStone == null){
            return false;
        }else {
            this.gemStone = gemStone;
            return true;
        }
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
