package Items;

public class Weapon extends Item {
    public int damageIncrease;


    public Weapon(String itemName, int damageIncrease) {
        super(itemName);
        this.damageIncrease = damageIncrease;
    }

    public int getDamageIncrease() {
        return damageIncrease;
    }

    public void setDamageIncrease(int damageIncrease) {
        this.damageIncrease = damageIncrease;
    }
}
