package Game;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Weapon;

public class Player {
    private  int health;
    private  int damage;

    public Player() {
        this.health = 100;
        this.damage = 15;
    }

    // instanceof jsem si nechal poradit od chatgpt
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

    public  int takeDamage(int damage) {
        health = health - damage;
        return health;
    }

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

}
