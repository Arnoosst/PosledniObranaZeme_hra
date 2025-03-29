package Tests;
import Game.Command.Attack;
import Game.GamePrints;
import Game.Items.Inventory;
import Game.NPC.Enemy;
import Game.Player;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttackTest {

    private Player player;
    private Inventory inventory;
    private World world;
    private Attack attack;
    private GamePrints gamePrints;

    @BeforeEach
    void setUp() {
        world = new World();
        player = new Player();
        inventory = new Inventory();
        gamePrints = new GamePrints();
        attack = new Attack(world, player, inventory, gamePrints);
    }

    @Test
    public void testNoEnemyInLocation() {

        world.getEnemy().remove(world.getEnemy().get(0));
        World.setCurrentLocation(2);
        String result = attack.execute();

        assertEquals("Žádný nepřítel v této lokaci.", result);
    }


    @Test
    public void testEnemyDefeated() {

        Enemy enemy = new Enemy("dd", "Test Enemy", 9, 10, 10);
        world.getEnemy().add(enemy);

        World.setCurrentLocation(9);
        enemy.takeDamage(player.giveDamage(player.damageIncrease(inventory)));

        String result = attack.execute();

        assertTrue(result.contains("Nepřítel poražen"));
    }

    @Test
    public void testPlayerDefeated() {

        Enemy enemy = new Enemy("dd", "Test Enemy", 10, 1000, 10000);
        world.getEnemy().add(enemy);
        World.setCurrentLocation(10);


        String result = attack.execute();

        assertTrue(result.contains("💀 Hráč poražen!"));
    }

    @Test
    public void testItemsAfterBossDefeated() {



        World.setCurrentLocation(4);
        String result = attack.execute();

        assertTrue(result.contains("Získal jsi OXYGEN TANK"));
    }


    @Test
    public void testNoItemFromBossIfNotRightLocation() {

        World.setCurrentLocation(5);
        String result = attack.execute();

        assertFalse(result.contains("Získal jsi OXYGEN TANK"));
    }
}
