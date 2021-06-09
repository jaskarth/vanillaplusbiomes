package supercoder79.vanillaplusbiomes.trunk;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

public class AncientTrunkPlacer extends TrunkPlacer {
	public static final Codec<AncientTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).apply(instance, AncientTrunkPlacer::new));

	public AncientTrunkPlacer(int maxWaterDepth, int firstRandomHeight, int secondRandomHeight) {
		super(maxWaterDepth, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> getType() {
		return VanillaPlusTrunkPlacers.ANCIENT;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
		List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
		BlockPos blockPos = startPos.down();
		setToDirt(world, replacer, random, blockPos, config);
		generateRoot(world, replacer, random, random.nextBoolean() ? blockPos.west() : blockPos.north(),config);

		setToDirt(world, replacer, random, blockPos.east(), config);
		generateRoot(world, replacer, random, random.nextBoolean() ? blockPos.east().north() : blockPos.east(2),config);

		setToDirt(world, replacer, random, blockPos.south(), config);
		generateRoot(world, replacer, random, random.nextBoolean() ? blockPos.south().west() : blockPos.south(2),config);

		setToDirt(world,  replacer, random, blockPos.south().east(), config);
		generateRoot(world, replacer, random, random.nextBoolean() ? blockPos.south(2).east() : blockPos.south().east(2),config);

		Direction direction = Direction.Type.HORIZONTAL.random(random);
		int i = height - random.nextInt(4);
		int j = 2 - random.nextInt(3);
		int k = startPos.getX();
		int l = startPos.getY();
		int m = startPos.getZ();
		int n = k;
		int o = m;
		int p = l + height - 1;

		int s;
		int t;
		for(s = 0; s < height; ++s) {
			if (s >= i && j > 0) {
				n += direction.getOffsetX();
				o += direction.getOffsetZ();
				--j;
			}

			t = l + s;
			BlockPos blockPos2 = new BlockPos(n, t, o);
			if (TreeFeature.isAirOrLeaves(world, blockPos2)) {
				getAndSetState(world, replacer, random, blockPos2, config);
				getAndSetState(world, replacer, random, blockPos2.east(), config);
				getAndSetState(world, replacer, random, blockPos2.south(), config);
				getAndSetState(world, replacer, random, blockPos2.east().south(), config);
			}
		}

		list.add(new FoliagePlacer.TreeNode(new BlockPos(n, p, o), 0, true));

		for(s = -1; s <= 2; ++s) {
			for(t = -1; t <= 2; ++t) {
				if ((s < 0 || s > 1 || t < 0 || t > 1) && random.nextInt(3) <= 0) {
					int u = random.nextInt(3) + 2;

					for(int v = 0; v < u; ++v) {
						getAndSetState(world, replacer, random, new BlockPos(k + s, p - v - 1, m + t), config);
					}

					list.add(new FoliagePlacer.TreeNode(new BlockPos(n + s, p, o + t), 0, false));
				}
			}
		}

		return list;
	}

	private void generateRoot(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config) {
		//generate and check height
		int height = random.nextInt(5);
		if (height == 0) return;

		//set ground to dirt
		setToDirt(world, replacer, random, startPos, config);
		for (int i = 1; i < height + 1; i++) {
			getAndSetState(world, replacer, random, startPos.up(i),config);
		}
	}
}
