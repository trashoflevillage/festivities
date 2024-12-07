package io.github.trashoflevillage.festivities.villager;

import com.google.common.collect.ImmutableSet;
import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> GIFTBOX_POI_KEY = poiKey("giftbox");
    public static final PointOfInterestType GIFTBOX_POI = registerPoi("giftbox", ModBlocks.GIFTBOX);

    public static final VillagerProfession GIFTMAKER = registerProfession("giftmaker", GIFTBOX_POI_KEY, SoundEvents.BLOCK_WOOL_PLACE);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent sound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(Festivities.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), sound));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(Festivities.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Festivities.MOD_ID, name));
    }

    public static void registerVillagers() {

    }
}
