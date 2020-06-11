package supercoder79.vanillaplusbiomes;

import net.fabricmc.api.ModInitializer;
import supercoder79.vanillaplusbiomes.biomes.*;
import supercoder79.vanillaplusbiomes.decorators.VanillaPlusBiomesDecorators;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusBiomesSurfaces;

public class VanillaPlusBiomes implements ModInitializer {
	@Override
	public void onInitialize() {
		VanillaPlusBiomesFeatures.register();
		VanillaPlusBiomesDecorators.register();
		VanillaPlusBiomesSurfaces.register();

		TaigaBiomes.register();
		PlainsBiomes.register();
		OceanBiomes.register();
		SwampBiomes.register();
        DesertBiomes.register();
        ForestBiomes.register();
        BirchForestBiomes.register();
        DarkForestBiomes.register();
		SavannaBiomes.register();
		SnowyTaigaBiomes.register();
		JungleBiomes.register();
		MesaBiomes.register();
	}
}
