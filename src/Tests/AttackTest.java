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


/**
 * Unit tests for the Attack command in the game.
 * This class tests different scenarios related to combat mechanics,
 * fighting enemies, player defeat, enemy defeat.
 *
 * @author Vojtěch Malínek
 */
public class AttackTest {

    private Player player;
    private Inventory inventory;
    private World world;
    private Attack attack;
    private GamePrints gamePrints;


    /**
     * Sets up the objects before each test.
     *
     * @author Vojtěch Malínek
     */
    @BeforeEach
    void setUp() {
        world = new World();
        player = new Player();
        inventory = new Inventory();
        gamePrints = new GamePrints();
        attack = new Attack(world, player, inventory, gamePrints);
    }


    /**
     * Tests if the attack command is correctly returning,
     * when there is no enemy in the current location.
     *
     * @author Vojtěch Malínek
     */
   @Test
    public void testNoEnemyInLocation() {
        World.setCurrentLocation(2);

        Enemy enemy = world.returnenemyInLocation();
        world.removeEnemyFromLocation(enemy);


        String result = attack.execute();
        assertEquals("Žádný nepřítel v této lokaci.", result);
    }


    /**
     * Tests if an enemy is correctly defeated.
     *
     * @author Vojtěch Malínek
     */
   @Test
    public void testEnemyDefeated() {

        Enemy enemy = new Enemy("a", "Test Enemy", 9, 10, 10, 100);
        world.getEnemy().add(enemy);
        World.setCurrentLocation(9);

        String result = attack.execute();

        assertTrue(result.contains("Nepřítel poražen. Získáváš respekt vesmíru!"));
    }




     /* Tento test funguje jen se musi upravit command attack, pokud hrac umre a to takto

      71            if (player.getHealth() <= 0) {
      72            return "💀 Hráč poražen!";
      73            //gamePrints.loadLoseGame();
      74            //System.exit(0);
      75            }

     */


    /**
     * Tests if the player is defeated.
     * Requires modification of the Attack command to return a message instead of exiting the game.
     *
     *
     * Tento test funguje jen se musi upravit command attack, pokud hrac umre a to takto
     *
     *       71            if (player.getHealth() <= 0) {
     *       72            return "💀 Hráč poražen!";
     *       73            //gamePrints.loadLoseGame();
     *       74            //System.exit(0);
     *       75            }
     *
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testPlayerDefeated() {

        Enemy enemy = new Enemy("b", "Test Enemy", 9, 1000, 10000, 100);
        world.getEnemy().addLast(enemy);
        World.setCurrentLocation(9);
        player.setHealth(1);

        String result = attack.execute();

        assertTrue(result.contains("💀 Hráč poražen!"));
    }


    /**
     * Tests if the player receives the Oxygen Tank after defeating the boss in the correct location.
     *
     * @author Vojtěch Malínek
     */
   @Test
    public void testItemsAfterBossDefeated() {


        player.setHealth(10000);
        World.setCurrentLocation(4);
        String result = attack.execute();

        assertTrue(result.contains("Získal jsi OXYGEN TANK!"));
    }



    /**
     * Tests if no special item is given when defeating a boss outside the designated location.
     *
     * @author Vojtěch Malínek
     */
    @Test
    public void testNoItemFromBossIfNotRightLocation() {

        player.setHealth(10000);
        World.setCurrentLocation(2);
        String result = attack.execute();

        assertFalse(result.contains("Získal jsi UNDERWATER SUIT!"));
    }
}
