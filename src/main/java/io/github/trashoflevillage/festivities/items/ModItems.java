package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Festivities.MOD_ID, name), item);
    }
    
    public static void registerModItems() {
        Festivities.LOGGER.info("Registering items for " + Festivities.MOD_ID + ".");
    }
}