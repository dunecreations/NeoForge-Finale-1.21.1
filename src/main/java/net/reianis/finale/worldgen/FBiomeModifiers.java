package net.reianis.finale.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.reianis.finale.Finale;

public class FBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_END_STONE_ORE = registerKey("add_end_stone_ore");
    public static final ResourceKey<BiomeModifier> ADD_DISMALENE_ORE = registerKey("add_dismalene_ore");
    public static final ResourceKey<BiomeModifier> ADD_STALESTONE_ORE = registerKey("add_stalestone_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

// Exmaple Biome Tag Generation
//      context.register(ADD_EXAMPLE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//              biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXAMPLE_ORE_PLACED_KEY)),
//              GenerationStep.Decoration.UNDERGROUND_ORES
//      ));


// Exmaple Biome Generation
//      context.register(ADD_EXAMPLE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//              HolderSet.direct(biomes.getOrThrow(Biomes.BIOME)),
//              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXAMPLE_ORE_PLACED_KEY)),
//              GenerationStep.Decoration.UNDERGROUND_ORES
//      ));

        context.register(ADD_END_STONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(FPlacedFeatures.END_STONE_PERCUSSIONITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_DISMALENE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(FPlacedFeatures.DISMALENE_PERCUSSIONITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_STALESTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(FPlacedFeatures.STALESTONE_PERCUSSIONITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, name));
    }
}