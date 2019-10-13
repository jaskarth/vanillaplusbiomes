package supercoder79.vanillaplusbiomes;

import com.terraformersmc.terraform.feature.FallenLogFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class VanillaPlusBiomesFeatures {
    public static FallenLogFeature SPRUCE_FALLEN_LOGS = new FallenLogFeature(DefaultFeatureConfig::deserialize, false, Blocks.SPRUCE_LOG.getDefaultState(), 5, 8);
    public static void register() {
        Registry.register(Registry.FEATURE, new Identifier("vanillaplusbiomes", "spruce_fallen_logs"), SPRUCE_FALLEN_LOGS);
    }
}
