package io.github.trashoflevillage.festivities.datagen;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.CANDY_CANE_BLOCKS)
            .add(ModBlocks.WHITE_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.LIGHT_GRAY_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.GRAY_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.BLACK_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.BROWN_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.RED_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.ORANGE_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.YELLOW_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.LIME_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.GREEN_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.CYAN_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.LIGHT_BLUE_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.BLUE_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.PURPLE_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.MAGENTA_CANDY_CANE_BLOCK.asItem())
            .add(ModBlocks.PINK_CANDY_CANE_BLOCK.asItem());
    }
}
