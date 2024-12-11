package io.github.trashoflevillage.festivities.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.MobFestiveSkinAccess;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreeperEntityRenderer.class)
public abstract class CreeperEntityRendererMixin {
    @ModifyReturnValue(method = "getTexture(Lnet/minecraft/entity/mob/CreeperEntity;)Lnet/minecraft/util/Identifier;", at = @At("TAIL"))
    public Identifier getTexture(Identifier original, CreeperEntity entity) {
        int skin = ((MobFestiveSkinAccess)entity).getFestiveSkin();
        switch (skin) {
            case 1: return Identifier.of(Festivities.MOD_ID, "textures/entity/holiday/christmas/creeper/creeper.png");
            default: return original;
        }
    }
}
