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
        if (helmet.isOf(Items.PUMPKIN) || helmet.isOf(Items.JACK_O_LANTERN))
            entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.AIR));

        if (helmet.isEmpty() && random.nextFloat() < 0.25F) {
            if (Festivities.isHalloween()) {
                entity.equipStack(EquipmentSlot.HEAD, new ItemStack(random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
            }
            else if (Festivities.isChristmas()) {
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
                entity.equipStack(EquipmentSlot.HEAD, DyedColorComponent.setColor(new ItemStack(ModItems.JOLLY_LEATHER_HELMET), List.of((DyeItem)dyes[
                        random.nextBetween(0, dyes.length - 1)
                ])));
            }
        }
    }
}
