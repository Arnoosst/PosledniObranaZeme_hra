package Game.NPC;


/**
 * Represents an enemy that extends Entity
 * This class adds a health and damage
 *
 * @author Vojtěch Malínek
 */
public class Enemy extends Entity {
    private int health;
    private int damage;
    private int coinPrice;

    /**
     * Creates an enemy entity with the specified speech, name, and ID, health and damage.
     *
     * @author Vojtěch Malínek
     */
    public Enemy(String speach, String name, int id, int health, int damage, int coinPrice) {
        super(speach, name, id);
        this.health = health;
        this.damage = damage;
        this.coinPrice = coinPrice;
    }


    /**
     * Reduces the enemy's health by the specified amount of damage.
     *
     * @author Vojtěch Malínek
     * @param damage the amount of damage taken by a player.
     * @return the remaining health of the enemy after taking damage.
     */
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

    public int getCoinPrice() {
        return coinPrice;
    }
}
