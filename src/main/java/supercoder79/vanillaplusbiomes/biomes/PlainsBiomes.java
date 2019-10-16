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

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class PlainsBiomes {
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG).category(Biome.Category.PLAINS)
            .depth(0.125F)
            .scale(0.05F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.8F)
            .downfall(0.4F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/plains/town_centers", 6))
            .addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostFeatureConfig(0.004D))
            .addStructureFeature(Feature.STRONGHOLD)
            .addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, PLAINS_TALL_GRASS, DEFAULT_VEGETATION, SPRINGS)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(20)))
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome pumpkin_patch = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.PUMPKIN, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.75f, 1)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("pumpkin_patch", pumpkin_patch), 0.3F);
        Biome sparse_forest = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.FANCY_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.75f, 1)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.NORMAL_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(2, 0.5f, 3)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("sparse_forest", sparse_forest), 1.F);
        Biome flower_field = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.FOREST_FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(150)))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("flower_field", flower_field), 0.1f);
        Biome lowlands = template.builder()
                .depth(-0.25f)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SEAGRASS, new SeagrassFeatureConfig(64, 0.4D), Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.NORMAL_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.5f, 3)))
                .scale(0.125f)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("lowlands", lowlands), 0.1f);
    }
}
