package io.github.trashoflevillage.festivities.villager;


import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.Optional;

public class ModTrades {
    private static final float LOW_PRICE_MULTIPLER = 0.05F;
    private static final float HIGH_PRICE_MULTIPLER = 0.2F;

    public static void registerTrades() {
        registerGiftmakerTrades();
    }

    private static void registerGiftmakerTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.SNOWBALL, 8),
                    5, 5, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.SNOW_BLOCK, 2),
                    5, 5, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.CARVED_PUMPKIN, 1),
                    5, 5, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.COOKIE, 4),
                    5, 5, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.MILK_BUCKET, 1),
                    5, 5, LOW_PRICE_MULTIPLER
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.GREEN_CANDY_CANE_BLOCK, 16),
                    12, 10, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.RED_CANDY_CANE_BLOCK, 16),
                    12, 10, LOW_PRICE_MULTIPLER
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 15),
                    ModItems.getRandomlyColoredJollyHat(random),
                    5, 25, HIGH_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.FAIRY_LIGHT_BLOCK, 2),
                    5, 25, LOW_PRICE_MULTIPLER
            ));
        });
    }
}

