package challengeMode;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class SmeltingListener implements Listener {
@EventHandler
public void smelt(InventoryClickEvent e) {
	if (e.getInventory().getType() == InventoryType.FURNACE) {
		if (e.getCurrentItem() != null) {
			ItemStack item = e.getCurrentItem();
			if (item.getType() == Material.IRON_ORE) {
				e.getWhoClicked().sendMessage(ChatColor.RED + "You can only smelt iron ore in a blast furnace!");
				e.setCancelled(true);
			} else if (item.getType() == Material.BEEF || item.getType() == Material.PORKCHOP 
					|| item.getType() == Material.MUTTON || item.getType() == Material.CHICKEN || item.getType() == Material.COD 
					|| item.getType() == Material.SALMON || item.getType() == Material.TROPICAL_FISH ||  item.getType() == Material.RABBIT) {
				e.getWhoClicked().sendMessage(ChatColor.RED + "You can only cook these items in a smoker!");
				e.setCancelled(true);
			}
				
		}
	} else if (e.getInventory().getType() == InventoryType.BLAST_FURNACE) {
		if (e.getCurrentItem() != null) {
			ItemStack item = e.getCurrentItem();
			if (item.getType() == Material.BEEF || item.getType() == Material.PORKCHOP 
					|| item.getType() == Material.MUTTON || item.getType() == Material.CHICKEN || item.getType() == Material.COD 
					|| item.getType() == Material.SALMON || item.getType() == Material.TROPICAL_FISH ||  item.getType() == Material.RABBIT) {
				e.getWhoClicked().sendMessage(ChatColor.RED + "You can only cook these items in a smoker!");
				e.setCancelled(true);
			}
		}
	} else if (e.getInventory().getType() == InventoryType.SMOKER) {
		if (e.getCurrentItem() != null) {
			ItemStack item = e.getCurrentItem();
			if (item.getType() == Material.IRON_ORE) {
				e.getWhoClicked().sendMessage(ChatColor.RED + "You can only cook these in a blast furnace!");
				e.setCancelled(true);
			}
		}
	}
}
}

