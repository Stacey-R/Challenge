package challengeMode;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;

import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityPanda;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_15_R1.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_15_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomStroll;

public class CustomPanda extends EntityPanda{

	public CustomPanda(Location loc) {
		super(EntityTypes.PANDA, ((CraftWorld) loc.getWorld()).getHandle());
		this.setHealth(150F);
		this.setPersistent();
		this.setAbsorptionHearts(20F);
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		this.setSilent(true);
	}
	@Override
	public void initPathfinder() {
		this.goalSelector.a(0 , new PathfinderGoalFloat(this));
		this.goalSelector.a(3 , new PathfinderGoalMeleeAttack(this, 2.0D, true));
		this.goalSelector.a(4 , new PathfinderGoalMoveTowardsRestriction(this, 0.2D));
		this.goalSelector.a(5 , new PathfinderGoalMoveThroughVillage(this, 0.2D, false, 1, null));
		this.goalSelector.a(6, new PathfinderGoalRandomStroll(this, 0.2D));
		this.goalSelector.a(8 , new PathfinderGoalRandomLookaround(this));
		this.goalSelector.a(7 , new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		this.targetSelector.a(1 , new PathfinderGoalHurtByTarget(this));
		this.targetSelector.a(2 , new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
	}

}
