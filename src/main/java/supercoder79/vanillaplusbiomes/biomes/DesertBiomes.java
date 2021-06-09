package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.biomes.api.BiomeTemplate;
import supercoder79.vanillaplusbiomes.biomes.api.TerraformBiomeBuilder;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class DesertBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.FULL_SAND)
            .category(Biome.Category.DESERT)
            .depth(0.125F)
            .scale(0.05F)
            .precipitation(Biome.Precipitation.NONE)
            .temperature(2.0F)
            .downfall(0.0F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(2.0f))
            )
            .addStructureFeatures(ConfiguredStructureFeatures.DESERT_PYRAMID, ConfiguredStructureFeatures.PILLAGER_OUTPOST, ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_GRASS, DESERT_VEGETATION, FOSSILS, SPRINGS)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.HUSK, 80, 4, 4))
    );
    public static void register() {
        Biome red_desert = template.builder()
                .surfaceBuilder(VanillaPlusConfiguredSurfaceBuilders.RED_DESERT)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.CACTUS_5)
                .build();
        RegistryKey<Biome> redDesertKey = BiomeRegistry.register("red_desert", red_desert);
        OverworldBiomes.addBiomeVariant(BiomeKeys.DESERT, redDesertKey, 0.1);

        Biome oasis = template.builder()
                .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
                .addDefaultFeature(JUNGLE_GRASS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.JUNGLE_4)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SUGARCANE_128)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_1)
                .depth(-0.25f)
                .scale(0)
                .temperature(1)
                .downfall(1)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4445678)
                        .waterFogColor(270131)
                        .fogColor(12638463)
                        .skyColor(BiomeHelper.getSkyColor(1.0f))
                )
                .build();

        RegistryKey<Biome> oasisKey = BiomeRegistry.register("oasis", oasis);
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT, oasisKey, 0.1F);
        OverworldBiomes.addHillsBiome(redDesertKey, oasisKey, 0.05F);

        Biome lush_desert = template.builder()
                .depth(0.075F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.CACTUS_100)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DEAD_BUSH_5)
                .addDefaultFeature(LAKES)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT, BiomeRegistry.register("lush_desert", lush_desert), 1.F);

        Biome barren_desert = template.builder()
                .depth(0.2F)
                .scale(0.1F)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT, BiomeRegistry.register("barren_desert", barren_desert), 2.F);

        Biome desert_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.CACTUS_10)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DEAD_BUSH_2)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT, BiomeRegistry.register("desert_plateau", desert_plateau), 1.F);

        Biome red_desert_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025F)
                .surfaceBuilder(VanillaPlusConfiguredSurfaceBuilders.RED_DESERT)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.CACTUS_10)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DEAD_BUSH_2)
                .build();
        OverworldBiomes.addHillsBiome(redDesertKey, BiomeRegistry.register("red_desert_plateau", red_desert_plateau), 1.F);
    }
}