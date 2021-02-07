package supercoder79.vanillaplusbiomes.foliage;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import supercoder79.vanillaplusbiomes.mixin.FoliagePlacerTypeAccessor;

public class VanillaPlusFoliagePlacers {
    public static FoliagePlacerType<NoneFoliagePlacer> NONE;
    public static FoliagePlacerType<DecayingDarkOakFoliagePlacer> DECAYING_DARK_OAK;

    public static void register() {
        NONE = Registry.register(Registry.FOLIAGE_PLACER_TYPE, new Identifier("vanillaplusbiomes", "none"), FoliagePlacerTypeAccessor.createFoliagePlacerType(NoneFoliagePlacer.CODEC));
        DECAYING_DARK_OAK = Registry.register(Registry.FOLIAGE_PLACER_TYPE, new Identifier("vanillaplusbiomes", "decaying_dark_oak"), FoliagePlacerTypeAccessor.createFoliagePlacerType(DecayingDarkOakFoliagePlacer.CODEC));
    }
}
