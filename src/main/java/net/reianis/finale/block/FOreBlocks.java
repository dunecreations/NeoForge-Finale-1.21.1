package net.reianis.finale.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;
import net.reianis.finale.item.FItems;

import java.util.function.Supplier;

public class FOreBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Finale.MOD_ID);


    public static final DeferredBlock<Block> END_STONE_PERCUSSIONITE_ORE = registerBlock("end_stone_percussionite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.75F).requiresCorrectToolForDrops().mapColor(MapColor.SAND)));
    public static final DeferredBlock<Block> DISMALENE_PERCUSSIONITE_ORE = registerBlock("dismalene_percussionite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.75F).requiresCorrectToolForDrops().mapColor(MapColor.SAND)));
    public static final DeferredBlock<Block> STALESTONE_PERCUSSIONITE_ORE = registerBlock("stalestone_percussionite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(4.15F).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_BLACK)));



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
