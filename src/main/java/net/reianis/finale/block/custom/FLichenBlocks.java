package net.reianis.finale.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;
import net.reianis.finale.block.util.LichenBlockHelp;
import net.reianis.finale.item.FItems;

import java.util.function.Supplier;

public class FLichenBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Finale.MOD_ID);


    public static final DeferredBlock<LichenBlockHelp> CHORAL_LICHEN = registerBlock("choral_lichen",
            () -> new LichenBlockHelp(BlockBehaviour.Properties.of()
                    .sound(SoundType.GLOW_LICHEN).strength(0.2F).replaceable().noCollission()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_PURPLE)));

    public static final DeferredBlock<LichenBlockHelp> BUDDING_CHORAL_LICHEN = registerBlock("budding_choral_lichen",
            () -> new LichenBlockHelp(BlockBehaviour.Properties.of()
                    .sound(SoundType.GLOW_LICHEN).strength(0.2F).replaceable().noCollission()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_PURPLE).lightLevel(GlowLichenBlock.emission(5))));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        FItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
