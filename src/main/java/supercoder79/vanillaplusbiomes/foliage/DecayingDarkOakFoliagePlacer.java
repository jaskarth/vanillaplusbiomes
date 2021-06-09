package supercoder79.vanillaplusbiomes.foliage;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class DecayingDarkOakFoliagePlacer extends DarkOakFoliagePlacer {
    public static final Codec<DecayingDarkOakFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> fillDecayingDarkOakFields(instance).apply(instance, DecayingDarkOakFoliagePlacer::new));

    protected static <P extends DecayingDarkOakFoliagePlacer> Products.P2<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider> fillDecayingDarkOakFields(RecordCodecBuilder.Instance<P> instance) {
        return instance.group(
                IntProvider.createValidatingCodec(-1, 8).fieldOf("radius").forGetter((foliagePlacer) -> foliagePlacer.radius),
                IntProvider.createValidatingCodec(0, 8).fieldOf("offset").forGetter((foliagePlacer) -> foliagePlacer.offset));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return VanillaPlusFoliagePlacers.DECAYING_DARK_OAK;
    }

    public DecayingDarkOakFoliagePlacer(IntProvider uniformIntDistribution, IntProvider uniformIntDistribution2) {
        super(uniformIntDistribution, uniformIntDistribution2);
    }
}
