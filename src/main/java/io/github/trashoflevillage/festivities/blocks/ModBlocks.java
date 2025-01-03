package io.github.trashoflevillage.festivities.blocks;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.blocks.custom.FairyLightBlock;
import io.github.trashoflevillage.festivities.blocks.custom.MagicSnowglobeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static Block BLACK_CANDY_CANE_BLOCK = registerBlock("black_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block BLUE_CANDY_CANE_BLOCK = registerBlock("blue_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block BROWN_CANDY_CANE_BLOCK = registerBlock("brown_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block CYAN_CANDY_CANE_BLOCK = registerBlock("cyan_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block GRAY_CANDY_CANE_BLOCK = registerBlock("gray_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block LIGHT_BLUE_CANDY_CANE_BLOCK = registerBlock("light_blue_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block LIGHT_GRAY_CANDY_CANE_BLOCK = registerBlock("light_gray_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block LIME_CANDY_CANE_BLOCK = registerBlock("lime_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block MAGENTA_CANDY_CANE_BLOCK = registerBlock("magenta_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block ORANGE_CANDY_CANE_BLOCK = registerBlock("orange_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block PINK_CANDY_CANE_BLOCK = registerBlock("pink_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block PURPLE_CANDY_CANE_BLOCK = registerBlock("purple_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block WHITE_CANDY_CANE_BLOCK = registerBlock("white_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block YELLOW_CANDY_CANE_BLOCK = registerBlock("yellow_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block RED_CANDY_CANE_BLOCK = registerBlock("red_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static Block GREEN_CANDY_CANE_BLOCK = registerBlock("green_candy_cane_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static Block GIFTBOX = registerBlock("giftbox", new Block(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)));
    public static Block FAIRY_LIGHT_BLOCK = registerBlock("fairy_light_block", new FairyLightBlock(AbstractBlock.Settings.copy(Blocks.GLASS).luminance(
            state -> 15
    )));
    public static Block MAGIC_SNOWGLOBE = registerBlock("magic_snowglobe", new MagicSnowglobeBlock(AbstractBlock.Settings.copy(Blocks.GLASS)));

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
