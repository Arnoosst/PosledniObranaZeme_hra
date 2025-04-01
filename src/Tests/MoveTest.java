package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.Move;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


/**
 * Unit tests for the Move class.
 * This class verifies different movement scenarios within the game,
 * valid moves, restricted moves
 *
 * @author Vojtěch Malínek
 */
public class MoveTest {

    private Move move;
    private World world;
    private Scanner scanner;


    /**
     * Sets up the necessary objects before each test case.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void setUp() {
        world = new World();
        move = new Move(scanner);
    }


    /**
     * Tests movement to a planet with a special item.
     *
     * @author chatGPT (For assistance with line 56 and 57 with loading scanner input for planet 5)
     * @author Vojtěch Malínek
     */
    @Test
    void testOfPlanetWithSpecalItem() {

        World.setKillCount(0);
        World.setCurrentLocation(1);


        World.setOxygen(true);


        scanner = new Scanner(new ByteArrayInputStream("5\n".getBytes()));
        Move move = new Move(scanner);


        String result = move.execute();


        assertEquals("Přistál jsi na planetě " + World.getMap().get(5).getName() + "!", result);
    }


    /**
     * Tests movement to a planet without requiring a special item.
     *
     * @author Vojtěch Malínek
     * @author chatGPT (For assistance with line 83 and 84 with loading scanner input for planet 5)
     */
    @Test
    void testOfPlanetWithoutSpecalItem() {

        World.setKillCount(0);
        World.setCurrentLocation(1);


        World.setOxygen(false);


        scanner = new Scanner(new ByteArrayInputStream("5\n".getBytes()));
        Move move = new Move(scanner);


        String result = move.execute();


        assertEquals("Potřebuješ kyslíkovou nádrž, abys přežil na Titanu!", result);
    }


    /**
     * Tests standard movement to another planet.
     *
     * @author chatGPT (For assistance with line 104 and 105 with loading scanner input for planet 2)
     * @author Vojtěch Malínek
     */
   @Test
    void testLandOnPLanet() {
       World.setKillCount(0);
       World.setCurrentLocation(1);

        scanner = new Scanner(new ByteArrayInputStream("2\n".getBytes()));
        Move move = new Move(scanner);

        String result = move.execute();

        assertEquals("Přistál jsi na planetě " + World.getMap().get(2).getName() + "!", result);
    }


    /**
     * Tests if the player is not able to move to the final planet without defeating bosses.
     *
     * @author chatGPT (For assistance with line 125 and 126 with loading scanner input for planet 8)
     * @author Vojtěch Malínek
     */
    @Test
    void testMoveToFinalPlanetWithoutDefeatingBosses() {
        World.setCurrentLocation(1);
        World.setKillCount(3);

        scanner = new Scanner(new ByteArrayInputStream("8\n".getBytes()));
        Move move = new Move(scanner);

        String result = move.execute();

        assertEquals("Musíš porazit všechny bosse, než se dostaneš na finální planetu!", result);
    }


    /**
     * Tests if the player can move to the final planet after defeating all required bosses.
     *
     * @author chatGPT (For assistance with line 145 and 146 with loading scanner input for planet 8)
     * @author Vojtěch Malínek
     */
    @Test
    void testMoveToFinalPlanetWithDefeatingBosses() {
        World.setCurrentLocation(1);
        World.setKillCount(6);

        scanner = new Scanner(new ByteArrayInputStream("8\n".getBytes()));
        Move move = new Move(scanner);

        String result = move.execute();

        assertEquals("Přistál jsi na lodi Archona Xar'quna.", result);
    }


}