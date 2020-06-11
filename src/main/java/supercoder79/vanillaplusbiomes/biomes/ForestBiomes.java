package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.NoneFoliagePlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class ForestBiomes {
    private static final TreeFeatureConfig TALL_OAK_TREE = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 3),
            new StraightTrunkPlacer(5, 2, 6),
            new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines()
                .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).build();


    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.7F)
            .downfall(0.8F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, FOREST_GRASS, SPRINGS)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))))

            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome forest_clearing = template.builder()
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new NoneFoliagePlacer(),
                        new FallenTrunkPlacer(4, 2, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 1)

                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.1F, 1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_clearing", forest_clearing), 1.F);
        Biome forest_thicket = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(20, 0.1F, 1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_thicket", forest_thicket), 0.5F);
        Biome forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(4, 0.1F, 1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG)
                        .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_lake", forest_lake), 0.5F);
        Biome forest_edge = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1))))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.FOREST, BiomeRegistry.register("forest_edge", forest_edge), 0.5F);

        Biome tall_forest = template.builder()
                .depth(0.1F)
                .scale(0.3F)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.LARGE_BIRCH_TREE_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(TALL_OAK_TREE)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("tall_forest", tall_forest), 0.1F);

        Biome forest_scrub = template.builder()
                .depth(0.1F)
                .scale(0.1F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("forest_scrub", forest_scrub), 0.1F);

        Biome flooded_forest = template.builder()
                .depth(-0.1F)
                .scale(0.1F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                                                        new BlobFoliagePlacer(2, 0, 0, 0, 3),
                                                        new StraightTrunkPlacer(6, 2, 0),
                                                        new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().maxWaterDepth(2).build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                                        .withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                                                new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                                                new BlobFoliagePlacer(2, 0, 0, 0, 3),
                                                new StraightTrunkPlacer(6, 2, 0),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().maxWaterDepth(2).build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("flooded_forest", flooded_forest), 0.1F);

        Biome flat_tree_forest = template.builder()
                .depth(0.1F)
                .scale(0.3F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                                                        new AcaciaFoliagePlacer(2, 0, 0, 0),
                                                        new StraightTrunkPlacer(5, 2, 0),
                                                        new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                                        .withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.025F)),
                                        Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                                                new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                                                new AcaciaFoliagePlacer(2, 0, 0, 0),
                                                new StraightTrunkPlacer(4, 2, 0),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("flat_tree_forest", flat_tree_forest), 0.1F);

        Biome balloon_forest = template.builder()
                .depth(0.2F)
                .scale(0.3F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                                                        new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                                                        new LargeOakFoliagePlacer(2, 0, 0, 0, 4),
                                                        new StraightTrunkPlacer(5, 2, 0),
                                                        new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                                        .withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.025F)),
                                        Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                                                new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                                                new LargeOakFoliagePlacer(2, 0, 0, 0, 4),
                                                new StraightTrunkPlacer(4, 2, 0),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("balloon_forest", balloon_forest), 0.1F);

        Biome tall_tree_forest = template.builder()
                .depth(0.2F)
                .scale(0.3F)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                                        Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                                new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                                                new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                                                new SpruceFoliagePlacer(1, 0, 0, 2, 1, 1),
                                                new StraightTrunkPlacer(6, 3, 3),
                                                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.FOREST, BiomeRegistry.register("tall_tree_forest", tall_tree_forest), 0.05F);
    }
}
