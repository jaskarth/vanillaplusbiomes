package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.util.BiomeHelper;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class SavannaBiomes {

    public static BiomeTemplate template = new BiomeTemplate(TerraformBiomeBuilder.create()
            .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS)
            .precipitation(Biome.Precipitation.NONE)
            .category(Biome.Category.SAVANNA)
            .depth(0.125F)
            .scale(0.05F)
            .temperature(1.2F)
            .downfall(0.0F)
            .effects(new BiomeEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x50533)
                    .fogColor(12638463)
                    .skyColor(BiomeHelper.getSkyColor(1.2f))
            )
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, SAVANNA_TALL_GRASS, SAVANNA_GRASS, DEFAULT_VEGETATION, SPRINGS)
            .addStructureFeatures(ConfiguredStructureFeatures.VILLAGE_SAVANNA, ConfiguredStructureFeatures.PILLAGER_OUTPOST, ConfiguredStructureFeatures.STRONGHOLD, ConfiguredStructureFeatures.MINESHAFT)
            .addDefaultSpawnEntries()
    );

    public static void register() {
        Biome savanna_thicket = template.builder()
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.ACACIA_3)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SAVANNA, BiomeRegistry.register("savanna_thicket", savanna_thicket), 0.4f);

        Biome savanna_lake = template.builder()
                .depth(-0.25F)
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.ACACIA_3)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.LILYPAD_1)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SAVANNA, BiomeRegistry.register("savanna_lake", savanna_lake), 0.3f);

        Biome savanna_scrub = template.builder()
                .scale(0)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.ACACIA_1)
                .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, VanillaPlusConfiguredFeatures.ACACIA_BUSH)
                .build();
        OverworldBiomes.addHillsBiome(BiomeKeys.SAVANNA, BiomeRegistry.register("savanna_scrub", savanna_scrub), 0.3f);
    }
}
