package io.github.trashoflevillage.festivities.villager;


import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.Optional;

public class ModTrades {
    public static void registerTrades() {
        registerGiftmakerTrades();
    }

    private static void registerGiftmakerTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.GREEN_CANDY_CANE_BLOCK, 16),
                    12, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.RED_CANDY_CANE_BLOCK, 16),
                    12, 1, 0.05f
            ));
        });
    }
}

