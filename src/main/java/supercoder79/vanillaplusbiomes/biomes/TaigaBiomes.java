package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.BiomeRegistry;
import supercoder79.vanillaplusbiomes.VanillaPlusBiomesFeatures;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class TaigaBiomes {
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG).category(Biome.Category.FOREST)
            .depth(0.35F)
            .scale(0.2F)
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.8F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, TAIGA_GRASS, DEFAULT_VEGETATION, SPRINGS, SWEET_BERRY_BUSHES)
            .addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/taiga/town_centers", 6))
            .addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostFeatureConfig(0.004D))
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
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("taiga_lake", taiga_lake), 2F);
        Biome taiga_clearing = template.builder()
                .scale(0.1F)
                .addTreeFeature(Feature.PINE_TREE, 6)
                .addTreeFeature(VanillaPlusBiomesFeatures.SPRUCE_FALLEN_LOGS, 1)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("taiga_clearing", taiga_clearing), 2F);
        Biome berry_fields = template.builder()
                .addTreeFeature(Feature.PINE_TREE, 8)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SWEET_BERRY_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(24)))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.TAIGA, BiomeRegistry.register("berry_fields", berry_fields), 6F);
    }
}
