package Tests;

import Game.Command.Search;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.NPC.FriendlyFoe;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Search command class.
 * This class test that the search is correctly identifying
 * when a medkit, weapon, NPC, or nothing is found.
 *
 * @author Vojtěch Malínek
 */
public class SearchTest {

    private World world;
    private Search search;

    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void setUp() {
        world = new World();
        search = new Search(world);
    }

    /**
     * Tests if a medkit is correctly found.
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testFindMedkit() {
        Medkit medkit = new Medkit("Test Medkit", 1, 50, 10);
        world.getMedkits().addFirst(medkit);
        World.setCurrentLocation(1);

        String result = search.execute();
        assertTrue(result.contains("Našel jsi Medkit!"));
    }


    /**
     * Tests if a weapon is correctly found.
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testFindWeapon() {
        Weapon weapon = new Weapon("Test Zbraň", 1, 30, 20);
        world.getWeapons().addFirst(weapon);
        World.setCurrentLocation(1);

        String result = search.execute();
        assertTrue(result.contains("Našel jsi zbraň!"));
    }


    /**
     * Tests if an NPC is correctly found.
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testFindNPC() {
        FriendlyFoe npc = new FriendlyFoe("a", "npc", 9);
        world.getNpc().addLast(npc);
        World.setCurrentLocation(9);

        String result = search.execute();
        assertTrue(result.contains("Narazil jsi na přeživšího!"));
    }


    /**
     * Tests if no items are found.
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testFindNothing() {
        World.setCurrentLocation(10);
        String result = search.execute();
        assertEquals("Nic jsi nenašel!", result);
    }
}
