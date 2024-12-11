package io.github.trashoflevillage.festivities.mixin;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.MobFestiveSkinAccess;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends Entity implements MobFestiveSkinAccess {
    @Unique
    private static final TrackedData<Integer> FESTIVE_SKIN = DataTracker.registerData(MobEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);

    public MobEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(FESTIVE_SKIN, -1);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    protected void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        setFestiveSkin(nbt.getInt("festive_skin"));
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    protected void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("festive_skin", getFestiveSkin());
    }

    public int getFestiveSkin() {
        return this.dataTracker.get(FESTIVE_SKIN);
    }

    public void setFestiveSkin(int val) {
        this.dataTracker.set(FESTIVE_SKIN, val);
    }

    @Inject(method = "initialize", at = @At("HEAD"))
    protected void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        if (getFestiveSkin() == -1) {
            setFestiveSkin(getInitFestiveSkin());
        }
    }

    private int getInitFestiveSkin() {
        if (random.nextBoolean()) {
            if (Festivities.isChristmas()) return 1;
        }
        return 0;
    }
}
