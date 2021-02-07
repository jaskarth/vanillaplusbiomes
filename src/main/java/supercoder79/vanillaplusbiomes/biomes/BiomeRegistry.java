package supercoder79.vanillaplusbiomes.biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BiomeRegistry {
    public static RegistryKey<Biome> register(String name, Biome biome) {
        Identifier id = new Identifier("vanillaplusbiomes", name);
        Registry.register(BuiltinRegistries.BIOME, id, biome);

        return RegistryKey.of(Registry.BIOME_KEY, id);
    }
}
