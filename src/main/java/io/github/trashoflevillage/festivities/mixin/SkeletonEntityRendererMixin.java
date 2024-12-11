package io.github.trashoflevillage.festivities.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.MobFestiveSkinAccess;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SkeletonEntityRenderer.class)
public abstract class SkeletonEntityRendererMixin<T extends AbstractSkeletonEntity> {
    @ModifyReturnValue(method = "getTexture(Lnet/minecraft/entity/mob/AbstractSkeletonEntity;)Lnet/minecraft/util/Identifier;", at = @At("TAIL"))
    public Identifier getTexture(Identifier original, T entity) {
        int skin = ((MobFestiveSkinAccess)entity).getFestiveSkin();
        switch (skin) {
            case 1: return Identifier.of(Festivities.MOD_ID, "textures/entity/holiday/christmas/skeleton/skeleton.png");
            default: return original;
        }
    }
}
