package io.github.trashoflevillage.festivities.datagen;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Block[] blocksThatDropThemselves = new Block[] {
                ModBlocks.WHITE_CANDY_CANE_BLOCK,
                ModBlocks.LIGHT_GRAY_CANDY_CANE_BLOCK,
                ModBlocks.GRAY_CANDY_CANE_BLOCK,
                ModBlocks.BLACK_CANDY_CANE_BLOCK,
                ModBlocks.BROWN_CANDY_CANE_BLOCK,
                ModBlocks.RED_CANDY_CANE_BLOCK,
                ModBlocks.ORANGE_CANDY_CANE_BLOCK,
                ModBlocks.YELLOW_CANDY_CANE_BLOCK,
                ModBlocks.LIME_CANDY_CANE_BLOCK,
                ModBlocks.GREEN_CANDY_CANE_BLOCK,
                ModBlocks.CYAN_CANDY_CANE_BLOCK,
                ModBlocks.LIGHT_BLUE_CANDY_CANE_BLOCK,
                ModBlocks.BLUE_CANDY_CANE_BLOCK,
                ModBlocks.PURPLE_CANDY_CANE_BLOCK,
                ModBlocks.MAGENTA_CANDY_CANE_BLOCK,
                ModBlocks.PINK_CANDY_CANE_BLOCK
        };
        for (Block i : blocksThatDropThemselves) addDrop(i);
    }
}
