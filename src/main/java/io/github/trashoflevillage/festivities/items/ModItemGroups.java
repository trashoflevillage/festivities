package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FESTIVITIES_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Festivities.MOD_ID, "mushroommadness"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.festivities"))
                    .icon(() -> new ItemStack(Items.SNOW_BLOCK))
                    .entries(((displayContext, entries) -> {
                        //entries.add();
                    }))
                    .build()
    );

    public static void registerItemGroups() {

    }

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemConvertible... items) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            for (ItemConvertible i : items)
                content.add(i);
        });
    }
}
