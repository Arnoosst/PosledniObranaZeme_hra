package Game.Items;

public class Weapon extends Item {
    public int damageIncrease;


    public Weapon(String itemName, int itemID, int damageIncrease) {
        super(itemName, itemID);
        this.damageIncrease = damageIncrease;
    }

    public int getDamageIncrease() {
        return damageIncrease;
    }

    public void setDamageIncrease(int damageIncrease) {
        this.damageIncrease = damageIncrease;
    }
}
