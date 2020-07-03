package challengeMode;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ShootArrowListener implements Listener {
@EventHandler
public void onShoot(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.getInventory().getItemInMainHand().getType() == Material.BOW) {
				if (newRandom(100, 0, 2)) {
					  p.getInventory().setItemInMainHand(null);
					p.sendMessage(ChatColor.RED + "Your item broke!");
				}
			} else if (p.getInventory().getItemInOffHand().getType() == Material.BOW) {
				if (newRandom(100 , 0 , 2)) {
			        p.getInventory().setItemInOffHand(null);
					p.sendMessage(ChatColor.RED + "Your item broke!");
				}
			}
				
		}
}
public static boolean newRandom(int max , int minimum , int percentage) {
	Random r = new Random();
	if (r.nextInt(max) + minimum <= percentage) {
		return true;
	}
	return false;
}
}
