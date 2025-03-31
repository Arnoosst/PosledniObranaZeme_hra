package Game.Items;

/**
 * Represents a weapon item that extends Item.
 * This class adds a damage increase.
 */
public class Weapon extends Item {
    private int damageIncrease;


    public Weapon(String itemName, int itemID,int damageIncrease, int itemPrice) {
        super(itemName, itemID, itemPrice);
        this.damageIncrease = damageIncrease;
    }


    public int getDamageIncrease() {
        return damageIncrease;
    }
}
