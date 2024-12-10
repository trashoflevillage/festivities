package io.github.trashoflevillage.festivities.mixin;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.client.render.TexturedRenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    @ModifyVariable(index = 2, method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", at = @At("HEAD"), argsOnly = true)
    private static boolean getChestTextureId(boolean original) {
        return original || Festivities.isChristmas();
    }
}
