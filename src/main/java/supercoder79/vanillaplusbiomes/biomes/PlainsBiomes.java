package supercoder79.vanillaplusbiomes.biomes;

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
            .addStructureFeature(Feature.VILLAGE, new StructurePoolFeatureConfig("village/plains/town_centers", 6))
            .addStructureFeature(Feature.PILLAGER_OUTPOST, FeatureConfig.DEFAULT)
            .addStructureFeature(Feature.STRONGHOLD)
            .addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
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

        Biome flower_field = template.builder()
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(150))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("flower_field", flower_field), 0.1f);

        Biome lowlands = template.builder()
                .depth(-0.25f)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.4D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.5f, 3))))
                .addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 10, 6, 12))
                .scale(0.125f)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, BiomeRegistry.register("lowlands", lowlands), 0.1f);

        Biome plains_hills = template.builder()
                .depth(0.35f)
                .scale(0.4f)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.PLAINS, BiomeRegistry.register("plains_hills", plains_hills), 0.2F);
    }
}
