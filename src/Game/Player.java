package Game;

public class Player {
    private  int health;
    private  int damage;

    public Player() {
        this.health = 100;
        this.damage = 15;
    }

    public  int takeDamage(int damage) {
        health = health - damage;
        return health;
    }

    public  int giveDamage(int damageIncrease) {
        damage = damage + damageIncrease;
        return damage;
    }

    public  int getHealth() {
        return health;
    }

    public  void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

}
