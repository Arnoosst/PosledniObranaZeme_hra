package Game.Items;

public class Medkit extends Item {
    private int healthIncrease;

    public Medkit(String itemName, int healthIncrease) {
        super(itemName);
        this.healthIncrease = healthIncrease;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

    public void setHealthIncrease(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }
}
