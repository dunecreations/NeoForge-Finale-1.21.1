package net.reianis.finale.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;
import net.reianis.finale.item.FItems;

import java.util.function.Supplier;

public class FNaturalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Finale.MOD_ID);


    public static final DeferredBlock<Block> ENDERSILT = registerBlock("endersilt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.SAND)));

    public static final DeferredBlock<Block> CHORAL_END_STONE = registerBlock("choral_end_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE)));

    public static final DeferredBlock<Block> DISMALENE = registerBlock("dismalene",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.SAND)));

    public static final DeferredBlock<Block> STALESTONE = registerBlock("stalestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(3.4F, 9.0F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> FRAGILE_STALESTONE = registerBlock("fragile_stalestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(2.8F, 8.4F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> CRACKED_FRAGILE_STALESTONE = registerBlock("cracked_fragile_stalestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE).strength(2.4F, 8.0F)
                    .requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_BLACK)));



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
