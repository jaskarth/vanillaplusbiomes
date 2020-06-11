package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.NoneFoliagePlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class TaigaBiomes {

    @SuppressWarnings("unchecked")
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG).category(Biome.Category.FOREST)
            .depth(0.35F)
            .scale(0.2F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.8F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES, FROZEN_TOP_LAYER)
            .addStructureFeatures(DefaultBiomeFeatures.TAIGA_VILLAGE, DefaultBiomeFeatures.PILLAGER_OUTPOST, DefaultBiomeFeatures.STRONGHOLD, DefaultBiomeFeatures.NORMAL_MINESHAFT)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.FOX, 8, 2, 4))
    );
    public static void register() {
        Biome taiga_lake = template.builder()
                .depth(-0.3F)
                .scale(0)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                .addDefaultFeature(TAIGA_TREES)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG)
                        .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("taiga_lake", taiga_lake), 2F);
        Biome taiga_clearing = template.builder()
                .scale(0.1F)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 2)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 1)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                        new NoneFoliagePlacer(),
                        new FallenTrunkPlacer(5, 4, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 1)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("taiga_clearing", taiga_clearing), 2F);
        Biome berry_fields = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 3)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 3)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG).createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceDecoratorConfig(32))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("berry_fields", berry_fields), 0.5F);
        Biome taiga_edge = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 1)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 1)
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.TAIGA, BiomeRegistry.register("taiga_edge", taiga_edge), 1F);

        Biome pine_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 7)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("pine_taiga", pine_taiga), 0.1F);

        Biome fen = template.builder()
                .depth(-0.05F)
                .scale(0.05F)
                .addDefaultFeature(FOREST_GRASS)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new PineFoliagePlacer(1, 0, 1, 0, 2, 1),
                                new StraightTrunkPlacer(6, 4, 0),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().maxWaterDepth(4).build()), 1)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new SpruceFoliagePlacer(1, 1, 0, 2, 1, 1),
                                new StraightTrunkPlacer(4, 3, 2),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().maxWaterDepth(2).build()), 2)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                        new NoneFoliagePlacer(),
                        new FallenTrunkPlacer(5, 4, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG)
                        .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(3))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("fen", fen), 0.1F);

        Biome mixed_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 1)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_RARE_BEEHIVES_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_RARE_BEEHIVES_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(7, 0.1F, 1))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("mixed_taiga", mixed_taiga), 0.15F);

        Biome tall_taiga = template.builder()
                .depth(0.1F)
                .scale(0.05F)
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new SpruceFoliagePlacer(2, 1, 0, 3, 1, 1),
                                new StraightTrunkPlacer(10, 4, 4),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()), 6)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("tall_taiga", tall_taiga), 0.1F);

        Biome tall_pine_taiga = template.builder()
                .addDefaultFeatures(FOREST_GRASS, SWEET_BERRY_BUSHES)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new PineFoliagePlacer(1, 0, 1, 0, 3, 1),
                                new StraightTrunkPlacer(10, 4, 4),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()), 9)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("tall_pine_taiga", tall_pine_taiga), 0.1F);
    }
}
