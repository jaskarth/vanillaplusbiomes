package supercoder79.vanillaplusbiomes;

import com.terraformersmc.terraform.feature.FallenLogFeature;
import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class VanillaPlusBiomesFeatures {
    public static FallenLogFeature SPRUCE_FALLEN_LOGS = new FallenLogFeature(FallenLogFeatureConfig::deserialize);
    public static FallenLogFeature OAK_FALLEN_LOGS = new FallenLogFeature(FallenLogFeatureConfig::deserialize);
    public static FallenLogFeature BIRCH_FALLEN_LOGS = new FallenLogFeature(FallenLogFeatureConfig::deserialize);
    public static void register() {
        Registry.register(Registry.FEATURE, new Identifier("vanillaplusbiomes", "spruce_fallen_logs"), SPRUCE_FALLEN_LOGS);
        Registry.register(Registry.FEATURE, new Identifier("vanillaplusbiomes", "oak_fallen_logs"), OAK_FALLEN_LOGS);
        Registry.register(Registry.FEATURE, new Identifier("vanillaplusbiomes", "birch_fallen_logs"), BIRCH_FALLEN_LOGS);
    }
}
