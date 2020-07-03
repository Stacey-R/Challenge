package challengeMode;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class register extends JavaPlugin{
@Override
public void onEnable() {
	Bukkit.addRecipe(getRecipe());
	Bukkit.addRecipe(getRecipe2());
	Bukkit.addRecipe(getRecipe3());
	removeRecipe2();
	removeRecipe3();
	this.getServer().getPluginManager().registerEvents(new SpawnListener(), this);
	this.getServer().getPluginManager().registerEvents(new SmeltingListener(), this);
	this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
	this.getServer().getPluginManager().registerEvents(new ShootArrowListener(), this);
	removeRecipe();
}
@Override
public void onDisable() {
	
}
public ShapedRecipe getRecipe() {
	ItemStack item = new ItemStack(Material.BUCKET);
	NamespacedKey key = new NamespacedKey(this, "Bucket");
	ItemMeta meta = item.getItemMeta();
	meta.setUnbreakable(true);
	meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	item.setItemMeta(meta);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	recipe.shape("   ", " S ", " L ");
	recipe.setIngredient('S', Material.IRON_INGOT);
	recipe.setIngredient('L', Material.IRON_BLOCK);
	return recipe;
}
public void removeRecipe() {
	Iterator<Recipe> it = getServer().recipeIterator();
	Recipe recipe;
	while(it.hasNext())
	{
	recipe = it.next();
	if (recipe != null && recipe.getResult().getType() == Material.BUCKET)
	{
		if (!recipe.getResult().getItemMeta().isUnbreakable()) {
	it.remove();
		}
	}
	}
}
public ShapedRecipe getRecipe2() {
	ItemStack item = new ItemStack(Material.BLAST_FURNACE);
	NamespacedKey key = new NamespacedKey(this, "Blast_Furnace");
	ItemMeta meta = item.getItemMeta();
	meta.setUnbreakable(true);
	meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	item.setItemMeta(meta);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	recipe.shape("CSC", "SFS", "CSC");
	recipe.setIngredient('S', Material.COAL);
	recipe.setIngredient('C', Material.COBBLESTONE);
	recipe.setIngredient('F', Material.FURNACE);
	return recipe;
}
public void removeRecipe2() {
	Iterator<Recipe> it = getServer().recipeIterator();
	Recipe recipe;
	while(it.hasNext())
	{
	recipe = it.next();
	if (recipe != null && recipe.getResult().getType() == Material.BLAST_FURNACE)
	{
		if (!recipe.getResult().getItemMeta().isUnbreakable()) {
	it.remove();
		}
	}
	}
}
public ShapedRecipe getRecipe3() {
	ItemStack item = new ItemStack(Material.SMOKER);
	NamespacedKey key = new NamespacedKey(this, "Smoker");
	ItemMeta meta = item.getItemMeta();
	meta.setUnbreakable(true);
	meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	item.setItemMeta(meta);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	recipe.shape("CCC", "CFC", " S ");
	recipe.setIngredient('S', Material.CAMPFIRE);
	recipe.setIngredient('C', Material.COBBLESTONE);
	recipe.setIngredient('F', Material.FURNACE);
	return recipe;
}
public void removeRecipe3() {
	Iterator<Recipe> it = getServer().recipeIterator();
	Recipe recipe;
	while(it.hasNext())
	{
	recipe = it.next();
	if (recipe != null && recipe.getResult().getType() == Material.SMOKER)
	{
		if (!recipe.getResult().getItemMeta().isUnbreakable()) {
	it.remove();
		}
	}
	}
}
}
