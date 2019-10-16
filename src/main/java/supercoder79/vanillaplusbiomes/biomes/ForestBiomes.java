package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.VanillaPlusBiomesFeatures;

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
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(2)))

            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome forest_clearing = template.builder()
                .addTreeFeature(VanillaPlusBiomesFeatures.OAK_FALLEN_LOGS, 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE}, new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT}, new float[]{0.2F, 0.1F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(3, 0.1F, 1)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_clearing", forest_clearing), 1.F);
        Biome forest_thicket = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE}, new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT}, new float[]{0.2F, 0.1F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(20, 0.1F, 1)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_thicket", forest_thicket), 0.5F);
        Biome forest_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SEAGRASS, new SeagrassFeatureConfig(48, 0.4D), Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE}, new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT}, new float[]{0.2F, 0.1F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(4, 0.1F, 1)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.FOREST, BiomeRegistry.register("forest_lake", forest_lake), 0.5F);
        Biome forest_edge = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE}, new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT}, new float[]{0.2F, 0.1F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(5, 0.1F, 1)))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.FOREST, BiomeRegistry.register("forest_edge", forest_edge), 0.5F);
    }
}
