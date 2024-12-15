package io.github.trashoflevillage.festivities;

import com.google.common.collect.ImmutableList;
import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.items.ModArmorMaterials;
import io.github.trashoflevillage.festivities.items.ModItemGroups;
import io.github.trashoflevillage.festivities.items.ModItems;
import io.github.trashoflevillage.festivities.sounds.ModSounds;
import io.github.trashoflevillage.festivities.villager.ModTrades;
import io.github.trashoflevillage.festivities.villager.ModVillagers;
import io.github.trashoflevillage.festivities.world.village.VillageAdditions;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Festivities implements ModInitializer {
	public static final String MOD_ID = "festivities";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModSounds.registerSounds();
		ModArmorMaterials.initialize();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		VillageAdditions.registerNewVillageStructures();
		ModVillagers.registerVillagers();
		ModTrades.registerTrades();
	}

	public static boolean isChristmas() {
		LocalDate localDate = LocalDate.now();
		int month = localDate.get(ChronoField.MONTH_OF_YEAR);
		return (month == 12);
	}

	public static boolean isHalloween() {
		LocalDate localDate = LocalDate.now();
		int month = localDate.get(ChronoField.MONTH_OF_YEAR);
		return (month == 10);
	}
}