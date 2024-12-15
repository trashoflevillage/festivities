package io.github.trashoflevillage.festivities.access;

import io.github.trashoflevillage.festivities.Festivities;
import org.spongepowered.asm.mixin.Unique;

public interface WorldMixinAccess {

    @Unique
    void setHolidayOverride(Festivities.Holiday holiday);

    @Unique
    Festivities.Holiday getHolidayOverride();
}
