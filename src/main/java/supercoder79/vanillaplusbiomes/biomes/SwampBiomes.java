package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class SwampBiomes {
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
            .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SEAGRASS, new SeagrassFeatureConfig(64, 0.6D), Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
            .grassColor(6975545)
            .foliageColor(6975545)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.SLIME, 1, 1, 1))
    );
    public static void register() {
        Biome swamp_clearing = template.builder()
                .depth(0.1f)
                .scale(0)
                .addTreeFeature(Feature.SWAMP_TREE, 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SEAGRASS, new SeagrassFeatureConfig(128, 0.8D), Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(5)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.DEAD_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(1)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(128)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(8, 0.25F)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.RED_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(8, 0.125F)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SWAMP, BiomeRegistry.register("swamp_clearing", swamp_clearing), 0.7F);

        Biome lush_swamp = template.builder()
                .depth(-0.1f)
                .addDefaultFeatures(SWAMP_FEATURES, JUNGLE_VEGETATION, MUSHROOM_FIELDS_FEATURES)
                .addTreeFeature(Feature.SWAMP_TREE, 12)
                .grassColor(5011004)
                .foliageColor(5011004)
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.SWAMP, BiomeRegistry.register("lush_swamp", lush_swamp), 0.05);

        Biome mushroomy_swamp =  template.builder()
                .depth(0.1f)
                .scale(0.05f)
                .addDefaultFeature(MUSHROOM_FIELDS_FEATURES)
                .addTreeFeature(Feature.SWAMP_TREE, 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(5)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.DEAD_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(1)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(8, 0.25F)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.RED_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(8, 0.125F)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.SWAMP, BiomeRegistry.register("mushroomy_swamp", mushroomy_swamp), 0.7F);
        Biome swamp_edge = template.builder()
                .depth(0)
                .scale(0.05f)
                .addTreeFeature(Feature.SWAMP_TREE, 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(5)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.DEAD_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(1)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(8, 0.25F)))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.RED_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(8, 0.125F)))
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.SWAMP, BiomeRegistry.register("swamp_edge", swamp_edge), 1.F);
    }
}
