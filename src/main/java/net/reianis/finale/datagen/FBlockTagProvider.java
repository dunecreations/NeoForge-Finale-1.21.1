package net.reianis.finale.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.reianis.finale.Finale;
import net.reianis.finale.block.FBuildingBlocks;
import net.reianis.finale.block.FNaturalBlocks;
import net.reianis.finale.block.FOreBlocks;
import net.reianis.finale.block.util.FTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FBlockTagProvider extends BlockTagsProvider {
    public FBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Finale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(FNaturalBlocks.DISMALENE.get())
                .add(FNaturalBlocks.ENDERSILT.get())
                .add(FNaturalBlocks.STALESTONE.get())
                .add(FNaturalBlocks.FRAGILE_STALESTONE.get())
                .add(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE.get())

                .add(FBuildingBlocks.POLISHED_END_STONE.get())
                .add(FBuildingBlocks.PERCUSSIONITE_BLOCK.get())
                .add(FBuildingBlocks.CUT_PERCUSSIONITE.get())
                .add(FBuildingBlocks.PERCUSSIONITE_PILLAR.get())
                .add(FBuildingBlocks.DISMALENE_BRICKS.get())
                .add(FBuildingBlocks.POLISHED_DISMALENE.get())
                .add(FBuildingBlocks.ENDERSILT_BRICKS.get())
                .add(FBuildingBlocks.STALESTONE_BRICKS.get())
                .add(FBuildingBlocks.POLISHED_STALESTONE.get())
                .add(FBuildingBlocks.POLISHED_FRAGILE_STALESTONE.get())
                .add(FBuildingBlocks.CRACKED_POLISHED_FRAGILE_STALESTONE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(FNaturalBlocks.STALESTONE.get())
                .add(FOreBlocks.STALESTONE_PERCUSSIONITE_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(FNaturalBlocks.FRAGILE_STALESTONE.get())
                .add(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE.get())

                .add(FOreBlocks.END_STONE_PERCUSSIONITE_ORE.get())
                .add(FOreBlocks.DISMALENE_PERCUSSIONITE_ORE.get())

                .add(FBuildingBlocks.STALESTONE_BRICKS.get())
                .add(FBuildingBlocks.POLISHED_STALESTONE.get())
                .add(FBuildingBlocks.POLISHED_FRAGILE_STALESTONE.get())
                .add(FBuildingBlocks.CRACKED_POLISHED_FRAGILE_STALESTONE.get());


        tag(FTags.Blocks.END_STONE_ORE_REPLACEABLES)
                .add(Blocks.END_STONE);

        tag(FTags.Blocks.DISMALENE_ORE_REPLACEABLES)
                .add(FNaturalBlocks.DISMALENE.get());

        tag(FTags.Blocks.STALESTONE_ORE_REPLACEABLES)
                .add(FNaturalBlocks.STALESTONE.get())
                .add(FNaturalBlocks.FRAGILE_STALESTONE.get())
                .add(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE.get());
    }
}
