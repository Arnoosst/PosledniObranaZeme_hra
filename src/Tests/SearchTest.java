package Tests;

import Game.Command.Search;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.NPC.FriendlyFoe;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    private World world;
    private Search search;

    @BeforeEach
    void setUp() {
        world = new World();
        search = new Search(world);
    }

    @Test
    public void testFindMedkit() {
        Medkit medkit = new Medkit("Test Medkit", 1, 50, 10);
        world.getMedkits().addFirst(medkit);
        World.setCurrentLocation(1);

        String result = search.execute();
        assertTrue(result.contains("Našel jsi Medkit!"));
    }

    @Test
    public void testFindWeapon() {
        Weapon weapon = new Weapon("Test Zbraň", 1, 30, 20);
        world.getWeapons().addFirst(weapon);
        World.setCurrentLocation(1);

        String result = search.execute();
        assertTrue(result.contains("Našel jsi zbraň!"));
    }

    @Test
    public void testFindNPC() {
        FriendlyFoe npc = new FriendlyFoe("a", "npc", 9);
        world.getNpc().addLast(npc);
        World.setCurrentLocation(9);

        String result = search.execute();
        assertTrue(result.contains("Narazil jsi na přeživšího!"));
    }

    @Test
    public void testFindNothing() {
        World.setCurrentLocation(10);
        String result = search.execute();
        assertEquals("Nic jsi nenašel!", result);
    }
}
