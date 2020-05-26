package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
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
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
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
            .addStructureFeatures(DefaultBiomeFeatures.field_24706, DefaultBiomeFeatures.field_24687, DefaultBiomeFeatures.field_24697, DefaultBiomeFeatures.field_24689)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, PLAINS_TALL_GRASS, DEFAULT_VEGETATION, SPRINGS)
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(20))))
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome pumpkin_patch = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.PUMPKIN_PATCH_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.75f, 1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("pumpkin_patch", pumpkin_patch), 0.3F);

        Biome sparse_forest = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.5f, 1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.5f, 1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("sparse_forest", sparse_forest), 1.F);
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, sparse_forest, 0.05f);

        Biome flower_field = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(150))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("flower_field", flower_field), 0.1f);

        Biome lowlands = template.builder()
                .depth(-0.25f)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(2, 0, 0, 0, 3),
                        new StraightTrunkPlacer(6, 2, 0),
                        new TwoLayersFeatureSize(1, 0, 1)).method_27374().baseHeight(2).build().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))))
                        .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.5f, 3))))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 10, 6, 12))
                .scale(0.125f)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("lowlands", lowlands), 0.1f);

        Biome plains_hills = template.builder()
                .depth(0.35f)
                .scale(0.4f)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("plains_hills", plains_hills), 0.2F);

        //this is literally just traverse's biome but less cool
        Biome plains_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025f)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("plains_plateau", plains_plateau), 0.2F);

        Biome rocky_plains = template.builder()
                .depth(0.2f)
                .addCustomFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 0)).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))))
                .scale(0.2f)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("rocky_plains", rocky_plains), 0.1f);
    }
}
