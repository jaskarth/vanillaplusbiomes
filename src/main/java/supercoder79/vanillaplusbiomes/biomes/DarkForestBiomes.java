package supercoder79.vanillaplusbiomes.biomes;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.tree.LeaveVineTreeDecorator;
import net.minecraft.world.gen.tree.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.trunk.AncientTrunkPlacer;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import java.util.OptionalInt;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class DarkForestBiomes {
    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.7F)
            .downfall(0.8F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .grassColorModifier(BiomeEffects.GrassColorModifier.DARK_FOREST)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(0.7f))
            )
            .addStructureFeature(ConfiguredStructureFeatures.MANSION)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    FOREST_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, FOREST_GRASS, SPRINGS)
            .addDefaultSpawnEntries()
    );
    public static void register() {
        Biome dark_forest_edge = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DARK_OAK_2)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.OAK_1)
                .build();
        OverworldBiomes.addEdgeBiome(BiomeKeys.DARK_FOREST, BiomeRegistry.register("dark_forest_edge", dark_forest_edge), 0.2F);

        Biome tall_dark_forest = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.TALL_DARK_FOREST_VEGETATION)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.DARK_FOREST, BiomeRegistry.register("tall_dark_forest", tall_dark_forest), 0.1F);

        Biome ancient_dark_forest = template.builder()
                .addDefaultFeature(FOREST_GRASS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.ANCIENT_DARK_FOREST_VEGETATION)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.DARK_FOREST, BiomeRegistry.register("ancient_dark_forest", ancient_dark_forest), 0.1F);

        Biome dark_forest_oak_thicket = template.builder()
                .addDefaultFeature(FOREST_GRASS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.OAK_THICKET_VEGETATION)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.DARK_FOREST, BiomeRegistry.register("dark_forest_oak_thicket", dark_forest_oak_thicket), 0.8F);

        Biome dark_forest_clearing = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DARK_OAK_2)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.DARK_FOREST, BiomeRegistry.register("dark_forest_clearing", dark_forest_clearing), 0.2F);

        Biome decaying_dark_forest = template.builder()
                .addDefaultFeature(FOREST_GRASS)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.DECAYING_DARK_OAK_VEGETATION)
                .build();
        OverworldBiomes.addBiomeVariant(BiomeKeys.DARK_FOREST, BiomeRegistry.register("decaying_dark_forest", decaying_dark_forest), 0.05F);
    }
}
