package net.reianis.finale.datagen;

import net.reianis.finale.worldgen.biome.FinaleBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.reianis.finale.Finale;
import net.reianis.finale.worldgen.FBiomeModifiers;
import net.reianis.finale.worldgen.FConfiguredFeatures;
import net.reianis.finale.worldgen.FPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, FinaleBiomes::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, FConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, FPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FBiomeModifiers::bootstrap);

    public FDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Finale.MOD_ID));
    }
}