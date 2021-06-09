package supercoder79.vanillaplusbiomes.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
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
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static supercoder79.vanillaplusbiomes.biomes.api.DefaultFeature.*;

public class SnowyTaigaBiomes {

    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .category(Biome.Category.FOREST)
            .depth(0.2F)
            .scale(0.2F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(-0.5F)
            .downfall(0.4F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(-0.5f))
            )
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES,
                    FROZEN_TOP_LAYER)
            .addStructureFeatures(ConfiguredStructureFeatures.VILLAGE_SNOWY, ConfiguredStructureFeatures.PILLAGER_OUTPOST, ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4))
    );

    public static void register() {
        Biome snowy_taiga_lake = template.builder()
                .depth(-0.3F)
                .scale(0)
                .addDefaultFeature(TAIGA_TREES)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_lake", snowy_taiga_lake), 2F);
        Biome snowy_taiga_clearing = template.builder()
                .scale(0.1F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_FALLEN_TREE)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_clearing", snowy_taiga_clearing), 2F);
        Biome snowy_berry_fields = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_3)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_3)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BERRY_FIELDS)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("snowy_berry_fields", snowy_berry_fields), 0.5F);
        Biome snowy_taiga_edge = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_1)
                .build();
        OverworldBiomes.addEdgeBiome(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_edge", snowy_taiga_edge), 1F);

        Biome snowy_pine_taiga = template.builder()
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_7)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("snowy_pine_taiga", snowy_pine_taiga), 0.1F);

        Biome tall_snowy_taiga = template.builder()
                .depth(0.1F)
                .scale(0.05F)
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_SPRUCE)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("tall_snowy_taiga", tall_snowy_taiga), 0.1F);

        Biome tall_snowy_pine_taiga = template.builder()
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_PINE)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.SNOWY_TAIGA, BiomeRegistry.register("tall_snowy_pine_taiga", tall_snowy_pine_taiga), 0.1F);
    }
}
