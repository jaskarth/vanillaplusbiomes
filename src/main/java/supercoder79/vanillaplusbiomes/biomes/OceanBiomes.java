package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.TopSolidHeightmapNoiseBiasedDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class OceanBiomes {
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_SAND_UNDERWATER_CONFIG).category(Biome.Category.OCEAN)
            .depth(-1.0f)
            .scale(0)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.5F)
            .downfall(0.5F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(OCEAN_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, WATER_BIOME_OAK_TREES, DEFAULT_VEGETATION, SPRINGS, SEAGRASS_ON_STONE, SEAGRASS, KELP)
            .addStructureFeatures(DefaultBiomeFeatures.field_24695, DefaultBiomeFeatures.field_24689)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.SQUID, 1, 1, 4))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 10, 3, 6))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.DOLPHIN, 1, 1, 2))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.DROWNED, 5, 1, 1))

    );
    public static void register() {
        Biome ocean_lagoon = template.builder()
                .depth(-0.4f)
                .addStructureFeature(DefaultBiomeFeatures.field_24699)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.OCEAN, BiomeRegistry.register("ocean_lagoon", ocean_lagoon), 0.05);
        Biome cold_ocean_lagoon = template.builder()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRAVEL_CONFIG)
                .depth(-0.5f)
                .waterColor(4020182)
                .waterFogColor(329011)
                .addStructureFeature(DefaultBiomeFeatures.field_24699)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.OCEAN, BiomeRegistry.register("cold_ocean_lagoon", cold_ocean_lagoon), 0.05);
        Biome lukewarm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .waterColor(4566514)
                .waterFogColor(267827)
                .addStructureFeature(DefaultBiomeFeatures.field_24699)
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addDefaultFeature(MORE_SEAGRASS)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.OCEAN, BiomeRegistry.register("lukewarm_ocean_lagoon", lukewarm_ocean_lagoon), 0.05);
        Biome warm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .waterColor(4445678)
                .waterFogColor(270131)
                .addStructureFeature(DefaultBiomeFeatures.field_24700)
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEA_PICKLE.configure(new SeaPickleFeatureConfig(20)).createDecoratedFeature(Decorator.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceDecoratorConfig(16))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.SIMPLE_RANDOM_SELECTOR.configure(
                                new SimpleRandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.CORAL_TREE.configure(FeatureConfig.DEFAULT),
                                                Feature.CORAL_CLAW.configure(FeatureConfig.DEFAULT),
                                                Feature.CORAL_MUSHROOM.configure(FeatureConfig.DEFAULT))))
                                .createDecoratedFeature(
                                        Decorator.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(
                                                new TopSolidHeightmapNoiseBiasedDecoratorConfig(20, 400.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))))
                .addDefaultFeature(MORE_SEAGRASS)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.OCEAN, BiomeRegistry.register("warm_ocean_lagoon", warm_ocean_lagoon), 0.05);
    }
}
