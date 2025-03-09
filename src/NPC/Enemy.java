package NPC;

public class Enemy extends Entity {
    private int health;
    private int power;

    public Enemy(String name, int id, String speach, int health, int power) {
        super(name, id, speach);
        this.health = health;
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
