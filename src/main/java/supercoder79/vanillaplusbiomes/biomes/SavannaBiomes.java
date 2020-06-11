package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class SavannaBiomes {

    @SuppressWarnings("unchecked")
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Biome.Precipitation.NONE)
            .category(Biome.Category.SAVANNA)
            .depth(0.125F)
            .scale(0.05F)
            .temperature(1.2F)
            .downfall(0.0F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, SAVANNA_TALL_GRASS, SAVANNA_GRASS, DEFAULT_VEGETATION, SPRINGS)
            .addStructureFeatures(DefaultBiomeFeatures.SAVANNA_VILLAGE, DefaultBiomeFeatures.PILLAGER_OUTPOST, DefaultBiomeFeatures.STRONGHOLD, DefaultBiomeFeatures.NORMAL_MINESHAFT)
            .addDefaultSpawnEntries()
    );

    public static void register() {
        Biome savanna_thicket = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.ACACIA_TREE_CONFIG), 3)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SAVANNA, BiomeRegistry.register("savanna_thicket", savanna_thicket), 0.4f);

        Biome savanna_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.ACACIA_TREE_CONFIG), 3)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG)
                        .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SAVANNA, BiomeRegistry.register("savanna_lake", savanna_lake), 0.3f);

        Biome savanna_scrub = template.builder()
                .scale(0)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.ACACIA_TREE_CONFIG), 1)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 1)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SAVANNA, BiomeRegistry.register("savanna_scrub", savanna_scrub), 0.3f);
    }
}
