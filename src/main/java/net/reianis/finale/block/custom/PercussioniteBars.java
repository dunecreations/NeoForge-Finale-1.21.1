package net.reianis.finale.block.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;
import net.reianis.finale.item.FItems;

import java.util.function.Supplier;

public class PercussioniteBars {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Finale.MOD_ID);


    public static final DeferredBlock<IronBarsBlock> PERCUSSIONITE_BARS = registerBlock("percussionite_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL)
                    .strength(5.0F, 6.0F)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));



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
