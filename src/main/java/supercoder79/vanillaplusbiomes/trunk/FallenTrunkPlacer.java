package supercoder79.vanillaplusbiomes.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

public class FallenTrunkPlacer extends StraightTrunkPlacer {
    public static final Codec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).apply(instance, FallenTrunkPlacer::new));

    public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return VanillaPlusTrunkPlacers.FALLEN;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        // Axis
        Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
        Direction direction = Direction.from(axis, random.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

        for (int i = 0; i < height; ++i) {
            placeTrunkBlock(world, replacer, random, startPos.offset(direction, i), config, axis);
        }

        return ImmutableList.of();
    }

    protected static boolean placeTrunkBlock(TestableWorld modifiableTestableWorld, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos blockPos, TreeFeatureConfig treeFeatureConfig, Direction.Axis axis) {
        if (TreeFeature.canReplace(modifiableTestableWorld, blockPos)) {
            replacer.accept(blockPos, treeFeatureConfig.trunkProvider.getBlockState(random, blockPos).with(PillarBlock.AXIS, axis));
            return true;
        } else {
            return false;
        }
    }
}