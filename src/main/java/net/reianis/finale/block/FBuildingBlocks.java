package net.reianis.finale.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;
import net.reianis.finale.item.FItems;

import java.util.function.Supplier;

public class FBuildingBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Finale.MOD_ID);


    public static final DeferredBlock<Block> POLISHED_END_STONE = registerBlock("polished_end_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_YELLOW).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ENDERSILT_BRICKS = registerBlock("endersilt_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_YELLOW).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PERCUSSIONITE_BLOCK = registerBlock("percussionite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_PURPLE).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CUT_PERCUSSIONITE = registerBlock("cut_percussionite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_PURPLE).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<RotatedPillarBlock> PERCUSSIONITE_PILLAR = registerBlock("percussionite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_PURPLE).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DISMALENE_BRICKS = registerBlock("dismalene_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_YELLOW).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_DISMALENE = registerBlock("polished_dismalene",
            () -> new  Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_YELLOW).strength(3.6F, 9.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STALESTONE_BRICKS = registerBlock("stalestone_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK).strength(4.0F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_STALESTONE = registerBlock("polished_stalestone",
            () -> new  Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK).strength(4.0F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_FRAGILE_STALESTONE = registerBlock("polished_fragile_stalestone",
            () -> new  Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK).strength(3.4F, 9.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CRACKED_POLISHED_FRAGILE_STALESTONE = registerBlock("cracked_polished_fragile_stalestone",
            () -> new  Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK).strength(3.0F, 8.6F).requiresCorrectToolForDrops()));



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
