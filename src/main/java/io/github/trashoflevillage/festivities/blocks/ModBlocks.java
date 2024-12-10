package io.github.trashoflevillage.festivities.blocks;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.blocks.custom.FairyLightBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static Block RED_CANDY_CANE_BLOCK = registerBlock("red_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block GREEN_CANDY_CANE_BLOCK = registerBlock("green_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block GIFTBOX = registerBlock("giftbox", new Block(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)));
    public static Block FAIRY_LIGHT_BLOCK = registerBlock("fairy_light_block", new FairyLightBlock(AbstractBlock.Settings.copy(Blocks.GLASS).luminance(
            state -> 15
    )));

    private static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, true);
    }

    private static Block registerBlock(String name, Block block, boolean hasBlockItem) {
        if (hasBlockItem) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                Identifier.of(Festivities.MOD_ID, name),
                block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(Festivities.MOD_ID, name),
                new BlockItem(block,
                        new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block, Item.Settings itemSettings) {
        registerBlockItem(name, block, itemSettings);
        return Registry.register(Registries.BLOCK,
                Identifier.of(Festivities.MOD_ID, name),
                block);
    }

    private static Item registerBlockItem(String name, Block block, Item.Settings settings) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(Festivities.MOD_ID, name),
                new BlockItem(block,
                        settings));
    }

    public static void registerModBlocks() {
        Festivities.LOGGER.info("Registering blocks for " + Festivities.MOD_ID);
    }

    private static void addWaxingRecipe(Block from, Block to) {
        HoneycombItem.UNWAXED_TO_WAXED_BLOCKS.get().put(from, to);
    }

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return createLightLevelFromLitBlockState(litLevel, 0);
    }

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel, int unlitLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : unlitLevel;
        };
    }
}
