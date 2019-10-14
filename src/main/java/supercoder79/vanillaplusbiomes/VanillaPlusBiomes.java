package supercoder79.vanillaplusbiomes;

import net.fabricmc.api.ModInitializer;
import supercoder79.vanillaplusbiomes.biomes.OceanBiomes;
import supercoder79.vanillaplusbiomes.biomes.PlainsBiomes;
import supercoder79.vanillaplusbiomes.biomes.TaigaBiomes;

public class VanillaPlusBiomes implements ModInitializer {
	@Override
	public void onInitialize() {
		VanillaPlusBiomesFeatures.register();
		VanillaPlusBiomesDecorators.register();
		TaigaBiomes.register();
		PlainsBiomes.register();
		OceanBiomes.register();
	}
}
