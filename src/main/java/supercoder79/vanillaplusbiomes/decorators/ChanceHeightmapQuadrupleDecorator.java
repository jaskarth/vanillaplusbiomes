package supercoder79.vanillaplusbiomes.decorators;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChanceHeightmapQuadrupleDecorator extends Decorator<ChanceDecoratorConfig> {
    public ChanceHeightmapQuadrupleDecorator(Function<Dynamic<?>, ? extends ChanceDecoratorConfig> function_1) {
        super(function_1);
    }

    public Stream<BlockPos> getPositions(WorldAccess iWorld_1, ChunkGenerator chunkGenerator_1, Random random_1, ChanceDecoratorConfig chanceDecoratorConfig_1, BlockPos blockPos_1) {
        if (random_1.nextFloat() < 1.0F / (float)chanceDecoratorConfig_1.chance) {
            int int_1 = random_1.nextInt(16);
            int int_2 = random_1.nextInt(16);
            int int_3 = iWorld_1.getTopPosition(Heightmap.Type.MOTION_BLOCKING, blockPos_1.add(int_1, 0, int_2)).getY() * 4;
            if (int_3 <= 0) {
                return Stream.empty();
            } else {
                int int_4 = random_1.nextInt(int_3);
                return Stream.of(blockPos_1.add(int_1, int_4, int_2));
            }
        } else {
            return Stream.empty();
        }
    }
}