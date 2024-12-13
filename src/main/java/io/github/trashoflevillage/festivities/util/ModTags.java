package io.github.trashoflevillage.festivities.util;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CANDY_CANE_BLOCKS =
                createTag("candy_cane_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Festivities.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CANDY_CANE_BLOCKS =
                createTag("candy_cane_blocks");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Festivities.MOD_ID, name));
        }
    }

    public static class Structures {
        private static TagKey<Structure> createTag(String name) {
            return TagKey.of(RegistryKeys.STRUCTURE, Identifier.of(Festivities.MOD_ID, name));
        }
    }
}
