package io.github.trashoflevillage.festivities.datagen;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.util.ModConventionalTags;
import io.github.trashoflevillage.festivities.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModConventionalTags.Blocks.STRIPPED_LOGS)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.STRIPPED_BIRCH_LOG)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.STRIPPED_CHERRY_LOG)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.STRIPPED_CRIMSON_STEM)
                .add(Blocks.STRIPPED_WARPED_STEM);

        getOrCreateTagBuilder(ModConventionalTags.Blocks.STRIPPED_WOODS)
                .add(Blocks.STRIPPED_ACACIA_WOOD)
                .add(Blocks.STRIPPED_DARK_OAK_WOOD)
                .add(Blocks.STRIPPED_OAK_WOOD)
                .add(Blocks.STRIPPED_BIRCH_WOOD)
                .add(Blocks.STRIPPED_SPRUCE_WOOD)
                .add(Blocks.STRIPPED_CHERRY_WOOD)
                .add(Blocks.STRIPPED_JUNGLE_WOOD)
                .add(Blocks.STRIPPED_MANGROVE_WOOD)
                .add(Blocks.STRIPPED_CRIMSON_HYPHAE)
                .add(Blocks.STRIPPED_WARPED_HYPHAE);

        getOrCreateTagBuilder(ModConventionalTags.Blocks.WOODS)
                .add(Blocks.ACACIA_WOOD)
                .add(Blocks.DARK_OAK_WOOD)
                .add(Blocks.OAK_WOOD)
                .add(Blocks.BIRCH_WOOD)
                .add(Blocks.SPRUCE_WOOD)
                .add(Blocks.CHERRY_WOOD)
                .add(Blocks.JUNGLE_WOOD)
                .add(Blocks.MANGROVE_WOOD)
                .add(Blocks.CRIMSON_HYPHAE)
                .add(Blocks.WARPED_HYPHAE);


        getOrCreateTagBuilder(ModTags.Blocks.CANDY_CANE_BLOCKS)
                .add(ModBlocks.WHITE_CANDY_CANE_BLOCK)
                .add(ModBlocks.LIGHT_GRAY_CANDY_CANE_BLOCK)
                .add(ModBlocks.GRAY_CANDY_CANE_BLOCK)
                .add(ModBlocks.BLACK_CANDY_CANE_BLOCK)
                .add(ModBlocks.BROWN_CANDY_CANE_BLOCK)
                .add(ModBlocks.RED_CANDY_CANE_BLOCK)
                .add(ModBlocks.ORANGE_CANDY_CANE_BLOCK)
                .add(ModBlocks.YELLOW_CANDY_CANE_BLOCK)
                .add(ModBlocks.LIME_CANDY_CANE_BLOCK)
                .add(ModBlocks.GREEN_CANDY_CANE_BLOCK)
                .add(ModBlocks.CYAN_CANDY_CANE_BLOCK)
                .add(ModBlocks.LIGHT_BLUE_CANDY_CANE_BLOCK)
                .add(ModBlocks.BLUE_CANDY_CANE_BLOCK)
                .add(ModBlocks.PURPLE_CANDY_CANE_BLOCK)
                .add(ModBlocks.MAGENTA_CANDY_CANE_BLOCK)
                .add(ModBlocks.PINK_CANDY_CANE_BLOCK);
    }
}
