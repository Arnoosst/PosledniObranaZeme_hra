package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.Move;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class MoveTest {

    private Move move;
    private World world;

    @BeforeEach
    void setUp() {
        world = new World();
        move = new Move();
    }

    @Test
    void testInvalidPlanet() {

        String simulatedInput = "10\n";
        Scanner scanner = new Scanner(simulatedInput);
        //System.setIn(scanner);

        String result = move.execute();

        assertEquals("Tahle planeta neexistuje, zkus to znovu:", result);
    }

    @Test
    void testMoveToFinalPlanetWithoutDefeatingBosses() {

        World.setKillCount(3);

        String simulatedInput = "8\n";
        Scanner scanner = new Scanner(simulatedInput);
        //System.setIn(scanner);

        String result = move.execute();

        assertEquals("Musíš porazit všechny bosse, než se dostaneš na finální planetu!", result);
    }
}