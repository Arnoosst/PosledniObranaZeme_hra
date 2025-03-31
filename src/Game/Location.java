package Game;

import java.util.ArrayList;

public class Location {
    private int id;
    private String name;
    private ArrayList<Integer> neighbor ;

    public Location(int id, String name, ArrayList<Integer> neighbor ) {
        this.id = id;
        this.name = name;
        this.neighbor  = neighbor ;
    }


    public ArrayList<Integer> getNeighbor() {
        return neighbor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return id + "."+ name ;
    }
}