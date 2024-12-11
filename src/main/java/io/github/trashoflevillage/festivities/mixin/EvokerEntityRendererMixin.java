package io.github.trashoflevillage.festivities.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.MobFestiveSkinAccess;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EvokerEntityRenderer;
import net.minecraft.client.render.entity.IllagerEntityRenderer;
import net.minecraft.client.render.entity.VindicatorEntityRenderer;
import net.minecraft.client.render.entity.model.IllagerEntityModel;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EvokerEntityRenderer.class)
public abstract class EvokerEntityRendererMixin<T extends SpellcastingIllagerEntity> extends IllagerEntityRenderer<EvokerEntity> {
    protected EvokerEntityRendererMixin(EntityRendererFactory.Context ctx, IllagerEntityModel<EvokerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @ModifyReturnValue(method = "getTexture(Lnet/minecraft/entity/mob/SpellcastingIllagerEntity;)Lnet/minecraft/util/Identifier;", at = @At("TAIL"))
    public Identifier getTexture(Identifier original, T entity) {
        int skin = ((MobFestiveSkinAccess)entity).getFestiveSkin();
        switch (skin) {
            case 1: return Identifier.of(Festivities.MOD_ID, "textures/entity/holiday/christmas/illager/evoker.png");
            default: return original;
        }
    }
}