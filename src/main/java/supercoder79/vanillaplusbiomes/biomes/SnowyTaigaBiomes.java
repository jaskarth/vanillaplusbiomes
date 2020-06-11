package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
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

public class SnowyTaigaBiomes {

    @SuppressWarnings("unchecked")
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG).category(Biome.Category.FOREST)
            .depth(0.2F)
            .scale(0.2F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(-0.5F)
            .downfall(0.4F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES,
                    FROZEN_TOP_LAYER)
            .addStructureFeatures(DefaultBiomeFeatures.SNOWY_VILLAGE, DefaultBiomeFeatures.PILLAGER_OUTPOST, DefaultBiomeFeatures.STRONGHOLD, DefaultBiomeFeatures.NORMAL_MINESHAFT)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.FOX, 8, 2, 4))
    );
    public static void register() {
        Biome snowy_taiga_lake = template.builder()
                .depth(-0.3F)
                .scale(0)
                .addDefaultFeature(TAIGA_TREES)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_lake", snowy_taiga_lake), 2F);
        Biome snowy_taiga_clearing = template.builder()
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
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_clearing", snowy_taiga_clearing), 2F);
        Biome snowy_berry_fields = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 3)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 3)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG).createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceDecoratorConfig(40))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_berry_fields", snowy_berry_fields), 0.5F);
        Biome snowy_taiga_edge = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 1)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 1)
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_edge", snowy_taiga_edge), 1F);

        Biome snowy_pine_taiga = template.builder()
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 7)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.TAIGA, BiomeRegistry.register("snowy_pine_taiga", snowy_pine_taiga), 0.1F);

        Biome tall_snowy_taiga = template.builder()
                .depth(0.1F)
                .scale(0.05F)
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new SpruceFoliagePlacer(2, 1, 0, 3, 1, 1),
                                new StraightTrunkPlacer(10, 4, 4),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()), 6)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.SNOWY_TAIGA, BiomeRegistry.register("tall_snowy_taiga", tall_snowy_taiga), 0.1F);

        Biome tall_snowy_pine_taiga = template.builder()
                .addDefaultFeatures(SWEET_BERRY_BUSHES_SNOWY)
                .addTreeFeature(Feature.TREE.configure(
                        new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
                                new PineFoliagePlacer(1, 0, 1, 0, 3, 1),
                                new StraightTrunkPlacer(10, 4, 4),
                                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()), 9)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.SNOWY_TAIGA, BiomeRegistry.register("tall_snowy_pine_taiga", tall_snowy_pine_taiga), 0.1F);
    }
}
