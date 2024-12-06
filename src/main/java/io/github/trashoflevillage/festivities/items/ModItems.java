package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item JOLLY_LEATHER_HELMET =
            registerItem("jolly_leather_helmet", new ArmorItem(ModArmorMaterials.JOLLY_LEATHER, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.JOLLY_LEATHER_DURABILITY_MULTIPLIER))));

    public static void registerModItems() {
        Festivities.LOGGER.info("Registering items for " + Festivities.MOD_ID + ".");
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Festivities.MOD_ID, name), item);
    }
}