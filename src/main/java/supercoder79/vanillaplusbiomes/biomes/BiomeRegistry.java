package supercoder79.vanillaplusbiomes.biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class BiomeRegistry {
    public static Biome register(String name, Biome biome) {
        return Registry.register(Registry.BIOME, new Identifier("vanillaplusbiomes", name), biome);
    }
}
