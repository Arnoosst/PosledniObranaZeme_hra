package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.UseMedkit;
import Game.Items.Inventory;
import Game.Items.Medkit;
import Game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UseMedkitTest {

    private Inventory inventory;
    private Player player;
    private UseMedkit useMedkit;

    @BeforeEach
    void init() {
        inventory = new Inventory();
        player = new Player();
        player.setHealth(100);
        useMedkit = new UseMedkit(inventory, player);
    }

    @Test
    void executeMedkitExists() {
        Medkit medkit = new Medkit("Medkit", 1, 30, 20);
        inventory.getInventory().add(medkit);

        String result = useMedkit.execute();

        assertEquals("Použil jsi medkit! Zdraví obnoveno o 30 HP.", result);
        assertEquals(130, player.getHealth());
        assertTrue(inventory.getInventory().isEmpty());
    }

    @Test
    void executeNoMedkit() {
        String result = useMedkit.execute();
        assertEquals("Žádný medkit v inventáři! Najdi nebo kup nový.", result);
        assertEquals(100, player.getHealth());
    }


    @Test
    void testExit() {
        assertFalse(useMedkit.exit());
    }
}
