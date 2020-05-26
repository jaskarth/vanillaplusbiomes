package supercoder79.vanillaplusbiomes.decorators;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

public class ConfigurableDarkOakDecorator extends Decorator<CountDecoratorConfig> {
   public ConfigurableDarkOakDecorator(Codec<CountDecoratorConfig> codec) {
      super(codec);
   }

   public Stream<BlockPos> getPositions(WorldAccess worldAccess, ChunkGenerator chunkGenerator, Random random, CountDecoratorConfig config, BlockPos blockPos) {
      return IntStream.range(0, config.count).mapToObj((i) -> {
         int j = i / 4;
         int k = i % 4;
         int l = j * 4 + 1 + random.nextInt(3) + blockPos.getX();
         int m = k * 4 + 1 + random.nextInt(3) + blockPos.getZ();
         int n = worldAccess.getTopY(Heightmap.Type.MOTION_BLOCKING, l, m);
         return new BlockPos(l, n, m);
      });
   }
}