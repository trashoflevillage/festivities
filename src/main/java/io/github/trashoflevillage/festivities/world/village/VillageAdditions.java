package io.github.trashoflevillage.festivities.world.village;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.util.Identifier;

public class VillageAdditions {
    public static void registerNewVillageStructures() {
        FabricStructurePoolRegistry.registerSimple(
                Identifier.ofVanilla("village/snowy/houses"),
                Identifier.of(Festivities.MOD_ID, "village/snowy/houses/festive_house"), 50
        );
    }
}
