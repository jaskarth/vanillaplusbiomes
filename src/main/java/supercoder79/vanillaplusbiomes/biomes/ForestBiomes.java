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
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.NoneFoliagePlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class ForestBiomes {
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
    }
}
