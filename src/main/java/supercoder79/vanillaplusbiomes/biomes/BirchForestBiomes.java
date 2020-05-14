package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.NoneFoliagePlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class BirchForestBiomes {

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
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new NoneFoliagePlacer(),
                        new FallenTrunkPlacer(5, 2, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 1)
                        .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_clearing", birch_forest_clearing), 1.F);
        Biome birch_forest_thicket = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(20, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_thicket", birch_forest_thicket), 0.5F);
        Biome birch_forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                        .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1)))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_lake", birch_forest_lake), 0.5F);
        Biome birch_forest_edge = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, (Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1)))))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.BIRCH_FOREST, BiomeRegistry.register("birch_forest_edge", birch_forest_edge), 0.5F);

        Biome tall_tree_forest = template.builder()
                .depth(0.2F)
                .scale(0.3F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                                new SpruceFoliagePlacer(1, 0, 0, 2, 1, 1),
                                new StraightTrunkPlacer(6, 4, 4),
                                new TwoLayersFeatureSize(1, 0, 1)).method_27374().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.BIRCH_FOREST, BiomeRegistry.register("tall_birch_tree_forest", tall_tree_forest), 0.05F);
    }
}
