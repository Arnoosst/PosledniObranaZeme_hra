package Game.Items;

public class Medkit extends Item {
    private int healthIncrease;


    public Medkit(String itemName, int itemID, int healthIncrease) {
        super(itemName, itemID);
        this.healthIncrease = healthIncrease;
    }

    public Medkit(int itemID, int healthIncrease) {
        super(itemID);
        this.healthIncrease = healthIncrease;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

    public void setHealthIncrease(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }
}
