package supercoder79.vanillaplusbiomes.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.ForestFlowerBlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.foliage.DecayingDarkOakFoliagePlacer;
import supercoder79.vanillaplusbiomes.foliage.NoneFoliagePlacer;
import supercoder79.vanillaplusbiomes.trunk.AncientTrunkPlacer;
import supercoder79.vanillaplusbiomes.trunk.FallenTrunkPlacer;

import java.util.OptionalInt;

public class VanillaPlusConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> GRASS_2 = Feature.RANDOM_PATCH.configure(
            ConfiguredFeatures.Configs.GRASS_CONFIG)
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?, ?> BIRCH_FALLEN_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
            new FallenTrunkPlacer(5, 2, 0),
            new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()),
            new NoneFoliagePlacer(),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BIRCH_3 = Feature.TREE.configure(ConfiguredFeatures.BIRCH.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BIRCH_5 = Feature.TREE.configure(ConfiguredFeatures.BIRCH.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BIRCH_20 = Feature.TREE.configure(ConfiguredFeatures.BIRCH.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(20, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BIRCH_SHRUB = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
            new StraightTrunkPlacer(1, 0, 0),
            new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()),
            new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> LILYPAD_1 = Feature.RANDOM_PATCH.configure(new RandomPatchFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.LILY_PAD.getDefaultState()), SimpleBlockPlacer.INSTANCE).tries(10).build())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(1);

    public static final ConfiguredFeature<?, ?> LILYPAD_2 = Feature.RANDOM_PATCH.configure(new RandomPatchFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.LILY_PAD.getDefaultState()), SimpleBlockPlacer.INSTANCE).tries(10).build())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?, ?> DECAYING_DARK_OAK_VEGETATION = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.125F),
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.15F),
                            Feature.TREE.configure(
                                    new TreeFeatureConfig.Builder(
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.getDefaultState()),
                                            new AncientTrunkPlacer(8, 8, 8),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LEAVES.getDefaultState()),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_SAPLING.getDefaultState()),
                                            new DecayingDarkOakFoliagePlacer(ConstantIntProvider.create(-1), ConstantIntProvider.create(0)),
                                            new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                                            .decorators(ImmutableList.of(new LeavesVineTreeDecorator(), new TrunkVineTreeDecorator())).ignoreVines().build()).withChance(0.6666667F),
                            ConfiguredFeatures.FANCY_OAK.withChance(0.1F)),
                    ConfiguredFeatures.OAK))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(10);

    public static final ConfiguredFeature<?, ?> OAK_THICKET_VEGETATION = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.025F),
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.05F),
                            ConfiguredFeatures.FANCY_OAK.withChance(0.15F)),
                    ConfiguredFeatures.OAK))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .decorate(Decorator.DARK_OAK_TREE.configure(NopeDecoratorConfig.INSTANCE));

    public static final ConfiguredFeature<?, ?> ANCIENT_DARK_FOREST_VEGETATION = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.025F),
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.05F),
                            Feature.TREE.configure(
                                    new TreeFeatureConfig.Builder(
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.getDefaultState()),
                                            new AncientTrunkPlacer(8, 8, 8),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LEAVES.getDefaultState()),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_SAPLING.getDefaultState()),
                                            new DarkOakFoliagePlacer(UniformIntProvider.create(0, 1), ConstantIntProvider.create(0)),
                                            new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                                            .ignoreVines().build()).withChance(0.8666667F),
                            ConfiguredFeatures.FANCY_OAK.withChance(0.1F)),
                    ConfiguredFeatures.OAK))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .decorate(Decorator.DARK_OAK_TREE.configure(NopeDecoratorConfig.INSTANCE));

    public static final ConfiguredFeature<?, ?> TALL_DARK_FOREST_VEGETATION = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.025F),
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.05F),
                            Feature.TREE.configure(
                                    new TreeFeatureConfig.Builder(
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.getDefaultState()),
                                            new DarkOakTrunkPlacer(12, 4, 2),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_LEAVES.getDefaultState()),
                                            new SimpleBlockStateProvider(Blocks.DARK_OAK_SAPLING.getDefaultState()),
                                            new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                                            new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                                            .ignoreVines().build()).withChance(0.6666667F),
                            ConfiguredFeatures.BIRCH.withChance(0.2F),
                            ConfiguredFeatures.FANCY_OAK.withChance(0.1F)),
                    ConfiguredFeatures.OAK))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .decorate(Decorator.DARK_OAK_TREE.configure(NopeDecoratorConfig.INSTANCE));

    public static final ConfiguredFeature<?, ?> DARK_OAK_2 = ConfiguredFeatures.DARK_OAK
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(0)))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?, ?> OAK_1 = ConfiguredFeatures.OAK
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(1);

    public static final ConfiguredFeature<?, ?> OAK_5 = ConfiguredFeatures.OAK
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(5);

    public static final ConfiguredFeature<?, ?> PINE_1 = ConfiguredFeatures.PINE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(1);

    public static final ConfiguredFeature<?, ?> PINE_2 = ConfiguredFeatures.PINE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?, ?> PINE_3 = ConfiguredFeatures.PINE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(3);

    public static final ConfiguredFeature<?, ?> PINE_7 = ConfiguredFeatures.PINE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(7);

    public static final ConfiguredFeature<?, ?> SPRUCE_1 = ConfiguredFeatures.SPRUCE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(1);

    public static final ConfiguredFeature<?, ?> SPRUCE_3 = ConfiguredFeatures.SPRUCE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(3);

    public static final ConfiguredFeature<?, ?> OAK_2_5 = ConfiguredFeatures.OAK
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.5f, 1)));

    public static final ConfiguredFeature<?, ?> LARGE_OAK_2_5 = ConfiguredFeatures.FANCY_OAK
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.5f, 1)));

    public static final ConfiguredFeature<?, ?> CACTUS_5 = Feature.RANDOM_PATCH.configure((RandomPatchFeatureConfig) ConfiguredFeatures.PATCH_CACTUS.getConfig())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(5);

    public static final ConfiguredFeature<?, ?> SUGARCANE_128 = Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.SUGAR_CANE_CONFIG)
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(128);

    public static final ConfiguredFeature<?, ?> JUNGLE_4 = Feature.TREE.configure(ConfiguredFeatures.JUNGLE_TREE.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> CACTUS_100 = Feature.RANDOM_PATCH.configure((RandomPatchFeatureConfig) ConfiguredFeatures.PATCH_CACTUS.getConfig())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(100);

    public static final ConfiguredFeature<?, ?> CACTUS_10 = Feature.RANDOM_PATCH.configure((RandomPatchFeatureConfig) ConfiguredFeatures.PATCH_CACTUS.getConfig())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(10);

    public static final ConfiguredFeature<?, ?> DEAD_BUSH_5 = Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.DEAD_BUSH_CONFIG)
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(5);

    public static final ConfiguredFeature<?, ?> DEAD_BUSH_2 = Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.DEAD_BUSH_CONFIG)
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?, ?> JUNGLE_CLEARING_VEGETATION = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            Feature.TREE.configure(ConfiguredFeatures.FANCY_OAK.getConfig()).withChance(0.1F),
                            Feature.TREE.configure((TreeFeatureConfig) ConfiguredFeatures.JUNGLE_BUSH.getConfig()).withChance(0.5F),
                            Feature.TREE.configure(ConfiguredFeatures.MEGA_JUNGLE_TREE.getConfig()).withChance(0.33333334F)),
                    Feature.TREE.configure(ConfiguredFeatures.JUNGLE_TREE.getConfig())))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> WEATHERED_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new LargeOakTrunkPlacer(9, 9, 3),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
            .ignoreVines().build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.8f, 1)));

    public static final ConfiguredFeature<?, ?> SMALL_WEATHERED_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(4, 4, 4),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 1),
            new TwoLayersFeatureSize(1, 0, 1)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> PUMPKIN_PATCH = Feature.RANDOM_PATCH.configure(
            new RandomPatchFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.PUMPKIN.getDefaultState()),
                    SimpleBlockPlacer.INSTANCE)
                    .tries(64)
                    .whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK))
                    .cannotProject()
                    .build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.75f, 1)));

    public static final ConfiguredFeature<?, ?> FLOWER_FIELD = Feature.FLOWER.configure(
            new RandomPatchFeatureConfig.Builder(
                    ForestFlowerBlockStateProvider.INSTANCE,
                    SimpleBlockPlacer.INSTANCE)
                    .tries(64)
                    .build())
            .decorate(Decorator.SPREAD_32_ABOVE.configure(NopeDecoratorConfig.INSTANCE))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(128);

    public static final ConfiguredFeature<?, ?> FOREST_ROCK = Feature.FOREST_ROCK.configure(new SingleStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState()))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeatRandomly(3);

    public static final ConfiguredFeature<?, ?> LOWLANDS_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(6, 2, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(2)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.5f, 3)));

    public static final ConfiguredFeature<?, ?> FALLEN_OAK_1 = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new FallenTrunkPlacer(4, 2, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new NoneFoliagePlacer(),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FALLEN_OAK_2 = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new FallenTrunkPlacer(4, 2, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new NoneFoliagePlacer(),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    private static final RandomFeatureConfig FOREST_TREES = new RandomFeatureConfig(
            ImmutableList.of(
                    ConfiguredFeatures.BIRCH_BEES_0002.withChance(0.2F),
                    ConfiguredFeatures.FANCY_OAK_BEES_0002.withChance(0.1F)),
            ConfiguredFeatures.OAK_BEES_0002);

    public static final ConfiguredFeature<?, ?> FOREST_TREES_3 = Feature.RANDOM_SELECTOR.configure(FOREST_TREES)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FOREST_TREES_20 = Feature.RANDOM_SELECTOR.configure(FOREST_TREES)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FOREST_TREES_4 = Feature.RANDOM_SELECTOR.configure(FOREST_TREES)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FOREST_BUSH = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(1, 0, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> TALL_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            Feature.TREE.configure(ConfiguredFeatures.BIRCH_BEES_0002.getConfig()).withChance(0.2F),
                            Feature.TREE.configure(ConfiguredFeatures.FANCY_OAK_BEES_0002.getConfig()).withChance(0.1F)),
                    Feature.TREE.configure(new TreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                            new StraightTrunkPlacer(5, 2, 6),
                            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
                            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1))
                            .ignoreVines()
                            .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).build())))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FLOODED_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                                    new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                                    new StraightTrunkPlacer(6, 2, 0),
                                    new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                                    new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
                                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0), 3),
                                    new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                                    .withChance(0.2F),
                            Feature.TREE.configure(ConfiguredFeatures.FANCY_OAK_BEES_0002.getConfig()).withChance(0.1F)),
                    Feature.TREE.configure(new TreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                            new StraightTrunkPlacer(6, 2, 0),
                            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
                            new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(2)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> ACACIA_3 = Feature.TREE.configure(ConfiguredFeatures.ACACIA.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> ACACIA_1 = Feature.TREE.configure(ConfiguredFeatures.ACACIA.getConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> ACACIA_BUSH = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(1, 0, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> SPRUCE_FALLEN_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
            new FallenTrunkPlacer(5, 4, 0),
            new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.SPRUCE_SAPLING.getDefaultState()),
            new NoneFoliagePlacer(),
            new TwoLayersFeatureSize(0, 0, 0)).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BERRY_FIELDS = Feature.RANDOM_PATCH.configure((RandomPatchFeatureConfig) ConfiguredFeatures.PATCH_BERRY_BUSH.getConfig())
            .decorate(Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .repeat(20);

    public static final ConfiguredFeature<?, ?> TALL_PINE = Feature.TREE.configure(
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(10, 4, 4),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_SAPLING.getDefaultState()),
                    new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
                    new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(9, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> TALL_SPRUCE = Feature.TREE.configure(
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(10, 4, 4),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_SAPLING.getDefaultState()),
                    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 3), UniformIntProvider.create(1, 2)),
                    new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FEN_PINE = Feature.TREE.configure(
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(6, 4, 0),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_SAPLING.getDefaultState()),
                    new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(2, 3)),
                    new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(3)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> FEN_SPRUCE = Feature.TREE.configure(
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(6, 4, 0),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.SPRUCE_SAPLING.getDefaultState()),
                    new SpruceFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(2, 3)),
                    new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(3)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    private static final TreeFeatureConfig SWAMP_TREE = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(5, 3, 0),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1)))
            .decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).build();

    public static final ConfiguredFeature<?, ?> SWAMP_2 = Feature.TREE.configure(SWAMP_TREE)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(1)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> SWAMP_12 = Feature.TREE.configure(SWAMP_TREE)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(1)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(12, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> SWAMP_RARE = Feature.TREE.configure(SWAMP_TREE)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(1)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.25f, 1)));

    public static final ConfiguredFeature<?, ?> DECAYING_TREE = Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new StraightTrunkPlacer(3, 4, 4),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 1),
            new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new LeavesVineTreeDecorator())).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(1)))
            .spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 1)));

    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("grass_2"), GRASS_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("birch_fallen_tree"), BIRCH_FALLEN_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("birch_3"), BIRCH_3);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("birch_5"), BIRCH_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("birch_20"), BIRCH_20);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("birch_shrub"), BIRCH_SHRUB);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("lilypad_1"), LILYPAD_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("lilypad_2"), LILYPAD_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("decaying_dark_oak_vegetation"), DECAYING_DARK_OAK_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("oak_thicket_vegetation"), OAK_THICKET_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("ancient_dark_forest_vegetation"), ANCIENT_DARK_FOREST_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tall_dark_forest_vegetation"), TALL_DARK_FOREST_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("dark_oak_2"), DARK_OAK_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("oak_1"), OAK_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("oak_5"), OAK_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("pine_1"), PINE_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("pine_2"), PINE_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("pine_3"), PINE_3);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("pine_7"), PINE_7);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("spruce_1"), SPRUCE_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("spruce_3"), SPRUCE_3);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("oak_2_5"), OAK_2_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("large_oak_2_5"), LARGE_OAK_2_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("cactus_5"), CACTUS_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("sugarcane_128"), SUGARCANE_128);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("jungle_4"), JUNGLE_4);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("cactus_10"), CACTUS_10);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("cactus_100"), CACTUS_100);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("dead_bush_5"), DEAD_BUSH_5);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("dead_bush_2"), DEAD_BUSH_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("jungle_clearing_vegetation"), JUNGLE_CLEARING_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("weathered_tree"), WEATHERED_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("small_weathered_tree"), SMALL_WEATHERED_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("pumpkin_patch"), PUMPKIN_PATCH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("flower_field"), FLOWER_FIELD);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("forest_rock"), FOREST_ROCK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("lowlands_tree"), LOWLANDS_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("fallen_oak_1"), FALLEN_OAK_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("fallen_oak_2"), FALLEN_OAK_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("forest_trees_3"), FOREST_TREES_3);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("forest_trees_4"), FOREST_TREES_4);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("forest_trees_20"), FOREST_TREES_20);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("forest_bush"), FOREST_BUSH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tall_forest_trees"), TALL_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("flooded_forest_trees"), FLOODED_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("acacia_3"), ACACIA_3);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("acacia_1"), ACACIA_1);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("acacia_bush"), ACACIA_BUSH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("spruce_fallen_tree"), SPRUCE_FALLEN_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("berry_fields"), BERRY_FIELDS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tall_pine"), TALL_PINE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tall_spruce"), TALL_SPRUCE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("fen_pine"), FEN_PINE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("fen_spruce"), FEN_SPRUCE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("swamp_2"), SWAMP_2);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("swamp_12"), SWAMP_12);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("swamp_rare"), SWAMP_RARE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("decaying_tree"), DECAYING_TREE);
    }

    private static Identifier id(String name) {
        return new Identifier("vanillaplusbiomes", name);
    }
}
