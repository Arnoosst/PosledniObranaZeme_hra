package Tests;

import Game.Items.Inventory;
import Game.Items.Weapon;
import Game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit tests for the Player class methods related to damage,
 *  damage increase, giving damage, and taking damage.
 *
 * @author Vojtěch Malínek
 */
public class PlayerDamageTest {

    private Player player;
    private Inventory inventory;


    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        player = new Player();
    }


    /**
     * Tests the damage increase calculation when a weapon is added to the player's inventory.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testOfDamageIncrease() {
        Weapon weapon = new Weapon("a", 1,20,10);
        inventory.addItem(weapon);
        player.setDamage(10);

        int damageIncrease = player.damageIncrease(inventory) + player.getDamage();

        assertEquals(30, damageIncrease);
    }


    /**
     * Tests the total damage given by the player after adding damage increase.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testOfGiveDamage() {
        Weapon weapon = new Weapon("a", 1,20,10);
        inventory.addItem(weapon);
        player.setDamage(10);

        int damageIncrease = player.damageIncrease(inventory);
        int damage = player.giveDamage(damageIncrease);

        assertEquals(30, damage);
    }



    /**
     * Tests the player's health after taking damage.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testOfTakeDamage() {
        player.setDamage(100);

        int healthAfterDamage = player.takeDamage(10);

        assertEquals(90, healthAfterDamage);
    }

}
