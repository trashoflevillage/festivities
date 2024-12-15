package io.github.trashoflevillage.festivities.server;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class HolidayOverridePayload implements CustomPayload {
    public static final CustomPayload.Id<HolidayOverridePayload> id = new CustomPayload.Id<>(Identifier.of(Festivities.MOD_ID, "holiday_override"));

    @Override
    public Id<? extends CustomPayload> getId() {
        return id;
    }
}
