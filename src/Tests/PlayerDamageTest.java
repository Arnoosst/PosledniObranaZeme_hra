package Tests;

import Game.Items.Inventory;
import Game.Items.Weapon;
import Game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerDamageTest {

    private Player player;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        player = new Player();
    }

    @Test
    void testOfDamageIncrease() {
        Weapon weapon = new Weapon("a", 1,20,10);
        inventory.addItem(weapon);
        player.setDamage(10);

        int damageIncrease = player.damageIncrease(inventory) + player.getDamage();

        assertEquals(30, damageIncrease);
    }


    @Test
    void testOfGiveDamage() {
        Weapon weapon = new Weapon("a", 1,20,10);
        inventory.addItem(weapon);
        player.setDamage(10);

        int damageIncrease = player.damageIncrease(inventory);
        int damage = player.giveDamage(damageIncrease);

        assertEquals(30, damage);
    }

    @Test
    void testOfTakeDamage() {
        player.setDamage(100);

        int healthAfterDamage = player.takeDamage(10);

        assertEquals(90, healthAfterDamage);
    }

}
