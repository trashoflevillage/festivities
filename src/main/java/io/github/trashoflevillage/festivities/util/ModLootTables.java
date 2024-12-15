package io.github.trashoflevillage.festivities.util;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static RegistryKey<LootTable> CHRISTMAS_GIFT_GAMEPLAY = of("gameplay/holiday_gifts/christmas");

    private static RegistryKey<LootTable> of(String id) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Festivities.MOD_ID, id));
    }
}
