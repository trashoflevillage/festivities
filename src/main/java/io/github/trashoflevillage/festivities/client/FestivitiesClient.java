package io.github.trashoflevillage.festivities.client;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.Item;

@Environment(EnvType.CLIENT)
public class FestivitiesClient implements ClientModInitializer {
    private static final Block[] blocksWithTransparency = new Block[] {
            ModBlocks.MAGIC_SNOWGLOBE
    };

    @Override
    public void onInitializeClient() {
        for (Block i : blocksWithTransparency)
            BlockRenderLayerMap.INSTANCE.putBlock(i, RenderLayer.getCutout());

        registerItemColor(ModItems.JOLLY_HELMET);
    }

    private void registerItemColor(Item item) {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedColorComponent.getColor(stack, -6265536), item);
    }
}
