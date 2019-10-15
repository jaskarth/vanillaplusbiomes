package supercoder79.vanillaplusbiomes;

import net.fabricmc.api.ModInitializer;
import supercoder79.vanillaplusbiomes.biomes.*;

public class VanillaPlusBiomes implements ModInitializer {
	@Override
	public void onInitialize() {
		VanillaPlusBiomesFeatures.register();
		VanillaPlusBiomesDecorators.register();
		TaigaBiomes.register();
		PlainsBiomes.register();
		OceanBiomes.register();
		SwampBiomes.register();
        DesertBiomes.generate();
	}
}
