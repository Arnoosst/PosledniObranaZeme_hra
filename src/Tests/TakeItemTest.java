package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.TakeItem;
import Game.Items.Inventory;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for the TakeItem class.
 * This class verifies that the take item is working correctly
 * when  weapon, medkit is picked up
 *
 * @author Vojtěch Malínek
 */
public class TakeItemTest {

    private World world;
    private Inventory inventory;
    private TakeItem takeItem;


    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void setUp() {
        world = new World();
        inventory = new Inventory();
        takeItem = new TakeItem(world, inventory);
    }


    /**
     * Tests if a weapon is correctly picked up to an inventory and removed from the world.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testTakeWeapon() {
        Weapon weapon = new Weapon("Sword", 1, 10, 5);
        world.getWeapons().add(weapon);

        String result = takeItem.execute();

        assertTrue(inventory.getInventory().contains(weapon));
        assertEquals("Našel jsi zbraň: Sword!", result);
        assertFalse(world.getWeapons().contains(weapon));
    }


    /**
     * Tests if a medkit is correctly picked up to an inventory and removed from the world.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testTakeMedkit() {
        Medkit medkit = new Medkit("Medkit", 1, 30, 20);
        world.getMedkits().add(medkit);

        String result = takeItem.execute();


        assertTrue(inventory.getInventory().contains(medkit));
        assertEquals("Vzal jsi si medkit!", result);
        assertFalse(world.getMedkits().contains(medkit));
    }


    /**
     * Tests when no items are found to take.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void testNoItemsFound() {
        String result = takeItem.execute();

        assertEquals("🔍 Nic tu není!", result);
    }
}
