package net.reianis.finale.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.reianis.finale.block.FBuildingBlocks;
import net.reianis.finale.block.FNaturalBlocks;
import net.reianis.finale.block.FOreBlocks;
import net.reianis.finale.block.custom.FLichenBlocks;
import net.reianis.finale.block.custom.PercussioniteBars;
import net.reianis.finale.item.FItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FBlockLootTableProvider extends BlockLootSubProvider {
    protected FBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

// Drops The Block Itself.
//        dropSelf(CaveMineralBlocks.EXAMPLE_BLOCK.get());


//Drops a Minimum to Maximum Amount of Item(s).
//        add(CaveMineralBlocks.TIDE_CRYSTAL_ORE.get(),
//                block -> createMultipleOreDrops(CaveMineralBlocks.TIDE_CRYSTAL_ORE.get(), CaveMineralItems.TIDE_CRYSTAL.get(), 1, 3));

        add(FOreBlocks.END_STONE_PERCUSSIONITE_ORE.get(),
                block -> createMultipleOreDrops(FOreBlocks.END_STONE_PERCUSSIONITE_ORE.get(), FItems.RAW_PERCUSSIONITE.get(), 1, 4));
        add(FOreBlocks.DISMALENE_PERCUSSIONITE_ORE.get(),
                block -> createMultipleOreDrops(FOreBlocks.DISMALENE_PERCUSSIONITE_ORE.get(), FItems.RAW_PERCUSSIONITE.get(), 1, 3));
        add(FOreBlocks.STALESTONE_PERCUSSIONITE_ORE.get(),
                block -> createMultipleOreDrops(FOreBlocks.STALESTONE_PERCUSSIONITE_ORE.get(), FItems.RAW_PERCUSSIONITE.get(),  1, 2));


        dropSelf(FNaturalBlocks.CHORAL_END_STONE.get());
        dropSelf(FNaturalBlocks.DISMALENE.get());
        dropSelf(FNaturalBlocks.ENDERSILT.get());
        dropSelf(FNaturalBlocks.STALESTONE.get());
        dropSelf(FNaturalBlocks.FRAGILE_STALESTONE.get());
        dropSelf(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE.get());

        dropSelf(FBuildingBlocks.POLISHED_END_STONE.get());
        dropSelf(FBuildingBlocks.PERCUSSIONITE_BLOCK.get());
        dropSelf(FBuildingBlocks.CUT_PERCUSSIONITE.get());
        dropSelf(FBuildingBlocks.PERCUSSIONITE_PILLAR.get());
        dropSelf(FBuildingBlocks.DISMALENE_BRICKS.get());
        dropSelf(FBuildingBlocks.POLISHED_DISMALENE.get());
        dropSelf(FBuildingBlocks.ENDERSILT_BRICKS.get());
        dropSelf(FBuildingBlocks.STALESTONE_BRICKS.get());
        dropSelf(FBuildingBlocks.POLISHED_STALESTONE.get());
        dropSelf(FBuildingBlocks.POLISHED_FRAGILE_STALESTONE.get());
        dropSelf(FBuildingBlocks.CRACKED_POLISHED_FRAGILE_STALESTONE.get());

        dropSelf(PercussioniteBars.PERCUSSIONITE_BARS.get());

        dropSelf(FLichenBlocks.CHORAL_LICHEN.get());
        dropSelf(FLichenBlocks.BUDDING_CHORAL_LICHEN.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();

        FOreBlocks.BLOCKS.getEntries().forEach(h -> blocks.add(h.value()));
        FBuildingBlocks.BLOCKS.getEntries().forEach(h -> blocks.add(h.value()));
        FNaturalBlocks.BLOCKS.getEntries().forEach(h -> blocks.add(h.value()));
        PercussioniteBars.BLOCKS.getEntries().forEach(h -> blocks.add(h.value()));
        FLichenBlocks.BLOCKS.getEntries().forEach(h -> blocks.add(h.value()));

        return blocks;
    }
}