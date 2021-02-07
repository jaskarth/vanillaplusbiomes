package supercoder79.vanillaplusbiomes.surface;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class VanillaPlusConfiguredSurfaceBuilders {
    public static ConfiguredSurfaceBuilder<TernarySurfaceConfig> RED_DESERT;
    public static ConfiguredSurfaceBuilder<TernarySurfaceConfig> ROCKY_BADLANDS;
    public static ConfiguredSurfaceBuilder<TernarySurfaceConfig> WEATHERED_BADLANDS;

    public static void register() {
        RED_DESERT = Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id("red_desert"), SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState())));
        ROCKY_BADLANDS = Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id("rocky_badlands"), VanillaPlusBiomesSurfaces.ROCKY_BADLANDS.withConfig(SurfaceBuilder.BADLANDS_CONFIG));
        WEATHERED_BADLANDS = Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id("weathered_badlands"), VanillaPlusBiomesSurfaces.WEATHERED_BADLANDS.withConfig(SurfaceBuilder.BADLANDS_CONFIG));
    }

    private static Identifier id(String name) {
        return new Identifier("vanillaplusbiomes", name);
    }
}
