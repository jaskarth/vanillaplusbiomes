package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.SPRINGS;

public class JungleBiomes {
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.95F)
            .downfall(0.9F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS, JUNGLE_VEGETATION,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, JUNGLE_GRASS, SPRINGS, BAMBOO, EXTRA_DEFAULT_FLOWERS)
            .addDefaultSpawnEntries()
    );

    public static void register() {
        Biome jungle_clearing = template.builder()
                .addCustomFeature(
                        GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.RANDOM_SELECTOR.configure(
                                new RandomFeatureConfig(
                                        ImmutableList.of(
                                                Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F),
                                                Feature.TREE.configure(DefaultBiomeFeatures.MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)),
                                        Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG)))
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.JUNGLE, BiomeRegistry.register("jungle_clearing", jungle_clearing), 0.5F);
    }
}
