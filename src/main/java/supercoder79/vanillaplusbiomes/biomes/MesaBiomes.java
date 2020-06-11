package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terraform.biomeapi.OverworldBiomesExt;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusBiomesSurfaces;

import java.util.OptionalInt;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.SPRINGS;

public class MesaBiomes {
    private static final TreeFeatureConfig WEATHERED_TREE = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new LargeOakFoliagePlacer(2, 0, 4, 0, 4),
            new LargeOakTrunkPlacer(9, 9, 3),
            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
            .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build();

    private static final TreeFeatureConfig WEATHERED_SMALL_TREE = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 1),
            new StraightTrunkPlacer(4, 4, 4),
            new TwoLayersFeatureSize(1, 0, 1)).build();

    @SuppressWarnings("unchecked")
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.BADLANDS, SurfaceBuilder.BADLANDS_CONFIG).category(Biome.Category.DESERT)
            .depth(1.575F)
            .scale(0.04F)
            .precipitation(Biome.Precipitation.NONE)
            .temperature(2.0F)
            .downfall(0.0F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addStructureFeatures(DefaultBiomeFeatures.STRONGHOLD, DefaultBiomeFeatures.MESA_MINESHAFT)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, EXTRA_GOLD,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, BADLANDS_GRASS, BADLANDS_VEGETATION, SPRINGS, BADLANDS_VEGETATION)
            .foliageColor(10387789)
            .grassColor(9470285)
            .addDefaultSpawnEntries()
    );

    public static void register() {
        // inspired by https://www.reddit.com/r/Minecraft/comments/h0f5vi/my_take_on_a_mesa_biome/
        Biome rocky_badlands_plateau = template.builder()
                .configureSurfaceBuilder(VanillaPlusBiomesSurfaces.ROCKY_BADLANDS, SurfaceBuilder.BADLANDS_CONFIG)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1))))
                .build();
        rocky_badlands_plateau = BiomeRegistry.register("rocky_badlands_plateau", rocky_badlands_plateau);
        OverworldBiomes.addBiomeVariant(Biomes.BADLANDS_PLATEAU, rocky_badlands_plateau, 0.1);
        OverworldBiomesExt.addBorderBiome(rocky_badlands_plateau, Biomes.BADLANDS);

        Biome weathered_badlands_plateau = template.builder()
                .configureSurfaceBuilder(VanillaPlusBiomesSurfaces.WEATHERED_BADLANDS, SurfaceBuilder.BADLANDS_CONFIG)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.TREE.configure(WEATHERED_SMALL_TREE)
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.1F, 1))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                        Feature.TREE.configure(WEATHERED_TREE)
                                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.8F, 1))))
                .build();
        weathered_badlands_plateau = BiomeRegistry.register("weathered_badlands_plateau", weathered_badlands_plateau);
        OverworldBiomes.addBiomeVariant(Biomes.BADLANDS_PLATEAU, weathered_badlands_plateau, 0.1);
        OverworldBiomesExt.addBorderBiome(weathered_badlands_plateau, Biomes.BADLANDS);
    }
}
