package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
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
            .addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
            .addStructureFeature(Feature.SHIPWRECK, new ShipwreckFeatureConfig(true))
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.SQUID, 1, 1, 4))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 10, 3, 6))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.DOLPHIN, 1, 1, 2))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.DROWNED, 5, 1, 1))

    );
    public static void register() {
        Biome ocean_lagoon = template.builder()
                .depth(-0.4f)
                .addStructureFeature(Feature.OCEAN_RUIN, new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.COLD, 0.6F, 0.9F))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.OCEAN, BiomeRegistry.register("ocean_lagoon", ocean_lagoon), 0.25);
        Biome lukewarm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .addStructureFeature(Feature.OCEAN_RUIN, new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.WARM, 0.8F, 0.9F))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addDefaultFeature(MORE_SEAGRASS)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.LUKEWARM_OCEAN, BiomeRegistry.register("lukewarm_ocean_lagoon", lukewarm_ocean_lagoon), 0.25);
        Biome warm_ocean_lagoon = template.builder()
                .depth(-0.4f)
                .addStructureFeature(Feature.OCEAN_RUIN, new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.WARM, 1.0F, 0.9F))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.PUFFERFISH, 5, 1, 3))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SEA_PICKLE, new SeaPickleFeatureConfig(20), Decorator.CHANCE_TOP_SOLID_HEIGHTMAP, new ChanceDecoratorConfig(16)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(new Feature[]{Feature.CORAL_TREE, Feature.CORAL_CLAW, Feature.CORAL_MUSHROOM}, new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT, FeatureConfig.DEFAULT}), Decorator.TOP_SOLID_HEIGHTMAP_NOISE_BIASED, new TopSolidHeightmapNoiseBiasedDecoratorConfig(20, 400.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG)))
                .addDefaultFeature(MORE_SEAGRASS)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.WARM_OCEAN, BiomeRegistry.register("warm_ocean_lagoon", warm_ocean_lagoon), 0.25);
        Biome cold_ocean_lagoon = template.builder()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRAVEL_CONFIG)
                .depth(-0.5f)
                .addStructureFeature(Feature.OCEAN_RUIN, new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.COLD, 0.5F, 0.9F))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.COLD_OCEAN, BiomeRegistry.register("cold_ocean_lagoon", cold_ocean_lagoon), 0.25);
    }
}
