package supercoder79.vanillaplusbiomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import supercoder79.vanillaplusbiomes.decorators.ChanceHeightmapQuadrupleDecorator;
import supercoder79.vanillaplusbiomes.decorators.ConfigurableDarkOakDecorator;

public class VanillaPlusBiomesDecorators {
    public static ConfigurableDarkOakDecorator CONFIGURABLE_DARK_OAK;
    public static void register() {
        CONFIGURABLE_DARK_OAK = Registry.register(Registry.DECORATOR, new Identifier("vanillaplusbiomes", "configurable_dark_oak"), new ConfigurableDarkOakDecorator(CountDecoratorConfig::deserialize));
    }
}
