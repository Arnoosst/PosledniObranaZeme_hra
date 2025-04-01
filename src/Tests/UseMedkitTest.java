package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.UseMedkit;
import Game.Items.Inventory;
import Game.Items.Medkit;
import Game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


/**
 * Unit tests for the UseMedkit command class.
 * This class verifies that the using of a medkit works correctly,
 * health recovery and the removal of the medkit from the inventory.
 *
 * @author Vojtěch Malínek
 */
class UseMedkitTest {

    private Inventory inventory;
    private Player player;
    private UseMedkit useMedkit;


    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void init() {
        inventory = new Inventory();
        player = new Player();
        player.setHealth(100);
        useMedkit = new UseMedkit(inventory, player);
    }

    /**
     * Tests if a medkit is correctly used from the inventory when it exists.
     * The player's health increased and the medkit is removed from the inventory.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void executeMedkitExists() {
        Medkit medkit = new Medkit("Medkit", 1, 30, 20);
        inventory.getInventory().add(medkit);

        String result = useMedkit.execute();

        assertEquals("Použil jsi medkit! Zdraví obnoveno o 30 HP.", result);
        assertEquals(130, player.getHealth());
        assertTrue(inventory.getInventory().isEmpty());
    }


    /**
     * Tests when no medkit is available in the inventory.
     * The player should receive a message saying that no medkit is available.
     *
     * @author Vojtěch Malínek
     */
    @Test
    void executeNoMedkit() {
        String result = useMedkit.execute();
        assertEquals("Žádný medkit v inventáři! Najdi nebo kup nový.", result);
        assertEquals(100, player.getHealth());
    }


}
