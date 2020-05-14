package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import supercoder79.vanillaplusbiomes.BiomeRegistry;

import java.util.OptionalInt;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class DarkForestBiomes {
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
                    FOREST_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, FOREST_GRASS, SPRINGS)
            .addDefaultSpawnEntries()
            .grassColor(0x39752f)
    );
    public static void register() {
        Biome dark_forest_edge = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG), 2)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG), 1)
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.DARK_FOREST, BiomeRegistry.register("dark_forest_edge", dark_forest_edge), 0.2F);

        Biome tall_dark_forest = template.builder()
                .addCustomFeature(
                        GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.HUGE_BROWN_MUSHROOM.configure(DefaultBiomeFeatures.HUGE_BROWN_MUSHROOM_CONFIG).withChance(0.025F),
                                                Feature.HUGE_RED_MUSHROOM.configure(DefaultBiomeFeatures.HUGE_RED_MUSHROOM_CONFIG).withChance(0.05F),
                                                Feature.TREE.configure(
                                                        new TreeFeatureConfig.Builder(
                                                                new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.getDefaultState()),
                                                                new SimpleBlockStateProvider(Blocks.DARK_OAK_LEAVES.getDefaultState()),
                                                                new DarkOakFoliagePlacer(0, 0, 0, 0),
                                                                new DarkOakTrunkPlacer(12, 4, 2),
                                                                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                                                                .baseHeight(Integer.MAX_VALUE)
                                                                .method_27375(Heightmap.Type.MOTION_BLOCKING).method_27374().build()).withChance(0.6666667F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).withChance(0.2F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
                                .createDecoratedFeature(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT)))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.DARK_FOREST, BiomeRegistry.register("tall_dark_forest", tall_dark_forest), 0.1F);
    }
}
