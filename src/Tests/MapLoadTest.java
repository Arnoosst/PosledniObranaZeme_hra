package Tests;

import Game.Command.Move;
import Game.Items.Medkit;
import Game.Items.Weapon;
import Game.Location;
import Game.NPC.Enemy;
import Game.NPC.FriendlyFoe;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class MapLoadTest {

    private World world;


    @BeforeEach
    void setUp() {
        world = new World();
    }

    @Test
    public void testLoadMap() {

        assertNotNull(World.getMap());

        Location location = World.getMap().get(1);
        assertNotNull(location, "Lokace s ID 1 existuje");
        assertEquals("Zeme", location.getName(), "ma to byt zeme");
    }

    @Test
    public void testLoadWeapons() {

        assertNotNull(world.getWeapons());

        Weapon weapon = (Weapon) world.getWeapons().get(0);
        assertNotNull(weapon, "První zbraň ma existovat.");
        assertEquals("Laserová pistole", weapon.getItemName(), "Název první zbraně by měl být Laserová pistole.");
    }

    @Test
    public void testLoadMedKits() {

        assertNotNull(world.getMedkits());

        Medkit medkit = (Medkit) world.getMedkits().get(0);
        assertNotNull(medkit, "První medkit ma existovat.");
        assertEquals("Medkit", medkit.getItemName(), "Název prvního medkitu by měl být 'Medkit'.");
    }

    @Test
    public void testLoadEnemy() {
        assertNotNull(world.getEnemy());

        Enemy enemy = (Enemy) world.getEnemy().get(0);
        assertNotNull(enemy, "První nepřítel ma existovat.");
        assertEquals("Xar'qun Scout", enemy.getName(), "Název prvního nepřítele by měl být Xar'qun Scout.");
    }

    @Test
    public void testLoadNpc() {
        assertNotNull(world.getNpc());

        FriendlyFoe npc = (FriendlyFoe) world.getNpc().get(0);
        assertNotNull(npc, "První NPC ma existovat.");
        assertEquals("Velitel John Reese", npc.getName(), "Název prvního NPC by měl být Velitel John Reese.");
    }
}
