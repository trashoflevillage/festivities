package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;

import java.util.Arrays;
import java.util.List;

public class ModItems {
    public static final Item JOLLY_HELMET =
            registerItem("jolly_helmet", new ArmorItem(ModArmorMaterials.JOLLY, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.JOLLY_DURABILITY_MULTIPLIER))));
    public static final Item HOLIDAY_BUNDLE =
            registerItem("holiday_bundle", new BundleItem(new Item.Settings().maxCount(1)));

    public static void registerModItems() {
        Festivities.LOGGER.info("Registering items for " + Festivities.MOD_ID + ".");
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Festivities.MOD_ID, name), item);
    }

    public static ItemStack getRandomlyColoredJollyHat(Random random) {
        return getRandomlyColoredJollyHat(random, 1);
    }

    public static ItemStack getRandomlyColoredJollyHat(Random random, int depth) {
        Item[] dyes = new Item[] {
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

        DyeItem[] dyesToAdd = new DyeItem[depth];
        for (int i = 0; i < depth; i++) {
            dyesToAdd[i] = (DyeItem)dyes[random.nextBetween(0, dyes.length - 1)];
        }
        return DyedColorComponent.setColor(new ItemStack(ModItems.JOLLY_HELMET), Arrays.stream(dyesToAdd).toList());
    }
}