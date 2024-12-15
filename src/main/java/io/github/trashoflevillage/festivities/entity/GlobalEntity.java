package io.github.trashoflevillage.festivities.entity;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;

import java.util.List;

public class GlobalEntity {
    public static void initHolidayEquipment(HostileEntity entity) {
        ItemStack helmet = entity.getEquippedStack(EquipmentSlot.HEAD);
        Random random = entity.getRandom();

        // BUG:
        // IF CHRISTMAS IS ENABLED ON HALLOWEEN DAY, MOBS CAN STILL SPAWN WITH PUMPKINS/JACKOLANTERNS ON THEIR HEADS.
        if (helmet.isOf(Items.PUMPKIN) || helmet.isOf(Items.JACK_O_LANTERN))
            entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.AIR));

        if (helmet.isEmpty() && random.nextFloat() < 0.25F) {
            if (Festivities.isHalloween(entity.getWorld())) {
                entity.equipStack(EquipmentSlot.HEAD, new ItemStack(random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
            }
            else if (Festivities.isChristmas(entity.getWorld())) {
                entity.equipStack(EquipmentSlot.HEAD, ModItems.getRandomlyColoredJollyHat(random, random.nextBetween(1, 5)));
            }
        }
    }
}
