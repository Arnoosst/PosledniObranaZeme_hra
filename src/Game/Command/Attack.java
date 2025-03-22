package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Weapon;
import Game.NPC.Enemy;
import Game.Player;
import Game.World;

public class Attack extends Command {

    private World world;
    private Player player;
    private Inventory inventory;

    public Attack(World world, Player player, Inventory inventory) {
        this.world = world;
        this.player = player;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        Enemy en = world.returnenemyInLocation();
        if (en == null) {
            return "Žádný nepřítel v této lokaci.";
        }

        int damageIncrease = 0;

        for (Item item : inventory.getInventory()) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                damageIncrease += weapon.getDamageIncrease();
            }
        }


        while (en.getHealth() > 0 && player.getHealth() > 0) {
            en.takeDamage(player.giveDamage(damageIncrease));


            if (en.getHealth() <= 0) {
                world.removeEnemyFromLocation(en);
                return "Nepřítel byl poražen!";
            }


            player.takeDamage(en.getDamage());


            if (player.getHealth() <= 0) {
                return "Hráč byl poražen!";
            }
        }

        return "Chyba";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
