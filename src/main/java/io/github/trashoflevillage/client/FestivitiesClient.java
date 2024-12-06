package io.github.trashoflevillage.client;

import io.github.trashoflevillage.festivities.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.Item;

@Environment(EnvType.CLIENT)
public class FestivitiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerItemColor(ModItems.JOLLY_LEATHER_HELMET);
    }

    private void registerItemColor(Item item) {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedColorComponent.getColor(stack, -6265536), item);
    }
}
