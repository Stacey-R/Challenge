package challengeMode;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockBreakListener implements Listener {
@EventHandler
public void onBreak(BlockBreakEvent e) {
	if (e.getBlock().getType() == Material.DIRT ||e.getBlock().getType() == Material.GRASS_BLOCK 
			|| e.getBlock().getType() == Material.COARSE_DIRT || e.getBlock().getType() == Material.GRASS_PATH) {
		Random r = new Random();
		if (r.nextInt(100) <= 4) {
			Player p = e.getPlayer();
			p.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.WITHER , 200 , 1));
			p.sendMessage(ChatColor.RED + "You got tetanus!");
		}
	} 
	Player p = e.getPlayer();
	if (p.getInventory().getItemInMainHand() != null) {
		if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
			return;
		}
		Random r = new Random();
		if (r.nextInt(100) + 1 <= 3) {
			int slot = p.getInventory().getHeldItemSlot();
			p.getInventory().setItem(slot, new ItemStack(Material.AIR));
			p.sendMessage(ChatColor.RED + "Your item broke!");
		}
	}
}
@EventHandler
public void onHit(EntityDamageByEntityEvent e) {
	if (e.getDamager() instanceof Player) {
		Player p = (Player) e.getDamager();
		if (p.getInventory().getItemInMainHand() != null) {
			if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
				return;
			}
			Random r = new Random();
			if (r.nextInt(100) <= 2) {
				p.getInventory().setItemInMainHand(null);
				p.sendMessage(ChatColor.RED + "Your item broke!");
			}
		}
	}
}
}
