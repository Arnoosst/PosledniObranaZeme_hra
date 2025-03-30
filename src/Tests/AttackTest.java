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
        World.setCurrentLocation(2);

        Enemy enemy = world.returnenemyInLocation();
        world.removeEnemyFromLocation(enemy);


        String result = attack.execute();
        assertEquals("Žádný nepřítel v této lokaci.", result);
    }


   @Test
    public void testEnemyDefeated() {

        Enemy enemy = new Enemy("a", "Test Enemy", 9, 10, 10);
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
    @Test
    public void testPlayerDefeated() {

        Enemy enemy = new Enemy("b", "Test Enemy", 9, 1000, 10000);
        world.getEnemy().addLast(enemy);
        World.setCurrentLocation(9);
        player.setHealth(1);

        String result = attack.execute();

        assertTrue(result.contains("💀 Hráč poražen!"));
    }

   @Test
    public void testItemsAfterBossDefeated() {


        player.setHealth(10000);
        World.setCurrentLocation(4);
        String result = attack.execute();

        assertTrue(result.contains("Získal jsi OXYGEN TANK!"));
    }


    @Test
    public void testNoItemFromBossIfNotRightLocation() {

        player.setHealth(10000);
        World.setCurrentLocation(2);
        String result = attack.execute();

        assertFalse(result.contains("Získal jsi UNDERWATER SUIT!"));
    }
}
