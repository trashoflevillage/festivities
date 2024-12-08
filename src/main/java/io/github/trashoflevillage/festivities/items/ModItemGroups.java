package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItemGroups {
    private static final ItemStack CREATIVE_TAB_ICON = new ItemStack(ModItems.JOLLY_HELMET);

    public static final ItemGroup FESTIVITIES_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Festivities.MOD_ID, "mushroommadness"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.festivities"))
                    .icon(() -> DyedColorComponent.setColor(CREATIVE_TAB_ICON, List.of((DyeItem)Items.RED_DYE)))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.JOLLY_HELMET);
                        entries.add(ModBlocks.RED_CANDY_CANE_BLOCK);
                        entries.add(ModBlocks.GREEN_CANDY_CANE_BLOCK);
                        entries.add(ModBlocks.GIFTBOX);
                        entries.add(ModBlocks.FAIRY_LIGHT_BLOCK);
                        entries.add(ModItems.HOLIDAY_BUNDLE);
                    }))
                    .build()
    );

    public static void registerItemGroups() {
        addItemsToItemGroup(ItemGroups.COMBAT,
                ModItems.JOLLY_HELMET
        );
        addItemsToItemGroup(ItemGroups.FUNCTIONAL,
                ModBlocks.GIFTBOX
        );
        addItemsToItemGroup(ItemGroups.BUILDING_BLOCKS,
                ModBlocks.RED_CANDY_CANE_BLOCK,
                ModBlocks.GREEN_CANDY_CANE_BLOCK,
                ModBlocks.FAIRY_LIGHT_BLOCK
        );
        addItemsToItemGroup(ItemGroups.REDSTONE,
                ModBlocks.FAIRY_LIGHT_BLOCK
        );
    }

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemConvertible... items) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            for (ItemConvertible i : items)
                content.add(i);
        });
    }
}
