package Game.Command;

import Game.Items.Inventory;
import Game.Items.Item;
import Game.Items.Weapon;
import Game.NPC.Enemy;
import Game.Player;
import Game.World;

public class Attack extends Command {
    @Override
    public String execute() {
        Enemy en = null;
        int damageIncrease = 0;

        for (int i = 0; i < World.getEnemy().size(); i++) {
            if (World.getCurrentLocation() == World.getEnemy().get(i).getId()) {
                en = (Enemy) World.getEnemy().get(i);
                break;
            }
        }

        if (en == null) {
            return "Žádný nepřítel v této lokaci.";
        }


        for (int i = 0; i < Inventory.getInventory().size(); i++) {
            Item item = Inventory.getInventory().get(i);
            if (item.getItemName().equals("weapon")) {
                Weapon weapon = (Weapon) item;
                damageIncrease += weapon.getDamageIncrease();
            }
        }


        while (en.getHealth() > 0 && Player.getHealth() > 0) {
            en.takeDamage(Player.giveDamage(damageIncrease));
            Player.takeDamage(en.getDamage());

            if (en.getHealth() <= 0) {
                World.removeEnemyFromLocation(en);
                return "Nepřítel byl poražen!";

            }

            if (Player.getHealth() <= 0) {
                System.out.println("Hráč byl poražen!");
                exit();
            }
        }
        return "Chyba";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
