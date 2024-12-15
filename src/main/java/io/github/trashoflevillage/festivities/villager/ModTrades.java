package io.github.trashoflevillage.festivities.villager;


import io.github.trashoflevillage.festivities.blocks.ModBlocks;
import io.github.trashoflevillage.festivities.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

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
                    5, 2, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.SNOW_BLOCK, 2),
                    5, 2, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.CARVED_PUMPKIN, 1),
                    5, 2, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.COOKIE, 3),
                    5, 2, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.MILK_BUCKET, 1),
                    5, 2, LOW_PRICE_MULTIPLER
            ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 2, factories -> {
            int candyCaneTradeMaxUses = 12;
            int candyCaneTradeMechantExperience = 10;
            int candyCaneTradeCount = 16;
            int candyCaneTradePrice = 3;
            ItemConvertible[] candyCaneTypes = new ItemConvertible[] {
                    ModBlocks.WHITE_CANDY_CANE_BLOCK,
                    ModBlocks.LIGHT_GRAY_CANDY_CANE_BLOCK,
                    ModBlocks.GRAY_CANDY_CANE_BLOCK,
                    ModBlocks.BLACK_CANDY_CANE_BLOCK,
                    ModBlocks.BROWN_CANDY_CANE_BLOCK,
                    ModBlocks.RED_CANDY_CANE_BLOCK,
                    ModBlocks.ORANGE_CANDY_CANE_BLOCK,
                    ModBlocks.YELLOW_CANDY_CANE_BLOCK,
                    ModBlocks.LIME_CANDY_CANE_BLOCK,
                    ModBlocks.GREEN_CANDY_CANE_BLOCK,
                    ModBlocks.CYAN_CANDY_CANE_BLOCK,
                    ModBlocks.LIGHT_BLUE_CANDY_CANE_BLOCK,
                    ModBlocks.BLUE_CANDY_CANE_BLOCK,
                    ModBlocks.PURPLE_CANDY_CANE_BLOCK,
                    ModBlocks.MAGENTA_CANDY_CANE_BLOCK,
                    ModBlocks.PINK_CANDY_CANE_BLOCK
            };

            for (ItemConvertible i : candyCaneTypes) {
                factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(Items.EMERALD, candyCaneTradePrice),
                        new ItemStack(i, candyCaneTradeCount),
                        candyCaneTradeMaxUses, candyCaneTradeMechantExperience, LOW_PRICE_MULTIPLER
                ));
            }
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 15),
                    ModItems.getRandomlyColoredJollyHat(random),
                    5, 20, HIGH_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModBlocks.FAIRY_LIGHT_BLOCK, 2),
                    5, 20, LOW_PRICE_MULTIPLER
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.SUGAR_COOKIE, 18),
                    12, 15, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(ModItems.FRUITCAKE, 4),
                    12, 15, LOW_PRICE_MULTIPLER
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GIFTMAKER, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.EGGNOG, 8),
                    12, 15, LOW_PRICE_MULTIPLER
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 64),
                    new ItemStack(ModBlocks.MAGIC_SNOWGLOBE, 1),
                    12, 15, HIGH_PRICE_MULTIPLER
            ));
        });
    }
}

