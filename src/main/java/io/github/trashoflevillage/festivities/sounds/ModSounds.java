package io.github.trashoflevillage.festivities.sounds;

import io.github.trashoflevillage.festivities.Festivities;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CHRISTMAS_MUSIC = registerSoundEvent("christmas_music");

    public static void registerSounds() {
        Festivities.LOGGER.info(("Registering sounds for " + Festivities.MOD_ID));

        ModMusicType.registerModMusic();
    }

    private static void registerReference(String name) {
        Identifier ID = Identifier.of(Festivities.MOD_ID, name);
        Registry.registerReference(Registries.SOUND_EVENT, ID, SoundEvent.of(ID));
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Festivities.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
