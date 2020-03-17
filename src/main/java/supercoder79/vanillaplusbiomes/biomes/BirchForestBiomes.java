package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.VanillaPlusBiomesFeatures;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class BirchForestBiomes {
    public static FallenLogFeatureConfig BIRCH_LOG = new FallenLogFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()))
                    .baseLength(5)
                    .lengthRandom(2).build();

    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.6F)
            .downfall(0.6F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    FOREST_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))))
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome birch_forest_clearing = template.builder()
                .addTreeFeature(VanillaPlusBiomesFeatures.BIRCH_FALLEN_LOGS.configure(BIRCH_LOG), 1)
                        .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_clearing", birch_forest_clearing), 1.F);
        Biome birch_forest_thicket = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(20, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_thicket", birch_forest_thicket), 0.5F);
        Biome birch_forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                        .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_lake", birch_forest_lake), 0.5F);
        Biome birch_forest_edge = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1)))))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_edge", birch_forest_edge), 0.5F);
    }
}
