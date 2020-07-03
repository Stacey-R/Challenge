package challengeMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cod;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Illusioner;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Salmon;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TropicalFish;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Witch;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.server.v1_15_R1.WorldServer;



public class SpawnListener implements Listener {
@EventHandler
public void onSpawn(CreatureSpawnEvent e) {
	if (e.getEntity() instanceof PigZombie) {
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe.getItemMeta();
		axe.setType(Material.GOLDEN_CHESTPLATE);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		e.getEntity().getEquipment().setChestplateDropChance(0F);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(axe);
		axe.setType(Material.GOLDEN_LEGGINGS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setLeggingsDropChance(0F);
		e.getEntity().getEquipment().setLeggings(axe);
		axe.setType(Material.STONE_SWORD);
		meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(axe);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0F);
		PigZombie pig = (PigZombie) e.getEntity();
		pig.setAngry(true);
		for (Player p : Bukkit.getOnlinePlayers()) {
			pig.setTarget(p);
		}
	} else if (e.getEntity() instanceof ZombieVillager) {
		e.getEntity().setPersistent(true);
		ZombieVillager v = (ZombieVillager) e.getEntity();
		v.setBaby(true);
		ItemStack axe = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta = axe.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		axe.setType(Material.GOLDEN_CHESTPLATE);
		e.getEntity().getEquipment().setChestplateDropChance(0F);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(axe);
		axe.setType(Material.GOLDEN_LEGGINGS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setLeggingsDropChance(0F);
		e.getEntity().getEquipment().setLeggings(axe);
		axe.setType(Material.DIAMOND_BOOTS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setBootsDropChance(0F);
		e.getEntity().getEquipment().setBoots(axe);
		axe.setType(Material.IRON_SWORD);
		meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(axe);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0F);
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.FIRE_RESISTANCE , 1000000 ,1));
	} else if (e.getEntity() instanceof Drowned) {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
		boots.setItemMeta(meta);
		e.getEntity().getEquipment().setBoots(boots);
		e.getEntity().getEquipment().setBootsDropChance(0.0F);
		ItemStack trident = new ItemStack(Material.TRIDENT);
		ItemMeta tm = trident.getItemMeta();
		tm.addEnchant(Enchantment.IMPALING, 10, true);
		tm.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		trident.setItemMeta(tm);
		e.getEntity().getEquipment().setItemInMainHand(trident);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		ItemStack gear = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta gm = gear.getItemMeta();
		gm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		gear.setItemMeta(meta);
		e.getEntity().getEquipment().setHelmet(gear);
		e.getEntity().getEquipment().setHelmetDropChance(0.0F);
		gear.setType(Material.GOLDEN_CHESTPLATE);
		gear.setItemMeta(gm);
		e.getEntity().getEquipment().setChestplate(gear);
		e.getEntity().getEquipment().setChestplateDropChance(0.0F);
		gear.setType(Material.LEATHER_LEGGINGS);
		gear.setItemMeta(gm);
		e.getEntity().getEquipment().setLeggings(gear);
		e.getEntity().getEquipment().setLeggingsDropChance(0.0F);
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 100000000 , 1));
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 100000000 , 5));
		e.getEntity().setPersistent(true);
	}
	else if (e.getEntity() instanceof Zombie) {
		e.getEntity().setPersistent(true);
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe.getItemMeta();
		axe.setType(Material.GOLDEN_CHESTPLATE);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		e.getEntity().getEquipment().setChestplateDropChance(0F);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(axe);
		axe.setType(Material.GOLDEN_LEGGINGS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setLeggingsDropChance(0F);
		e.getEntity().getEquipment().setLeggings(axe);
		axe.setType(Material.GOLDEN_BOOTS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setBoots(axe);
		e.getEntity().getEquipment().setBootsDropChance(0F);
		axe.setType(Material.GOLDEN_HELMET);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setHelmet(axe);
		e.getEntity().getEquipment().setHelmetDropChance(0F);
		axe.setType(Material.STONE_SWORD);
		meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(axe);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0F);
	}else if (e.getEntity() instanceof WitherSkeleton) {
		e.getEntity().setPersistent(true);
		ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		item.setItemMeta(meta);
		e.getEntity().getEquipment().setBoots(item);
		e.getEntity().getEquipment().setBootsDropChance(0.0F);
		item.setType(Material.GOLDEN_LEGGINGS);
		item.setItemMeta(meta);
		e.getEntity().getEquipment().setLeggings(item);
		e.getEntity().getEquipment().setLeggingsDropChance(0.0F);
		item.setType(Material.DIAMOND_CHESTPLATE);
		item.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(item);
		e.getEntity().getEquipment().setChestplateDropChance(0.0F);
		item.setType(Material.DIAMOND_AXE);
		meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
		meta.addEnchant(Enchantment.DAMAGE_ALL,4 , true);
		meta.addEnchant(Enchantment.FIRE_ASPECT,2 , true);
		item.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(item);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		
	}
	else if (e.getEntity() instanceof Skeleton) {
		e.getEntity().setPersistent(true);
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 8, true);
		meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
		meta.addEnchant(Enchantment.ARROW_FIRE, 2, true);
		bow.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(bow);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0F);
		bow.setType(Material.GOLDEN_HELMET);
		meta.removeEnchant(Enchantment.ARROW_DAMAGE);
		meta.removeEnchant(Enchantment.ARROW_KNOCKBACK);
		meta.removeEnchant(Enchantment.ARROW_FIRE);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		bow.setItemMeta(meta);
		e.getEntity().getEquipment().setHelmet(bow);
		e.getEntity().getEquipment().setHelmetDropChance(0F);
		bow.setType(Material.DIAMOND_CHESTPLATE);
		bow.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(bow);
		e.getEntity().getEquipment().setChestplateDropChance(0F);
	} else if (e.getEntity() instanceof Creeper) {
		e.getEntity().setPersistent(true);
	 Creeper creeper = (Creeper) e.getEntity();
	 creeper.setPowered(true);
	 creeper.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INVISIBILITY , 10000000 , 1));
	}else if (e.getEntity() instanceof CaveSpider) {
		CaveSpider spider = (CaveSpider) e.getEntity();
		spider.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
		spider.getEquipment().setItemInMainHandDropChance(0.0F);
		spider.getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		spider.getEquipment().setItemInOffHandDropChance(0.0F);	
		for (Player p : Bukkit.getOnlinePlayers()) {
			spider.setTarget(p);
		}
	}else if (e.getEntity() instanceof Spider) {
		e.getEntity().setPersistent(true);
		Spider spider = (Spider) e.getEntity();
		 List<Player> list = new ArrayList<Player>();
	      list.addAll(Bukkit.getOnlinePlayers());
	      for (int i = 0 ; i < list.size() ; i++) { 
	    		  Player p = list.get(i);
	    		  spider.setTarget(p); 
	      }
		spider.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 10000000 , 7));
		spider.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 1));
		spider.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
		spider.getEquipment().setItemInMainHandDropChance(0.0F);
		spider.getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		spider.getEquipment().setItemInOffHandDropChance(0.0F);
	} else if (e.getEntity() instanceof Witch) {
		e.getEntity().setPersistent(true);
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.DAMAGE_RESISTANCE , 1000000000 , 1));
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.ABSORPTION , 1000000000 , 6));
	} else if (e.getEntity() instanceof Enderman) {
		Enderman end = (Enderman) e.getEntity();
      List<Player> list = new ArrayList<Player>();
      list.addAll(Bukkit.getOnlinePlayers());
      for (int i = 0 ; i < list.size() ; i++) {
    		  Player p = list.get(i);
    		  end.setTarget(p);
      }
	end.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 2));
	end.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 4));
	} else if (e.getEntity() instanceof Ghast) {
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INVISIBILITY , 1000000000 , 1));
		e.getEntity().setSilent(true);
		e.getEntity().setPersistent(true);
	} else if (e.getEntity() instanceof Pillager) {
		ItemStack crossbow = new ItemStack(Material.CROSSBOW);
		e.getEntity().setPersistent(true);
		ItemMeta meta = crossbow.getItemMeta();
		meta.addEnchant(Enchantment.MULTISHOT, 1 , true);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 5 , true);
		meta.addEnchant(Enchantment.QUICK_CHARGE, 3 , true);
		meta.addEnchant(Enchantment.ARROW_FIRE, 5 , true);
		meta.addEnchant(Enchantment.PIERCING, 5 , true);
		crossbow.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(crossbow);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		ItemStack axe = new ItemStack(Material.DIAMOND_CHESTPLATE);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		e.getEntity().getEquipment().setChestplateDropChance(0F);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setChestplate(axe);
		axe.setType(Material.DIAMOND_LEGGINGS);
		axe.setItemMeta(meta);
		e.getEntity().getEquipment().setLeggingsDropChance(0F);
		e.getEntity().getEquipment().setLeggings(axe);
		e.getEntity().getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		e.getEntity().getEquipment().setItemInOffHandDropChance(0.0F);
	} else if (e.getEntity() instanceof Ravager) {
		e.getEntity().setPersistent(true);
		Ravager r = (Ravager) e.getEntity();
		Pillager p = (Pillager) r.getWorld().spawnEntity(e.getLocation().add(3, 1 , 0), EntityType.PILLAGER);
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 4));
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 2));
     //vex.
	} else if (e.getEntity() instanceof Vex) {
		e.getEntity().setPersistent(true);
		ItemStack weapon = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = weapon.getItemMeta();
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
		weapon.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(weapon);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta cmeta = chestplate.getItemMeta();
		cmeta.addEnchant(Enchantment.THORNS, 5, true);
		cmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		chestplate.setItemMeta(cmeta);
		e.getEntity().getEquipment().setChestplate(chestplate);
		e.getEntity().getEquipment().setChestplateDropChance(0.0F);
		//Evokers, they will summon 3 vexs 2 illusions 1 pillager and 1 vindicator
	} else if (e.getEntity() instanceof Evoker) {
		e.getEntity().setPersistent(true);
		World world = e.getLocation().getWorld();
		Location loc = e.getLocation();
		world.spawnEntity(loc, EntityType.ILLUSIONER);
		world.spawnEntity(loc, EntityType.ILLUSIONER);
		world.spawnEntity(loc, EntityType.VEX);
		world.spawnEntity(loc, EntityType.VEX);
		world.spawnEntity(loc, EntityType.VEX);
		world.spawnEntity(loc, EntityType.PILLAGER);
		world.spawnEntity(loc, EntityType.VINDICATOR);
		e.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		e.getEntity().getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		e.getEntity().getEquipment().setItemInOffHandDropChance(0.0F);
		// Illusioner they have a totem of undying
	} else if (e.getEntity() instanceof Illusioner) {
		e.getEntity().setPersistent(true);
		e.getEntity().getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		e.getEntity().getEquipment().setItemInOffHandDropChance(0.0F);
		//Vindicator they have a sharp 7 kb 5 diamond axe with a totem of undying + res 2 and absorbtion 11!
	} else if (e.getEntity() instanceof Vindicator) {
		e.getEntity().setPersistent(true);
		ItemStack item = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 7 , true);
		meta.addEnchant(Enchantment.KNOCKBACK, 5 , true);
		item.setItemMeta(meta);
		e.getEntity().getEquipment().setItemInMainHand(item);
		e.getEntity().getEquipment().setItemInMainHandDropChance(0.0F);
		e.getEntity().getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		e.getEntity().getEquipment().setItemInOffHandDropChance(0.0F);
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.DAMAGE_RESISTANCE , 1000000000 , 1));
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.ABSORPTION , 1000000000 , 10));
		//wolfs dmg based on pack size, everytime they hit u they call for help
	} else if (e.getEntity() instanceof Wolf) {
		Wolf wolf = (Wolf) e.getEntity();
		wolf.setAngry(true);
		wolf.setPersistent(true);
		wolf.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 4));
		for (Player p : Bukkit.getOnlinePlayers()) {
			wolf.setTarget(p);
		}
		//Magma cubes are size 6, they set you on fire!
	}else if (e.getEntity() instanceof MagmaCube) {
		MagmaCube cube = (MagmaCube) e.getEntity();
		cube.setSize(6);
		cube.setPersistent(true);
		cube.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 2));
	}
	//Slimes, they are size 6
	else if (e.getEntity() instanceof Slime) {
		Slime slime = (Slime) e.getEntity();
		slime.setSize(6);
		slime.setPersistent(true);
		slime.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 1));
	//polar bear, 1 hit K.O
	}else if (e.getEntity() instanceof Panda) {
	Panda panda = (Panda) e.getEntity();
	if (panda.isSilent()) {
		panda.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 5));
		panda.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 2));
		panda.getEquipment().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
		panda.getEquipment().setItemInMainHandDropChance(0F);
	}
	CustomPanda p = new CustomPanda(e.getLocation());
	WorldServer world = ((CraftWorld)e.getEntity().getWorld()).getHandle();
	world.addEntity(p);
	e.getEntity().remove();
	}  	else if (e.getEntity() instanceof PolarBear) {
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 5));
		e.getEntity().addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 100000000 , 255));
		PolarBear pb = (PolarBear) e.getEntity();
		ItemStack item = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 10000, true);
		item.setItemMeta(meta);
		pb.getEquipment().setItemInMainHand(item);
		pb.getEquipment().setItemInMainHandDropChance(0.0F);
		pb.setPersistent(true);
		for (Player p : Bukkit.getOnlinePlayers()) {
			pb.setTarget(p);
		}
	} else if (e.getEntity() instanceof Phantom) {
		Phantom p = (Phantom) e.getEntity();
		p.setSize(6);
		p.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.FIRE_RESISTANCE , 100000000 , 1));
		p.setPersistent(true);
	} else if (e.getEntity() instanceof Ocelot) {
		Ocelot o = (Ocelot) e.getEntity();
		if (o.isSilent()) {
			o.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 3));
			o.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 2));
			o.getEquipment().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
			o.getEquipment().setItemInMainHandDropChance(0F);
			o.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.ABSORPTION , 1000000000 , 5));
		}
		CustomOcelot p = new CustomOcelot(e.getLocation());
		WorldServer world = ((CraftWorld)e.getEntity().getWorld()).getHandle();
		world.addEntity(p);
		e.getEntity().remove();
		
	} else if (e.getEntity() instanceof Fox) {
		Fox fox = (Fox) e.getEntity();
		if (fox.isSilent()) {
			fox.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.SPEED , 1000000000 , 3));
			fox.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.INCREASE_DAMAGE , 1000000000 , 2));
			fox.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.ABSORPTION , 1000000000 , 5));
		}
		CustomFox p = new CustomFox(e.getLocation());
		WorldServer world = ((CraftWorld)e.getEntity().getWorld()).getHandle();
		world.addEntity(p);
		e.getEntity().remove();
	}
	}
