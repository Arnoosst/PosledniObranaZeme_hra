package Game.Items;

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
