package Tests;
import static org.junit.jupiter.api.Assertions.*;

import Game.Command.ThrowOutItem;
import Game.Items.Inventory;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;



/**
 * Unit tests for the ThrowOutItem command class.
 * This class verifies that the items are correctly of removed
 *
 * @author Vojtěch Malínek
 */
class ThrowOutItemTest {

    private Inventory inventory;
    private World world;
    private ThrowOutItem throwOutItem;
    private Scanner scanner;


    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void init() {
        inventory = new Inventory();
        world = new World();
    }



    /**
     * Tests if a medkit is correctly removed from the inventory.
     *
     * @author chatGPT (For assistance with line 55 and 56 with loading scanner input for item with id 1)
     * @author Vojtěch Malínek
     */
    @Test
    void executeRemoveMedkit() {
        Medkit medkit = new Medkit("Medkit", 1, 30, 20);
        inventory.getInventory().add(medkit);

        scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        ThrowOutItem throwOutItem = new ThrowOutItem(inventory, world, scanner);

        String result = throwOutItem.execute();
        assertEquals("Předmět Medkit (ID: 1) byl odstraněn z inventáře.", result);
        assertFalse(inventory.getInventory().contains(medkit));
    }


    /**
     * Tests if a weapon is correctly removed from the inventory.
     *
     * @author chatGPT (For assistance with line 75 and 76 with loading scanner input for item with id 2)
     * @author Vojtěch Malínek
     */
    @Test
    void executeRemoveWeapon() {
        Weapon weapon = new Weapon("Weapon", 2,20, 10);
        inventory.getInventory().add(weapon);

        scanner = new Scanner(new ByteArrayInputStream("2\n".getBytes()));
        ThrowOutItem throwOutItem = new ThrowOutItem(inventory, world, scanner);

        String result = throwOutItem.execute();
        assertEquals("Předmět Weapon (ID: 2) byl odstraněn z inventáře.", result);
        assertFalse(inventory.getInventory().contains(weapon));
    }

}
