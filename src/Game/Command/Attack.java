package Game.Command;

import Game.GamePrints;
import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Weapon;
import Game.NPC.Enemy;
import Game.Player;
import Game.World;


/**
 * Represents the attack command in the game, where the player fights an enemy.
 * The player deals damage to an enemy and the enemy fights back until player or enemy is defeated.
 */
public class Attack extends Command {

    private World world;
    private Player player;
    private Inventory inventory;
    private GamePrints gamePrints;

    public Attack(World world, Player player, Inventory inventory, GamePrints gamePrints) {
        this.world = world;
        this.player = player;
        this.inventory = inventory;
        this.gamePrints = gamePrints;
    }

    /**
     * Executes the attack command where the player fights an enemy.
     * The player and enemy take turns dealing damage to each other until one of them is defeated.
     * If the player defeats an enemy, rewards are given based on the current location.
     *
     * @return a string message indicating the outcome of the battle.
     */
    @Override
    public String execute() {
        Enemy en = world.returnenemyInLocation();
        if (en == null) {
            return "Žádný nepřítel v této lokaci.";
        } else {
            System.out.println("Nepřítel nalezen v této lokaci! \n");
            System.out.println(en.getName() +": " + en.getSpeach() + "\n");
        }


        while (en.getHealth() > 0 && player.getHealth() > 0) {

            en.takeDamage(player.giveDamage(player.damageIncrease(inventory)));

            if (en.getHealth() <= 0) {
                world.removeEnemyFromLocation(en);


                if (World.getCurrentLocation() == 4) {
                    World.setOxygen(true);
                    System.out.println("⚠️ Boj skončil! ⚠️");
                    System.out.println("Prohledáváš tělo bosse... a nacházíš něco nečekaného!");
                    return "Získal jsi OXYGEN TANK!";

                }

                if (World.getCurrentLocation() == 5) {
                    World.setUnderWaterSuit(true);
                    System.out.println("⚠️ Boj skončil! ⚠️");
                    System.out.println("Boss padl k zemi... ale co to má u sebe?");
                    return "Získal jsi UNDERWATER SUIT!";

                }
                if (World.getCurrentLocation() == 8) {
                    gamePrints.loadWon();
                    System.exit(0);
                }


                inventory.setCoins(inventory.getCoins() + 100 * en.getId());
                return "Nepřítel poražen. Získáváš respekt vesmíru!";
            }


            player.takeDamage(en.getDamage());


            if (player.getHealth() <= 0) {
                return "💀 Hráč poražen!";
                //gamePrints.loadLoseGame();
                //System.exit(0);
            }
        }

        return "Chyba v boji";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
