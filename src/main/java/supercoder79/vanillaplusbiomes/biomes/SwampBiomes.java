package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terraform.util.TerraformBiomeSets;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.misc.FallenTrunkPlacer;
import supercoder79.vanillaplusbiomes.misc.NoneFoliagePlacer;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class SwampBiomes {
    private static final TreeFeatureConfig DECAYING_TREE = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 1),
            new StraightTrunkPlacer(3, 4, 4),
            new TwoLayersFeatureSize(1, 0, 1)).baseHeight(2).method_27376(ImmutableList.of(new LeaveVineTreeDecorator())).build();

    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_CONFIG).category(Biome.Category.SWAMP)
            .depth(-0.2F)
            .scale(0.1F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.8F)
            .downfall(0.9F)
            .waterColor(6388580)
            .waterFogColor(2302743)
            .addStructureFeature(Feature.STRONGHOLD)
            .addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, SWAMP_VEGETATION, SPRINGS, FOSSILS, CLAY)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
            .grassColor(6975545)
            .foliageColor(6975545)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.SLIME, 1, 1, 1))
    );
    public static void register() {
        Biome swamp_clearing = template.builder()
                .depth(0.1f)
                .scale(0)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SWAMP_TREE_CONFIG), 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(128, 0.8D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.25F))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.125F))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SWAMP, BiomeRegistry.register("swamp_clearing", swamp_clearing), 0.7F);

        Biome lush_swamp = template.builder()
                .depth(-0.1f)
                .addDefaultFeatures(SWAMP_FEATURES, JUNGLE_VEGETATION, MUSHROOM_FIELDS_FEATURES)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SWAMP_TREE_CONFIG), 12)
                .grassColor(5011004)
                .foliageColor(5011004)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.SWAMP, BiomeRegistry.register("lush_swamp", lush_swamp), 0.05);

        Biome mushroomy_swamp =  template.builder()
                .depth(0.1f)
                .scale(0.05f)
                .addDefaultFeature(MUSHROOM_FIELDS_FEATURES)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SWAMP_TREE_CONFIG), 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.25F))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.125F))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SWAMP, BiomeRegistry.register("mushroomy_swamp", mushroomy_swamp), 0.7F);
        Biome swamp_edge = template.builder()
                .depth(0)
                .scale(0.05f)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SWAMP_TREE_CONFIG), 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.25F))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.125F))))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.SWAMP, BiomeRegistry.register("swamp_edge", swamp_edge), 1.F);

        Biome decaying_swamp =  template.builder()
                .depth(-0.125F)
                .scale(0.05f)
                .addTreeFeature(Feature.TREE.configure(DECAYING_TREE), 3)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BushFoliagePlacer(2, 0, 1, 0, 2),
                        new FallenTrunkPlacer(1, 0, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addTreeFeature(Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new NoneFoliagePlacer(),
                        new FallenTrunkPlacer(4, 2, 0),
                        new TwoLayersFeatureSize(0, 0, 0)).build()), 2)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(16, 0.5F))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(16, 0.25F))))
                .build();

        OverworldBiomes.addBiomeVariant(Biomes.SWAMP, BiomeRegistry.register("decaying_swamp", decaying_swamp), 0.1);


        TerraformBiomeSets.addSlimeSpawnBiomes(swamp_clearing, lush_swamp, mushroomy_swamp, swamp_edge, decaying_swamp);
    }
}
