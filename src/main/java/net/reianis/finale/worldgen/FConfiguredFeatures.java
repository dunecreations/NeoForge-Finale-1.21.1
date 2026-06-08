package net.reianis.finale.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.reianis.finale.Finale;
import net.reianis.finale.block.FOreBlocks;
import net.reianis.finale.block.util.FTags;

import java.util.List;

public class FConfiguredFeatures {
    // CF -> PF -> BM
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_END_STONE_PERCUSSIONITE_ORE_KEY = registerKey("end_stone_percussionite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_DISMALENE_PERCUSSIONITE_ORE_KEY = registerKey("dismalene_percussionite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STALESTONE_PERCUSSIONITE_ORE_KEY = registerKey("stalestone_percussionite_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest endStoneReplaceables = new TagMatchTest(FTags.Blocks.END_STONE_ORE_REPLACEABLES);
        RuleTest dismaleneReplaceables = new TagMatchTest(FTags.Blocks.DISMALENE_ORE_REPLACEABLES);
        RuleTest stalestoneReplaceables = new TagMatchTest(FTags.Blocks.STALESTONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> endEndStoneOres = List.of(
                OreConfiguration.target(endStoneReplaceables, FOreBlocks.END_STONE_PERCUSSIONITE_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> endDismaleneOres = List.of(
                OreConfiguration.target(endStoneReplaceables, FOreBlocks.DISMALENE_PERCUSSIONITE_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> endStalestoneOres =List.of(
                OreConfiguration.target(endStoneReplaceables, FOreBlocks.STALESTONE_PERCUSSIONITE_ORE.get().defaultBlockState())
        );

        register(context, END_END_STONE_PERCUSSIONITE_ORE_KEY, Feature.ORE, new OreConfiguration(endEndStoneOres, 6));
        register(context, END_DISMALENE_PERCUSSIONITE_ORE_KEY, Feature.ORE, new OreConfiguration(endDismaleneOres, 4));
        register(context, END_STALESTONE_PERCUSSIONITE_ORE_KEY, Feature.ORE, new  OreConfiguration(endStalestoneOres, 3));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}