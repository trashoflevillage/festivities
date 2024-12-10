package io.github.trashoflevillage.festivities.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.IllagerEntityRenderer;
import net.minecraft.client.render.entity.PillagerEntityRenderer;
import net.minecraft.client.render.entity.VindicatorEntityRenderer;
import net.minecraft.client.render.entity.model.IllagerEntityModel;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PillagerEntityRenderer.class)
public abstract class PillagerEntityRendererMixin extends IllagerEntityRenderer<PillagerEntity> {
    protected PillagerEntityRendererMixin(EntityRendererFactory.Context ctx, IllagerEntityModel<PillagerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @ModifyReturnValue(method = "getTexture(Lnet/minecraft/entity/mob/PillagerEntity;)Lnet/minecraft/util/Identifier;", at = @At("TAIL"))
    public Identifier getTexture(Identifier original) {
        if (Festivities.isChristmas()) return Identifier.of(Festivities.MOD_ID, "textures/entity/holiday/christmas/illager/pillager.png");
        return original;
    }
}