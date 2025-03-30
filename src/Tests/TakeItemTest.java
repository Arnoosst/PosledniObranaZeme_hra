package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.TakeItem;
import Game.Items.Inventory;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TakeItemTest {

    private World world;
    private Inventory inventory;
    private TakeItem takeItem;

    @BeforeEach
    void setUp() {
        world = new World();
        inventory = new Inventory();
        takeItem = new TakeItem(world, inventory);
    }

    @Test
    void testTakeWeapon() {
        Weapon weapon = new Weapon("Sword", 1, 10, 5);
        world.getWeapons().add(weapon);

        String result = takeItem.execute();

        assertTrue(inventory.getInventory().contains(weapon));
        assertEquals("Našel jsi zbraň: Sword!", result);
        assertFalse(world.getWeapons().contains(weapon));
    }

    @Test
    void testTakeMedkit() {
        Medkit medkit = new Medkit("Medkit", 1, 30, 20);
        world.getMedkits().add(medkit);

        String result = takeItem.execute();


        assertTrue(inventory.getInventory().contains(medkit));
        assertEquals("Vzal jsi si medkit!", result);
        assertFalse(world.getMedkits().contains(medkit));
    }

    @Test
    void testNoItemsFound() {
        String result = takeItem.execute();

        assertEquals("🔍 Nic tu není!", result);
    }
}
