package Game;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Weapon;

/**
 * Represents a player in the game.
 */
public class Player {
    private int health;
    private int damage;

    /**
     * Initializes a new player with default health and damage values.
     */
    public Player() {
        this.health = 100;
        this.damage = 15;
    }

    /**
     * Calculates the total damage increase from the player's inventory.
     *
     * @param inventory The player's inventory containing weapons.
     * @return The total additional damage from equipped weapons.
     */
    public int damageIncrease(Inventory inventory) {
        int damageIncrease = 0;
        for (Item item : inventory.getInventory()) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                damageIncrease += weapon.getDamageIncrease();
            }
        }
        return damageIncrease;
    }

    /**
     * Reduces the player's health by the given damage amount.
     *
     * @param damage The amount of damage taken.
     * @return The player's remaining health.
     */
    public int takeDamage(int damage) {
        health = health - damage;
        return health;
    }

    /**
     * Calculates the total damage the player can deal.
     *
     * @param damageIncrease The additional damage from weapons.
     * @return The total damage the player deals.
     */
    public int giveDamage(int damageIncrease) {
        return damage + damageIncrease;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
