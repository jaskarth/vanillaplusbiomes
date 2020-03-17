package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class DarkForestBiomes {
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.7F)
            .downfall(0.8F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    FOREST_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS)
            .addDefaultSpawnEntries()
            .grassColor(0x39752f)
    );
    public static void register() {
        Biome dark_forest_edge = template.builder()
                .addTreeFeature(Feature.DARK_OAK_TREE.configure(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG), 2)
                .addTreeFeature(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG), 1)
                .build();
        OverworldBiomes.addEdgeBiome(Biomes.DARK_FOREST, BiomeRegistry.register("dark_forest_edge", dark_forest_edge), 0.2F);
    }
}
