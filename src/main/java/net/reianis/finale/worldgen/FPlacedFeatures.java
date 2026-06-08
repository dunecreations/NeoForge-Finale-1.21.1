package net.reianis.finale.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.reianis.finale.Finale;

import java.util.List;

public class FPlacedFeatures {
    public static final ResourceKey<PlacedFeature> END_STONE_PERCUSSIONITE_ORE_PLACED_KEY = registerKey("tide_crystal_ore_placed");
    public static final ResourceKey<PlacedFeature> DISMALENE_PERCUSSIONITE_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> STALESTONE_PERCUSSIONITE_ORE_PLACED_KEY = registerKey("luminite_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, END_STONE_PERCUSSIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(FConfiguredFeatures.END_END_STONE_PERCUSSIONITE_ORE_KEY),
                FOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(48))));
        register(context, DISMALENE_PERCUSSIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(FConfiguredFeatures.END_DISMALENE_PERCUSSIONITE_ORE_KEY),
                FOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(48))));
        register(context, STALESTONE_PERCUSSIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(FConfiguredFeatures.END_STALESTONE_PERCUSSIONITE_ORE_KEY),
                FOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(35), VerticalAnchor.absolute(208))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}