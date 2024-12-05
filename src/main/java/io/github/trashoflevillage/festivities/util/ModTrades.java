package io.github.trashoflevillage.festivities.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.Optional;

public class ModTrades {
    public static void registerTrades() {
        registerCartographerTrades();
    }

    private static void registerCartographerTrades() {
//            TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2, factories -> {
//            sfactories.add((entity, random) -> new TradeOffer(
//                    new TradedItem(Items.EMERALD, 13),
//                    Optional.of(new TradedItem(Items.COMPASS)),
//                    ModExplorerMaps.getMycologistTowerExplorerMap(entity.getBlockPos(), (ServerWorld)entity.getWorld()),
//                    12, 5, 0.2f
//            ));
//        });
    }
}
