package supercoder79.vanillaplusbiomes;

import net.fabricmc.api.ModInitializer;
import supercoder79.vanillaplusbiomes.biomes.*;
import supercoder79.vanillaplusbiomes.decorators.VanillaPlusBiomesDecorators;
import supercoder79.vanillaplusbiomes.feature.VanillaPlusConfiguredFeatures;
import supercoder79.vanillaplusbiomes.foliage.VanillaPlusFoliagePlacers;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusBiomesSurfaces;
import supercoder79.vanillaplusbiomes.surface.VanillaPlusConfiguredSurfaceBuilders;
import supercoder79.vanillaplusbiomes.trunk.VanillaPlusTrunkPlacers;

public class VanillaPlusBiomes implements ModInitializer {
	@Override
	public void onInitialize() {
		VanillaPlusBiomesDecorators.register();
		VanillaPlusFoliagePlacers.register();
		VanillaPlusTrunkPlacers.register();
		VanillaPlusBiomesSurfaces.register();
		VanillaPlusConfiguredSurfaceBuilders.register();
		VanillaPlusConfiguredFeatures.register();

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
