package io.github.trashoflevillage.festivities.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.MobFestiveSkinAccess;
import net.minecraft.client.render.entity.DrownedEntityRenderer;
import net.minecraft.client.render.entity.HuskEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HuskEntityRenderer.class)
public abstract class HuskEntityRendererMixin {
    @ModifyReturnValue(method = "getTexture(Lnet/minecraft/entity/mob/ZombieEntity;)Lnet/minecraft/util/Identifier;", at = @At("TAIL"))
    public Identifier getTexture(Identifier original, ZombieEntity entity) {
        int skin = ((MobFestiveSkinAccess)entity).getFestiveSkin();
        switch (skin) {
            case 1: return Identifier.of(Festivities.MOD_ID, "textures/entity/holiday/christmas/zombie/husk.png");
            default: return original;
        }
    }
}
