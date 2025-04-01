package Game.Items;

/**
 * Represents a medkit item that extends Item.
 * This class adds a health increase.
 *
 * @author Vojtěch Malínek
 */
public class Medkit extends Item {
    private int healthIncrease;


    public Medkit(String itemName, int itemID, int healthIncrease, int itemPrice) {
        super(itemName, itemID, itemPrice);
        this.healthIncrease = healthIncrease;
    }


    public int getHealthIncrease() {
        return healthIncrease;
    }
}