@EventHandler
public void preExplode(EntityExplodeEvent e) {
	if (e.getEntity() instanceof Creeper) {
		Creeper creeper = (Creeper) e.getEntity();
		creeper.removePotionEffect(PotionEffectType.INVISIBILITY);
		return;
	}
}
@EventHandler
public void onDmg(EntityDamageByEntityEvent e) {
	if (e.getEntity() instanceof Player) {
		if (e.getDamager() instanceof Blaze) {
			Player p = (Player) e.getEntity();
			if (p.isBlocking()) {
				return;
			}
			List<Entity> list = new ArrayList<Entity>();
			list.addAll(e.getDamager().getNearbyEntities(20, 20, 20));
			int times = 1;
			for (int a = 0 ; a < list.size() ; a++) {
				Entity entity = list.get(a);
				if (entity instanceof Blaze) {
					times++;
				}
			}
			double dmg = ((e.getDamage() * times) - e.getDamage()) * 0.5;
		    p.damage(dmg);
			e.setCancelled(true);
		} else if (e.getDamager() instanceof Silverfish) {
			  Player p = (Player) e.getEntity();
			if (p.isBlocking()) {
				return;
			}
			List<Entity> list = new ArrayList<Entity>();
			list.addAll(e.getDamager().getNearbyEntities(15, 15, 15));
			int times = 1;
			for (int a = 0 ; a < list.size() ; a++) {
				Entity entity = list.get(a);
				if (entity instanceof Silverfish) {
					times++;
				}
			}
			if (times > 200) {
				return;
			}
			Location loc = e.getDamager().getLocation();
			World world = e.getDamager().getWorld();
			for (int i = 0 ; i < times ; i++) {
				world.spawnEntity(loc, EntityType.SILVERFISH);
		    double dmg = e.getDamage() * times * 0.8 - e.getDamage();
		  
		    p.damage(dmg);
			}
		} else if (e.getDamager() instanceof SmallFireball) {
			SmallFireball fb = (SmallFireball) e.getDamager();
			if (fb.getShooter() == null) {
				return;
			}
			if (fb.getShooter() instanceof Blaze) {
				Player p = (Player) e.getEntity();
				if (p.isBlocking()) {
					return;
				}
				List<Entity> list = new ArrayList<Entity>();
				list.addAll(e.getDamager().getNearbyEntities(20, 20, 20));
				int times = 1;
				for (int a = 0 ; a < list.size() ; a++) {
					Entity entity = list.get(a);
					if (entity instanceof Blaze) {
						times++;
					}
				}
				double dmg = (e.getDamage() * times - e.getDamage()) * 0.5;
				
				p.damage(dmg);
			}
		} else if (e.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() == null) {
				return;
			}
			if (arrow.getShooter() instanceof Pillager) {
				Player p = (Player) e.getEntity();
				if (p.isBlocking()) {
					return;
				}
				double dmg = e.getDamage() * 2 - e.getDamage();
				
				p.damage(dmg);
			}
		} else if (e.getDamager() instanceof Wolf) {
			Player p = (Player) e.getEntity();
			if (p.isBlocking()) {
				return;
			}
			List<Entity> list = new ArrayList<Entity>();
			list.addAll(e.getDamager().getNearbyEntities(20, 20, 20));
			int times = 1;
			for (int a = 0 ; a < list.size() ; a++) {
				Entity entity = list.get(a);
				if (entity instanceof Wolf) {
					times++;
				}
			}
			double dmg = (e.getDamage() * times - e.getDamage()) * 0.8;
			p.damage(dmg);
			Location loc = e.getDamager().getLocation();
			World world = loc.getWorld();
			double random = 2 + (Math.random() * 11);
			for (int i = 0 ; i < random  ; i++) {
				world.spawnEntity(loc, EntityType.WOLF);
			}
		} else if (e.getDamager() instanceof MagmaCube) {
            Player p = (Player) e.getEntity();	     
 			p.setFireTicks(250);
		}  else if (e.getDamager() instanceof CaveSpider) {
			Player p = (Player) e.getEntity();
			p.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.WITHER , 150 , 2));
		}
	} else if (e.getEntity() instanceof Pillager) {
		if (e.getDamager() instanceof Arrow) {
			Arrow a = (Arrow) e.getDamager();
			if (a.getShooter() == null) {
				return;
			}
			if (a.getShooter() instanceof Pillager) {
				double heal = e.getDamage();
			 Pillager p = (Pillager) e.getEntity();
			 p.setHealth(p.getHealth() + heal);
			}
		}
	}
}
/*
 *TODO:
 * look at stuff at test it!
 */
