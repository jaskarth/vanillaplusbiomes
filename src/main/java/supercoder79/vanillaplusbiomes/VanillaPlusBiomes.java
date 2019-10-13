package supercoder79.vanillaplusbiomes;

import net.fabricmc.api.ModInitializer;
import supercoder79.vanillaplusbiomes.biomes.TaigaBiomes;

public class VanillaPlusBiomes implements ModInitializer {
	@Override
	public void onInitialize() {
		VanillaPlusBiomesFeatures.register();
		TaigaBiomes.register();
	}
}
