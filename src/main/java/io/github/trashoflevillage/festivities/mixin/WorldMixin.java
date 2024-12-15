package io.github.trashoflevillage.festivities.mixin;

import io.github.trashoflevillage.festivities.Festivities;
import io.github.trashoflevillage.festivities.access.WorldMixinAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(World.class)
public class WorldMixin implements WorldMixinAccess {
    @Unique
    private Festivities.Holiday holidayOverride = Festivities.Holiday.NONE;

    @Unique
    public void setHolidayOverride(Festivities.Holiday holiday) {
        holidayOverride = holiday;
    }

    @Unique
    public Festivities.Holiday getHolidayOverride() {
        return holidayOverride;
    }
}
