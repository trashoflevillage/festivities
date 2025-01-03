package io.github.trashoflevillage.festivities.sounds;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ModMusicType {
    public static final MusicSound CHRISTMAS = new MusicSound(RegistryEntry.of(ModSounds.CHRISTMAS_MUSIC), 20, 600, true);

    public static MusicSound getHolidayMusic(World world) {
        if (Festivities.isChristmas(world)) return CHRISTMAS;
        return null;
    }

    public static void registerModMusic() {}
}
