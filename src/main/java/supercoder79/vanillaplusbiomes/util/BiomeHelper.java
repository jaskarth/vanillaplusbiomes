package supercoder79.vanillaplusbiomes.util;

import net.minecraft.util.math.MathHelper;

public class BiomeHelper {
    public static int getSkyColor(float temperature) {
        float scaledTemperature = temperature / 3.0F;
        scaledTemperature = MathHelper.clamp(scaledTemperature, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - scaledTemperature * 0.05F, 0.5F + scaledTemperature * 0.1F, 1.0F);
    }
}
