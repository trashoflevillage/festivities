package io.github.trashoflevillage.festivities.items;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final int JOLLY_LEATHER_DURABILITY_MULTIPLIER = 5;
    public static final RegistryEntry<ArmorMaterial> JOLLY_LEATHER = registerMaterial("jolly_leather",
        // Defense (protection) point values for each armor piece.
        Map.of(
                ArmorItem.Type.HELMET, 1,
                ArmorItem.Type.CHESTPLATE, 3,
                ArmorItem.Type.LEGGINGS, 2,
                ArmorItem.Type.BOOTS, 1
        ),
        // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
        15,
        // The sound played when the armor is equipped.
        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
        // The ingredient(s) used to repair the armor.
        () -> Ingredient.ofItems(Items.LEATHER),
        0.0F,
        0.0F,
        true
    );

    public static void initialize() {

    }

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers;
        if (dyeable)
            layers = List.of(
                    new ArmorMaterial.Layer(Identifier.of(Festivities.MOD_ID, id), "", true),
                    new ArmorMaterial.Layer(Identifier.of(Festivities.MOD_ID, id), "_overlay", false)
            );
        else
            layers = List.of(
                    new ArmorMaterial.Layer(Identifier.of(Festivities.MOD_ID, id), "", false)
            );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(Festivities.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }
}
