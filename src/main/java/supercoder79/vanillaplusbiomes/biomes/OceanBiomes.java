package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.biomes.api.BiomeTemplate;
import supercoder79.vanillaplusbiomes.biomes.api.TerraformBiomeBuilder;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class OceanBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.OCEAN_SAND).category(Biome.Category.OCEAN)
            .depth(-1.0f)
            .scale(-0.02f)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.5F)
            .downfall(0.5F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.5f))
            )
            .addDefaultFeatures(OCEAN_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, WATER_BIOME_OAK_TREES, DEFAULT_VEGETATION, SPRINGS, SEAGRASS_ON_STONE, KELP)
            .addStructureFeatures(ConfiguredStructureFeatures.SHIPWRECK_BEACHED, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SQUID, 1, 1, 4))
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.COD, 10, 3, 6))
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 1, 1, 2))
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.DROWNED, 5, 1, 1))

    );
    public static void register() {
        Biome ocean_lagoon = template.builder()
                .depth(-0.4f)
                .addStructureFeature(ConfiguredStructureFeatures.OCEAN_RUIN_COLD)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.OCEAN, BiomeRegistry.register("ocean_lagoon", ocean_lagoon), 0.05);
        Biome cold_ocean_lagoon = template.builder()
                .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
                .depth(-0.5f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(BiomeHelper.getSkyColor(0.5f))
                )
                .addStructureFeature(ConfiguredStructureFeatures.OCEAN_RUIN_COLD)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_COLD)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.OCEAN, BiomeRegistry.register("cold_ocean_lagoon", cold_ocean_lagoon), 0.05);
        Biome lukewarm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4566514)
                        .waterFogColor(267827)
                        .fogColor(12638463)
                        .skyColor(BiomeHelper.getSkyColor(0.5f))
                )
                .addStructureFeature(ConfiguredStructureFeatures.OCEAN_RUIN_WARM)
                .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_WARM)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.OCEAN, BiomeRegistry.register("lukewarm_ocean_lagoon", lukewarm_ocean_lagoon), 0.05);
        Biome warm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4445678)
                        .waterFogColor(270131)
                        .fogColor(12638463)
                        .skyColor(BiomeHelper.getSkyColor(0.5f))
                )
                .addStructureFeature(ConfiguredStructureFeatures.OCEAN_RUIN_WARM)
                .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEA_PICKLE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_WARM)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.WARM_OCEAN_VEGETATION)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.OCEAN, BiomeRegistry.register("warm_ocean_lagoon", warm_ocean_lagoon), 0.05);
    }
}
