package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.RegistryKey;
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
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class PlainsBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .category(Biome.Category.PLAINS)
            .depth(0.125F)
            .scale(0.05F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.8F)
            .downfall(0.4F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.8f))
            )
            .addStructureFeatures(ConfiguredStructureFeatures.VILLAGE_PLAINS, ConfiguredStructureFeatures.PILLAGER_OUTPOST, ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, PLAINS_TALL_GRASS, DEFAULT_VEGETATION, SPRINGS, PLAINS_FEATURES)
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome pumpkin_patch = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PUMPKIN_PATCH)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.PLAINS, BiomeRegistry.register("pumpkin_patch", pumpkin_patch), 0.3F);

        Biome sparse_forest = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LARGE_OAK_2_5)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.OAK_2_5)
                .build();
        RegistryKey<Biome> sparseForestKey = BiomeRegistry.register("sparse_forest", sparse_forest);
        OverworldBiomes.addHillsBiome(BiomeKeys.PLAINS, sparseForestKey, 1.F);
        OverworldBiomes.addBiomeVariant(BiomeKeys.PLAINS, sparseForestKey, 0.05f);

        Biome flower_field = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FLOWER_FIELD)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.PLAINS, BiomeRegistry.register("flower_field", flower_field), 0.1f);

        Biome lowlands = template.builder()
                .depth(-0.25f)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LOWLANDS_TREE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_2)
                .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.COD, 10, 6, 12))
                .scale(0.125f)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.PLAINS, BiomeRegistry.register("lowlands", lowlands), 0.1f);

        Biome plains_hills = template.builder()
                .depth(0.35f)
                .scale(0.4f)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.PLAINS, BiomeRegistry.register("plains_hills", plains_hills), 0.2F);

        //this is literally just traverse's biome but less cool
        Biome plains_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025f)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.PLAINS, BiomeRegistry.register("plains_plateau", plains_plateau), 0.2F);

        Biome rocky_plains = template.builder()
                .depth(0.2f)
                .addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, VanillaPlusConfiguredFeatures.FOREST_ROCK)
                .scale(0.2f)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.PLAINS, BiomeRegistry.register("rocky_plains", rocky_plains), 0.1f);
    }
}
