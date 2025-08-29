package net.hasnat4763.sound;

import net.hasnat4763.Nusiam;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent NUSIAM_ORE_BREAK = registerSoundEvent("nusiam_ore_break");
    public static final SoundEvent NUSIAM_ORE_PLACE = registerSoundEvent("nusiam_ore_place");
    public static final SoundEvent NUSIAM_ORE_HIT = registerSoundEvent("nusiam_ore_hit");
    public static final SoundEvent NUSIAM_ORE_STEP = registerSoundEvent("nusiam_ore_step");
    public static final SoundEvent NUSIAM_ORE_FALL = registerSoundEvent("nusiam_ore_fall");


    public static final BlockSoundGroup NUSIAM_SOUNDS = new BlockSoundGroup(1f,1f, NUSIAM_ORE_BREAK, NUSIAM_ORE_STEP, NUSIAM_ORE_PLACE, NUSIAM_ORE_HIT, NUSIAM_ORE_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Nusiam.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Nusiam.LOGGER.info("registering sound for" + Nusiam.MOD_ID);
    }
}
