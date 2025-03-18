package Game;

public class Player {
    private static int health;
    private static int damage;

    public Player(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public static int takeDamage(int damage) {
        health = health - damage;
        return health;
    }

    public static int giveDamage(int damageIncrease) {
        damage = damage + damageIncrease;
        return damage;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
