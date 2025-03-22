package Game.Items;

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
