package supercoder79.vanillaplusbiomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import supercoder79.vanillaplusbiomes.decorators.ChanceHeightmapQuadrupleDecorator;

public class VanillaPlusBiomesDecorators {
    public static ChanceHeightmapQuadrupleDecorator CHANCE_HEIGHTMAP_QUADRUPLE;
    public static void register() {
        CHANCE_HEIGHTMAP_QUADRUPLE = Registry.register(Registry.DECORATOR, new Identifier("vanillaplusbiomes", "chqd"), new ChanceHeightmapQuadrupleDecorator(ChanceDecoratorConfig::deserialize));
    }
}
