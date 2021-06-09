package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.biomes.api.BiomeTemplate;
import supercoder79.vanillaplusbiomes.biomes.api.TerraformBiomeBuilder;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class MesaBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.BADLANDS)
            .category(Biome.Category.DESERT)
            .depth(1.575F)
            .scale(0.04F)
            .precipitation(Biome.Precipitation.NONE)
            .temperature(2.0F)
            .downfall(0.0F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .foliageColor(10387789)
                    .grassColor(9470285)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(2.0f))
            )
            .addStructureFeatures(ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT_MESA)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, EXTRA_GOLD,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, BADLANDS_GRASS, BADLANDS_VEGETATION, SPRINGS, BADLANDS_VEGETATION)

            .addDefaultSpawnEntries()
    );

    public static void register() {
        // inspired by https://www.reddit.com/r/Minecraft/comments/h0f5vi/my_take_on_a_mesa_biome/
        Biome rocky_badlands_plateau = template.builder()
                .surfaceBuilder(VanillaPlusConfiguredSurfaceBuilders.ROCKY_BADLANDS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.OAK_5)
                .build();
        RegistryKey<Biome> rockyBadlandsPlateauKey = BiomeRegistry.register("rocky_badlands_plateau", rocky_badlands_plateau);

        OverworldBiomes.addBiomeVariant(BiomeKeys.BADLANDS_PLATEAU, rockyBadlandsPlateauKey, 0.1);
//        OverworldBiomesExt.addBorderBiome(rockyBadlandsPlateauKey, BiomeKeys.BADLANDS);

        Biome weathered_badlands_plateau = template.builder()
                .surfaceBuilder(VanillaPlusConfiguredSurfaceBuilders.WEATHERED_BADLANDS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SMALL_WEATHERED_TREE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.WEATHERED_TREE)
                .build();
        RegistryKey<Biome> weatheredBadlandsPlateau = BiomeRegistry.register("weathered_badlands_plateau", weathered_badlands_plateau);

        OverworldBiomes.addBiomeVariant(BiomeKeys.BADLANDS_PLATEAU, weatheredBadlandsPlateau, 0.1);
//        OverworldBiomesExt.addBorderBiome(weatheredBadlandsPlateau, BiomeKeys.BADLANDS);
    }
}
