package net.reianis.finale.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.reianis.finale.Finale;
import net.reianis.finale.block.FBuildingBlocks;
import net.reianis.finale.block.FNaturalBlocks;
import net.reianis.finale.block.FOreBlocks;
import net.reianis.finale.block.custom.FLichenBlocks;
import net.reianis.finale.block.custom.PercussioniteBars;

public class FBlockStateProvider extends BlockStateProvider {
    public FBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Finale.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(FNaturalBlocks.DISMALENE);
        blockWithItem(FNaturalBlocks.ENDERSILT);
        blockWithItem(FNaturalBlocks.STALESTONE);
        blockWithItem(FNaturalBlocks.FRAGILE_STALESTONE);
        blockWithItem(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE);

        blockWithItem(FOreBlocks.END_STONE_PERCUSSIONITE_ORE);
        blockWithItem(FOreBlocks.DISMALENE_PERCUSSIONITE_ORE);
        blockWithItem(FOreBlocks.STALESTONE_PERCUSSIONITE_ORE);

        blockWithItem(FBuildingBlocks.POLISHED_END_STONE);
        blockWithItem(FBuildingBlocks.PERCUSSIONITE_BLOCK);
        blockWithItem(FBuildingBlocks.CUT_PERCUSSIONITE);
        axisBlock((RotatedPillarBlock) FBuildingBlocks.PERCUSSIONITE_PILLAR.get(),
                modLoc("block/percussionite_pillar_side"),
                modLoc("block/percussionite_pillar_top"));
        simpleBlockItem(FBuildingBlocks.PERCUSSIONITE_PILLAR.get(),
                models().getExistingFile(modLoc("block/percussionite_pillar")));
        blockWithItem(FBuildingBlocks.DISMALENE_BRICKS);
        blockWithItem(FBuildingBlocks.POLISHED_DISMALENE);
        blockWithItem(FBuildingBlocks.ENDERSILT_BRICKS);
        blockWithItem(FBuildingBlocks.STALESTONE_BRICKS);
        blockWithItem(FBuildingBlocks.POLISHED_STALESTONE);
        blockWithItem(FBuildingBlocks.POLISHED_FRAGILE_STALESTONE);
        blockWithItem(FBuildingBlocks.CRACKED_POLISHED_FRAGILE_STALESTONE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
