package net.reianis.finale.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.reianis.finale.Finale;
import net.reianis.finale.item.FItems;

public class FItemModelProvider extends ItemModelProvider {
    public FItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Finale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(FItems.RAW_PERCUSSIONITE.get());
        basicItem(FItems.PERCUSSIONITE_INGOT.get());
        basicItem(FItems.ENDERSILT_BRICK.get());
    }
}
