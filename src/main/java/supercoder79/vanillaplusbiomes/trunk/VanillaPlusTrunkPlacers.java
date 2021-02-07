package supercoder79.vanillaplusbiomes.trunk;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import supercoder79.vanillaplusbiomes.mixin.TrunkPlacerTypeAccessor;

public class VanillaPlusTrunkPlacers {
    public static TrunkPlacerType<FallenTrunkPlacer> FALLEN;
    public static TrunkPlacerType<AncientTrunkPlacer> ANCIENT;

    public static void register() {
        FALLEN = Registry.register(Registry.TRUNK_PLACER_TYPE, new Identifier("vanillaplusbiomes", "fallen"), TrunkPlacerTypeAccessor.createTrunkPlacerType(FallenTrunkPlacer.CODEC));
        ANCIENT = Registry.register(Registry.TRUNK_PLACER_TYPE, new Identifier("vanillaplusbiomes", "ancient"), TrunkPlacerTypeAccessor.createTrunkPlacerType(AncientTrunkPlacer.CODEC));
    }
}
