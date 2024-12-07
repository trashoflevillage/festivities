package io.github.trashoflevillage.festivities.mixin;

import io.github.trashoflevillage.festivities.entity.GlobalEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSkeletonEntity.class)
public abstract class AbstractSkeletonEntityMixin extends HostileEntity {
	protected AbstractSkeletonEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("TAIL"), method = "initialize")
	private void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
		GlobalEntity.initHolidayEquipment(this);
	}
}