package net.reianis.finale.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.reianis.finale.Finale;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FItemTagProvider extends ItemTagsProvider {
    public FItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                            CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Finale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(ModTags.Items.EXAMPLE_TAG)
//                .add(CaveMineralItems.EXAMPLE_ITEM.get());
    }
}