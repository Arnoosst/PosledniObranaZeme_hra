package Game.NPC;

public class Enemy extends Entity {
    private int health;
    private int damage;

    public Enemy(String speach, String name, int id, int health, int damage) {
        super(speach, name, id);
        this.health = health;
        this.damage = damage;
    }

    public int takeDamage(int damage) {
        health = health - damage;
        return health;
    }

    public int getHealth() {
        return health;
    }


    public int getDamage() {
        return damage;
    }

}
