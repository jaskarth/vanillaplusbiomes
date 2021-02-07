package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class TaigaBiomes {

    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .category(Biome.Category.FOREST)
            .depth(0.35F)
            .scale(0.2F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.8F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.25f))
            )
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES, FROZEN_TOP_LAYER)
            .addStructureFeatures(ConfiguredStructureFeatures.VILLAGE_TAIGA, ConfiguredStructureFeatures.PILLAGER_OUTPOST, ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4))
    );
    public static void register() {
        Biome taiga_lake = template.builder()
                .depth(-0.3F)
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_RIVER)
                .addDefaultFeature(TAIGA_TREES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_1)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.TAIGA, BiomeRegistry.register("taiga_lake", taiga_lake), 2F);
        Biome taiga_clearing = template.builder()
                .scale(0.1F)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_FALLEN_TREE)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.TAIGA, BiomeRegistry.register("taiga_clearing", taiga_clearing), 2F);
        Biome berry_fields = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_3)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_3)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.BERRY_FIELDS)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.TAIGA, BiomeRegistry.register("berry_fields", berry_fields), 0.5F);
        Biome taiga_edge = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_1)
                .build();
        OverworldBiomes.addEdgeBiome(BiomeKeys.TAIGA, BiomeRegistry.register("taiga_edge", taiga_edge), 1F);

        Biome pine_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_7)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.TAIGA, BiomeRegistry.register("pine_taiga", pine_taiga), 0.1F);

        Biome fen = template.builder()
                .depth(-0.05F)
                .scale(0.05F)
                .addDefaultFeature(FOREST_GRASS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FEN_PINE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FEN_SPRUCE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_2)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.TAIGA, BiomeRegistry.register("fen", fen), 0.1F);

        Biome mixed_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.PINE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SPRUCE_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FOREST_TREES_4)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.TAIGA, BiomeRegistry.register("mixed_taiga", mixed_taiga), 0.15F);

        Biome tall_taiga = template.builder()
                .depth(0.1F)
                .scale(0.05F)
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_SPRUCE)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.TAIGA, BiomeRegistry.register("tall_taiga", tall_taiga), 0.1F);

        Biome tall_pine_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_PINE)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.TAIGA, BiomeRegistry.register("tall_pine_taiga", tall_pine_taiga), 0.1F);
    }
}
