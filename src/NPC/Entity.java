package NPC;

public class Entity {
    private String name;
    private int id;
    private String speach;

    public Entity(String name, int id, String speach) {
        this.name = name;
        this.id = id;
        this.speach = speach;
    }

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setSpeach(String speach) {
        this.speach = speach;
    }
}
