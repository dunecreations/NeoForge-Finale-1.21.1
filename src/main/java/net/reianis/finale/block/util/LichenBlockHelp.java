package net.reianis.finale.block.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;

public class LichenBlockHelp extends MultifaceBlock {
    public static final MapCodec<LichenBlockHelp> CODEC =
            simpleCodec(LichenBlockHelp::new);

    private final MultifaceSpreader spreader = new MultifaceSpreader(this);

    public LichenBlockHelp(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<LichenBlockHelp> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }
}
