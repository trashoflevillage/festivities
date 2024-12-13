package io.github.trashoflevillage.festivities.datagen;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_GRAY_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROWN_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIME_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYAN_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_BLUE_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGENTA_CANDY_CANE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_CANDY_CANE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
