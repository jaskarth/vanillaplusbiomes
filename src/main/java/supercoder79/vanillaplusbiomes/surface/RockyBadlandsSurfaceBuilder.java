package supercoder79.vanillaplusbiomes.surface;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.BadlandsSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class RockyBadlandsSurfaceBuilder extends BadlandsSurfaceBuilder {
   private static final BlockState WHITE_TERRACOTTA;
   private static final BlockState ORANGE_TERRACOTTA;
   private static final BlockState TERRACOTTA;

   public RockyBadlandsSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
      super(codec);
   }

   public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int l, long m, TernarySurfaceConfig ternarySurfaceConfig) {
      int localX = x & 15;
      int localZ = z & 15;
      BlockState blockState3 = WHITE_TERRACOTTA;
      BlockState blockState4 = biome.getSurfaceConfig().getUnderMaterial();
      int surfaceDepth = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
      boolean cosNoise = Math.cos(noise / 3.0D * 3.141592653589793D) > 0.0D;
      int q = -1;
      boolean bl2 = false;
      int r = 0;
      BlockPos.Mutable mutable = new BlockPos.Mutable();

      for(int y = height; y >= 0; --y) {
         if (r < 15) {
            mutable.set(localX, y, localZ);
            BlockState blockState5 = chunk.getBlockState(mutable);
            if (blockState5.isAir()) {
               q = -1;
            } else if (blockState5.isOf(defaultBlock.getBlock())) {
               if (q == -1) {
                  bl2 = false;
                  if (surfaceDepth <= 0) {
                     blockState3 = Blocks.AIR.getDefaultState();
                     blockState4 = defaultBlock;
                  } else if (y >= l - 4 && y <= l + 1) {
                     blockState3 = WHITE_TERRACOTTA;
                     blockState4 = biome.getSurfaceConfig().getUnderMaterial();
                  }

                  if (y < l && (blockState3 == null || blockState3.isAir())) {
                     blockState3 = defaultFluid;
                  }

                  q = surfaceDepth + Math.max(0, y - l);
                  if (y >= l - 1) {
                     if (y > 80 + surfaceDepth * 2) {
                        if (cosNoise && random.nextDouble() < (noise / 3.0D) + (random.nextDouble() * 0.25)) {
                           if (noise > 1.0) {
                              if (random.nextBoolean()) {
                                 chunk.setBlockState(mutable, Blocks.GRASS_BLOCK.getDefaultState(), false);
                              } else {
                                 chunk.setBlockState(mutable, Blocks.COARSE_DIRT.getDefaultState(), false);
                              }
                           } else {
                              chunk.setBlockState(mutable, Blocks.COBBLESTONE.getDefaultState(), false);
                           }
                        } else {
                           if (noise > 1.5) {
                              chunk.setBlockState(mutable, Blocks.GRASS_BLOCK.getDefaultState(), false);
                           } else if (noise < -0.75) {
                              chunk.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                           } else {
                              chunk.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                           }
                        }
                     } else if (y > l + 3 + surfaceDepth) {
                        BlockState blockState8;
                        if (y >= 64 && y <= 127) {
                           if (cosNoise) {
                              blockState8 = TERRACOTTA;
                           } else {
                              blockState8 = this.calculateLayerBlockState(x, y, z);
                           }
                        } else {
                           blockState8 = ORANGE_TERRACOTTA;
                        }

                        chunk.setBlockState(mutable, blockState8, false);
                     } else {
                        chunk.setBlockState(mutable, biome.getSurfaceConfig().getTopMaterial(), false);
                        bl2 = true;
                     }
                  } else {
                     chunk.setBlockState(mutable, blockState4, false);
                     if (blockState4 == WHITE_TERRACOTTA) {
                        chunk.setBlockState(mutable, ORANGE_TERRACOTTA, false);
                     }
                  }
               } else if (q > 0) {
                  --q;
                  if (bl2) {
                     chunk.setBlockState(mutable, ORANGE_TERRACOTTA, false);
                  } else {
                     chunk.setBlockState(mutable, this.calculateLayerBlockState(x, y, z), false);
                  }
               }

               ++r;
            }
         }
      }

   }

   static {
      WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.getDefaultState();
      ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.getDefaultState();
      TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();
   }
}
