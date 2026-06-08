package net.reianis.finale.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.reianis.finale.Finale;

public class FBlockModelProvider extends BlockModelProvider {
    public FBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Finale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
