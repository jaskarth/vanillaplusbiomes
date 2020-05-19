package supercoder79.vanillaplusbiomes.trunk;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;

public class AncientTrunkPlacer extends TrunkPlacer {

	public AncientTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight, null);
	}

	public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig) {
		List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
		BlockPos blockPos = pos.down();
		method_27400(world, blockPos);
		generateRoot(world, random, random.nextBoolean() ? blockPos.west() : blockPos.north(), set, blockBox, treeFeatureConfig);

		method_27400(world, blockPos.east());
		generateRoot(world, random, random.nextBoolean() ? blockPos.east().north() : blockPos.east(2), set, blockBox, treeFeatureConfig);

		method_27400(world, blockPos.south());
		generateRoot(world, random, random.nextBoolean() ? blockPos.south().west() : blockPos.south(2), set, blockBox, treeFeatureConfig);

		method_27400(world, blockPos.south().east());
		generateRoot(world, random, random.nextBoolean() ? blockPos.south(2).east() : blockPos.south().east(2), set, blockBox, treeFeatureConfig);

		Direction direction = Direction.Type.HORIZONTAL.random(random);
		int i = trunkHeight - random.nextInt(4);
		int j = 2 - random.nextInt(3);
		int k = pos.getX();
		int l = pos.getY();
		int m = pos.getZ();
		int n = k;
		int o = m;
		int p = l + trunkHeight - 1;

		int s;
		int t;
		for(s = 0; s < trunkHeight; ++s) {
			if (s >= i && j > 0) {
				n += direction.getOffsetX();
				o += direction.getOffsetZ();
				--j;
			}

			t = l + s;
			BlockPos blockPos2 = new BlockPos(n, t, o);
			if (TreeFeature.isAirOrLeaves(world, blockPos2)) {
				method_27402(world, random, blockPos2, set, blockBox, treeFeatureConfig);
				method_27402(world, random, blockPos2.east(), set, blockBox, treeFeatureConfig);
				method_27402(world, random, blockPos2.south(), set, blockBox, treeFeatureConfig);
				method_27402(world, random, blockPos2.east().south(), set, blockBox, treeFeatureConfig);
			}
		}

		list.add(new FoliagePlacer.TreeNode(new BlockPos(n, p, o), 0, true));

		for(s = -1; s <= 2; ++s) {
			for(t = -1; t <= 2; ++t) {
				if ((s < 0 || s > 1 || t < 0 || t > 1) && random.nextInt(3) <= 0) {
					int u = random.nextInt(3) + 2;

					for(int v = 0; v < u; ++v) {
						method_27402(world, random, new BlockPos(k + s, p - v - 1, m + t), set, blockBox, treeFeatureConfig);
					}

					list.add(new FoliagePlacer.TreeNode(new BlockPos(n + s, p, o + t), 0, false));
				}
			}
		}

		return list;
	}

	private void generateRoot(ModifiableTestableWorld world, Random random, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig config) {
		//generate and check height
		int height = random.nextInt(5);
		if (height == 0) return;

		//set ground to dirt
		method_27400(world, pos);
		for (int i = 1; i < height + 1; i++) {
			method_27402(world, random, pos.up(i), set, blockBox, config);
		}
	}
}
