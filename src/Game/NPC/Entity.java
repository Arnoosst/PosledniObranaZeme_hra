package Game.NPC;

/**
 * Represents entity with a name, id and speech.
 * This class is a base for other types of entities.
 *
 * @author Vojtěch Malínek
 */
public class Entity {
    private String name;
    private int id;
    private String speach;

    public Entity(String speach, String name, int id) {
        this.speach = speach;
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeach() {
        return speach;
    }


}
