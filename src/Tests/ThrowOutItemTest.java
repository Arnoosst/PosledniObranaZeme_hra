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

class ThrowOutItemTest {

    private Inventory inventory;
    private World world;
    private ThrowOutItem throwOutItem;
    private Scanner scanner;

    @BeforeEach
    void init() {
        inventory = new Inventory();
        world = new World();
    }


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