@EventHandler
public void onShulkerHit(ProjectileHitEvent e) {
	if (e.getHitEntity() == null) {
		return;
	}
	if (e.getEntity() instanceof ShulkerBullet) {
		ShulkerBullet b = (ShulkerBullet) e.getEntity();
		if (e.getHitEntity() instanceof Player) {
			if (b.getShooter() == null) {
				return;
			}
			if (b.getShooter() instanceof Shulker) {
				Player p = (Player) e.getHitEntity();
				p.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.LEVITATION , 200 , 14));
			}
		}
	}
}
@EventHandler
public void onEntityDamage(EntityDamageEvent e) {
Entity entity = e.getEntity();
if (e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) {
	 if (entity instanceof Pig || entity instanceof Cow || entity instanceof Sheep || entity instanceof Chicken || entity instanceof Rabbit) {
		 entity.setFireTicks(0);
		 e.setCancelled(true);
	} else if (entity instanceof Player) {
		if (entity.getWorld().getEnvironment() == Environment.NETHER) {
			Player p = (Player) entity;
			if (e.getCause() == DamageCause.FIRE) {
		    p.damage(e.getDamage() * 1.5);
			} else if (e.getCause() == DamageCause.FIRE_TICK) {
				p.setFireTicks(100000000);
				p.damage(e.getDamage());
			}
		}
	}
} else if (e.getCause() == DamageCause.SUFFOCATION) {
	if (entity instanceof Ghast) {
		e.setCancelled(true);
	}
} else if (e.getCause() == DamageCause.CONTACT) {
	if (entity instanceof Player) {
		Player p =(Player) entity;
		p.addPotionEffect(new PotionEffect((PotionEffectType) PotionEffectType.POISON , 500 , 1));
	}
}
}
@EventHandler
public void death(EntityDeathEvent e) {
	if (!(e.getEntity() instanceof Player)) {
		Entity entity = e.getEntity();
		if (entity instanceof Pig || entity instanceof Cow || entity instanceof Sheep || entity instanceof Chicken
				|| entity instanceof Salmon || entity instanceof Cod || entity instanceof TropicalFish || entity instanceof Rabbit)  {
			 e.getDrops().clear();
			 World world = e.getEntity().getWorld();
			 Location loc = e.getEntity().getLocation();
			 double random =  1 +(Math.random() * 10);
			 if (random <= 3.5) {
			 if (entity instanceof Rabbit) {
				 world.dropItemNaturally(loc, new ItemStack(Material.RABBIT));
			 }
			if (entity instanceof Pig) {
						 world.dropItemNaturally(loc, new ItemStack(Material.PORKCHOP));
			 } else if (entity instanceof Cow) {
				 Random r = new Random();
						 world.dropItemNaturally(loc, new ItemStack(Material.BEEF));
						 world.dropItemNaturally(loc, new ItemStack(Material.LEATHER));
			 }
			 else if (entity instanceof Sheep) {
				 Random r = new Random();
						 world.dropItemNaturally(loc, new ItemStack(Material.MUTTON));
						 world.dropItemNaturally(loc, new ItemStack(Material.WHITE_WOOL));
			 }
			 else if (entity instanceof Chicken) {
						 world.dropItemNaturally(loc, new ItemStack(Material.CHICKEN));
						 world.dropItemNaturally(loc, new ItemStack(Material.FEATHER));
			 } else if (entity instanceof Salmon) {
				 world.dropItemNaturally(loc, new ItemStack(Material.SALMON));
			 } else if (entity instanceof Cod) {
				 world.dropItemNaturally(loc, new ItemStack(Material.COD));
			 } else if (entity instanceof TropicalFish) {
				 world.dropItemNaturally(loc, new ItemStack(Material.TROPICAL_FISH));
			 }
		}
		} else if (entity instanceof Blaze || entity instanceof Enderman) {
			 e.getDrops().clear();
			 World world = e.getEntity().getWorld();
			 Location loc = e.getEntity().getLocation();
			 double random =  1 +(Math.random() * 10);
			 if (random <= 3.5) {
			  if (entity instanceof Enderman) {
				  world.dropItemNaturally(loc, new ItemStack(Material.ENDER_PEARL));
			  } else if (entity instanceof Blaze) {
				  world.dropItemNaturally(loc, new ItemStack(Material.BLAZE_ROD));
			  }
			 
			 }
		}
	}
}
@EventHandler
public void changeWorld(PlayerChangedWorldEvent e) {
	if (e.getPlayer().getWorld().getEnvironment() ==  Environment.NETHER) {
		Location loc = e.getPlayer().getLocation().add(15 , 0 , 0);
		if (loc.getBlock().getType() != Material.AIR) {
			loc = e.getPlayer().getLocation().add(0 , 0 ,15);
		}
		World world = e.getPlayer().getWorld();
		for (int i = 0 ; i < 2 ; i++) {
		world.spawnEntity(loc, EntityType.GHAST);
		loc = e.getPlayer().getLocation().add(5 , 3 , 0);
		} 
} else if (e.getFrom().getEnvironment() == Environment.NETHER) {
	if (e.getPlayer().getWorld().getEnvironment() == Environment.NORMAL) {
		Location loc = e.getPlayer().getLocation().add(0 , 10 ,0);
		World world = e.getPlayer().getWorld();
		world.spawnEntity(loc, EntityType.GHAST);
	}
}

}
} 
