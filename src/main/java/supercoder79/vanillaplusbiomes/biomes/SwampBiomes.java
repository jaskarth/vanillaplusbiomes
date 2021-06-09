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

public class SwampBiomes {

    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .category(Biome.Category.SWAMP)
            .depth(-0.2F)
            .scale(0.1F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.8F)
            .downfall(0.9F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(6388580)
                    .waterFogColor(2302743)
                    .grassColorModifier(BiomeEffects.GrassColorModifier.SWAMP)
                    .foliageColor(6975545)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.8f))
            )
            .addStructureFeatures(ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.SWAMP_HUT)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, SWAMP_VEGETATION, SPRINGS, FOSSILS, CLAY)

            .addDefaultSpawnEntries()
            .addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1))
    );
    public static void register() {
        Biome swamp_clearing = template.builder()
                .depth(0.1f)
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SWAMP_RARE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_DEAD_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
                .build();
        RegistryKey<Biome> swampClearingKey = BiomeRegistry.register("swamp_clearing", swamp_clearing);
        OverworldBiomes.addHillsBiome(BiomeKeys.SWAMP, swampClearingKey, 0.7F);

        Biome lush_swamp = template.builder()
                .depth(-0.1f)
                .addDefaultFeatures(SWAMP_FEATURES, JUNGLE_VEGETATION, MUSHROOM_FIELDS_FEATURES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SWAMP_12)
                .effects(new BiomeEffects.Builder()
                        .waterColor(6388580)
                        .waterFogColor(2302743)
                        .grassColorModifier(BiomeEffects.GrassColorModifier.SWAMP)
                        .grassColor(5011004)
                        .foliageColor(5011004)
                        .fogColor(12638463)
                        .skyColor(BiomeHelper.getSkyColor(0.8f))
                )
                .build();
        RegistryKey<Biome> lushSwampKey = BiomeRegistry.register("lush_swamp", lush_swamp);
        OverworldBiomes.addBiomeVariant(BiomeKeys.SWAMP, lushSwampKey, 0.05);

        Biome mushroomy_swamp =  template.builder()
                .depth(0.1f)
                .scale(0.05f)
                .addDefaultFeature(MUSHROOM_FIELDS_FEATURES)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SWAMP_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_DEAD_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
                .build();
        RegistryKey<Biome> mushroomySwampKey = BiomeRegistry.register("mushroomy_swamp", mushroomy_swamp);
        OverworldBiomes.addHillsBiome(BiomeKeys.SWAMP, mushroomySwampKey, 0.7F);

        Biome swamp_edge = template.builder()
                .depth(0)
                .scale(0.05f)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.SWAMP_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_DEAD_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
                .build();
        RegistryKey<Biome> swampEdgeKey = BiomeRegistry.register("swamp_edge", swamp_edge);
        OverworldBiomes.addEdgeBiome(BiomeKeys.SWAMP, swampEdgeKey, 1.F);

        Biome decaying_swamp =  template.builder()
                .depth(-0.125F)
                .scale(0.05f)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DECAYING_TREE)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.FALLEN_OAK_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_DEAD_BUSH)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
                .build();
        RegistryKey<Biome> decayingSwampKey = BiomeRegistry.register("decaying_swamp", decaying_swamp);
        OverworldBiomes.addBiomeVariant(BiomeKeys.SWAMP, decayingSwampKey, 0.1);

//        TerraformSlimeSpawnBiomes.addSlimeSpawnBiomes(swampClearingKey, lushSwampKey, mushroomySwampKey, swampEdgeKey, decayingSwampKey);
    }
}
