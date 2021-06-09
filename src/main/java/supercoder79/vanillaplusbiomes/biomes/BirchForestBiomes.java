package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.biomes.api.BiomeTemplate;
import supercoder79.vanillaplusbiomes.biomes.api.TerraformBiomeBuilder;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class BirchForestBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.6F)
            .downfall(0.6F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.6f))
            )
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    FOREST_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS)
            .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.GRASS_2)
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome birch_forest_clearing = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_FALLEN_TREE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_3)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.BIRCH_FOREST, BiomeRegistry.register("birch_forest_clearing", birch_forest_clearing), 1.F);
        Biome birch_forest_thicket = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_SHRUB)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_20)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.BIRCH_FOREST, BiomeRegistry.register("birch_forest_thicket", birch_forest_thicket), 0.5F);
        Biome birch_forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_RIVER)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_5)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.BIRCH_FOREST, BiomeRegistry.register("birch_forest_lake", birch_forest_lake), 0.5F);
        Biome birch_forest_edge = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BIRCH_5)
                .build();
        OverworldBiomes.addEdgeBiome(BiomeKeys.BIRCH_FOREST, BiomeRegistry.register("birch_forest_edge", birch_forest_edge), 0.5F);
    }
}
