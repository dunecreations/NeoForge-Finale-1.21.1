package net.reianis.finale.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.reianis.finale.Finale;

public class FinaleBiomes {

    public static final ResourceKey<Biome> END_STONE_VERTICAL_ISLES = ResourceKey.create(
            Registries.BIOME,
            id("end_stone_vertical_isles"));

    public static final ResourceKey<Biome> DISMALENE_SHELFLANDS = ResourceKey.create(
            Registries.BIOME,
            id("dismalene_shelflands"));

    public static final ResourceKey<Biome> STALESTONE_SHATTERED_ABYSS = ResourceKey.create(
            Registries.BIOME,
            id("stalestone_shattered_abyss"));



    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(END_STONE_VERTICAL_ISLES, createBiome(context));
        context.register(DISMALENE_SHELFLANDS, createBiome(context));
        context.register(STALESTONE_SHATTERED_ABYSS, createBiome(context));
    }

    private static Biome createBiome(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> features =
                context.lookup(Registries.PLACED_FEATURE);

        HolderGetter<ConfiguredWorldCarver<?>> carvers =
                context.lookup(Registries.CONFIGURED_CARVER);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.5F)
                .downfall(0.0F)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .fogColor(10518688)
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .skyColor(0)
                                .build()
                )
                .mobSpawnSettings(
                        new MobSpawnSettings.Builder().build()
                )
                .generationSettings(
                        new BiomeGenerationSettings.Builder(features, carvers)
                                .build()
                )
                .build();
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, path);
    }
}