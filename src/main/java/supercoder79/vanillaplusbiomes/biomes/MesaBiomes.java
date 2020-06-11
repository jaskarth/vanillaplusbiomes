package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terraform.biomeapi.OverworldBiomesExt;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusBiomesSurfaces;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.SPRINGS;

public class MesaBiomes {
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
        Biome rocky_badlands_plateau = template.builder()
                .configureSurfaceBuilder(VanillaPlusBiomesSurfaces.ROCKY_BADLANDS, SurfaceBuilder.BADLANDS_CONFIG)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1))))
                .build();
        rocky_badlands_plateau = BiomeRegistry.register("rocky_badlands_plateau", rocky_badlands_plateau);
        OverworldBiomes.addBiomeVariant(Biomes.BADLANDS_PLATEAU, rocky_badlands_plateau, 0.1);
        OverworldBiomesExt.addBorderBiome(rocky_badlands_plateau, Biomes.BADLANDS);
    }
}
