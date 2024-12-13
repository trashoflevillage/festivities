package io.github.trashoflevillage.festivities.datagen;

import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateCandyCaneBlockRecipes(exporter);
    }

    private void generateCandyCaneBlockRecipes(RecipeExporter exporter) {
        ItemConvertible[] candyCaneBlocks = new ItemConvertible[] {
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
        ItemConvertible[] dyes = new ItemConvertible[] {
                Items.WHITE_DYE,
                Items.LIGHT_GRAY_DYE,
                Items.GRAY_DYE,
                Items.BLACK_DYE,
                Items.BROWN_DYE,
                Items.RED_DYE,
                Items.ORANGE_DYE,
                Items.YELLOW_DYE,
                Items.LIME_DYE,
                Items.GREEN_DYE,
                Items.CYAN_DYE,
                Items.LIGHT_BLUE_DYE,
                Items.BLUE_DYE,
                Items.PURPLE_DYE,
                Items.MAGENTA_DYE,
                Items.PINK_DYE
        };

        for (int i = 0; i < candyCaneBlocks.length; i++) {
            ItemConvertible candyCaneBlock = candyCaneBlocks[i];
            ItemConvertible dyeItem = dyes[i];
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, candyCaneBlock, 8)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(ModTags.Items.CANDY_CANE_BLOCKS)
                    .input(dyeItem)
                    .group("concrete_powder")
                    .criterion("has_candy_cane_block", conditionsFromTag(ModTags.Items.CANDY_CANE_BLOCKS))
                    .offerTo(exporter);
        }
    }
}
