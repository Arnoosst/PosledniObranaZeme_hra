package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Command.Move;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MoveTest {

    private Move move;
    private World world;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        world = new World();
        move = new Move(scanner);
    }

    @Test
    void testOfPlanetWithoutSpecalItem() {

        World.setKillCount(0);
        World.setCurrentLocation(1);


        World.setOxygen(true);


        scanner = new Scanner(new ByteArrayInputStream("5\n".getBytes()));
        Move move = new Move(scanner);


        String result = move.execute();


        assertEquals("Přistál jsi na planetě " + World.getMap().get(5).getName() + "!", result);
    }



   @Test
    void testLandOnPLanet() {
       World.setKillCount(0);
       World.setCurrentLocation(1);

        scanner = new Scanner(new ByteArrayInputStream("2\n".getBytes()));
        Move move = new Move(scanner);

        String result = move.execute();

        assertEquals("Přistál jsi na planetě " + World.getMap().get(2).getName() + "!", result);
    }

    @Test
    void testMoveToFinalPlanetWithoutDefeatingBosses() {
        World.setCurrentLocation(1);
        World.setKillCount(3);

        scanner = new Scanner(new ByteArrayInputStream("8\n".getBytes()));
        Move move = new Move(scanner);

        String result = move.execute();

        assertEquals("Musíš porazit všechny bosse, než se dostaneš na finální planetu!", result);
    }


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