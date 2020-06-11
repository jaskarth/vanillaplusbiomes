package supercoder79.vanillaplusbiomes.surface;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class VanillaPlusBiomesSurfaces {
    public static SurfaceBuilder<TernarySurfaceConfig> ROCKY_BADLANDS;

    public static void register() {
        ROCKY_BADLANDS = Registry.register(Registry.SURFACE_BUILDER, new Identifier("vanillaplusbiomes", "rocky_badlands"), new RockyBadlandsSurfaceBuilder(TernarySurfaceConfig.CODEC));
    }
}
