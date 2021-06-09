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

public class ForestBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.7F)
            .downfall(0.8F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.7f))
            )
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, FOREST_GRASS, SPRINGS)
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome forest_clearing = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FALLEN_OAK_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_TREES_3)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.FOREST, BiomeRegistry.register("forest_clearing", forest_clearing), 1.F);
        Biome forest_thicket = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_TREES_20)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.FOREST, BiomeRegistry.register("forest_thicket", forest_thicket), 0.5F);
        Biome forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_RIVER)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_TREES_4)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_1)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.FOREST, BiomeRegistry.register("forest_lake", forest_lake), 0.5F);

        Biome forest_edge = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_TREES_3)
                .build();
        OverworldBiomes.addEdgeBiome(BiomeKeys.FOREST, BiomeRegistry.register("forest_edge", forest_edge), 0.5F);

        Biome tall_forest = template.builder()
                .depth(0.1F)
                .scale(0.3F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_FOREST_TREES)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.FOREST, BiomeRegistry.register("tall_forest", tall_forest), 0.1F);

        Biome forest_scrub = template.builder()
                .depth(0.1F)
                .scale(0.1F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BIRCH_OTHER)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.FOREST, BiomeRegistry.register("forest_scrub", forest_scrub), 0.1F);

        Biome flooded_forest = template.builder()
                .depth(-0.1F)
                .scale(0.1F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FLOODED_FOREST_TREES)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.FOREST, BiomeRegistry.register("flooded_forest", flooded_forest), 0.1F);
    }
}
