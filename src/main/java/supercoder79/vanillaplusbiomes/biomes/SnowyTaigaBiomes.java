package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
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

public class SnowyTaigaBiomes {
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
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES)
            .addStructureFeature(Feature.PILLAGER_OUTPOST, FeatureConfig.DEFAULT)
            .addStructureFeature(Feature.STRONGHOLD)
            .addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.FOX, 8, 2, 4))
    );
    public static void register() {
        Biome taiga_lake = template.builder()
                .depth(-0.3F)
                .scale(0)
                .addDefaultFeature(TAIGA_TREES)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_lake", taiga_lake), 2F);
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
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_clearing", taiga_clearing), 2F);
        Biome berry_fields = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 3)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 3)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG).createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceDecoratorConfig(40))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_berry_fields", berry_fields), 0.5F);
        Biome taiga_edge = template.builder()
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 3)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 3)
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.SNOWY_TAIGA, BiomeRegistry.register("snowy_taiga_edge", taiga_edge), 1F);
    }
}
