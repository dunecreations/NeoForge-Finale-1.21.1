package net.reianis.finale;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.reianis.finale.block.FBuildingBlocks;
import net.reianis.finale.block.FNaturalBlocks;
import net.reianis.finale.block.FOreBlocks;
import net.reianis.finale.block.custom.FLichenBlocks;
import net.reianis.finale.block.custom.PercussioniteBars;
import net.reianis.finale.item.FItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Finale.MOD_ID)
public class Finale {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "finale";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Finale(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        FItems.register(modEventBus);
        FNaturalBlocks.register(modEventBus);
        FBuildingBlocks.register(modEventBus);
        PercussioniteBars.register(modEventBus);
        FLichenBlocks.register(modEventBus);
        FOreBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    /**
     * Add the example block item to the building blocks tab
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(FItems.RAW_PERCUSSIONITE);
            event.accept(FItems.PERCUSSIONITE_INGOT);
            event.accept(FItems.ENDERSILT_BRICK);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(FNaturalBlocks.CHORAL_END_STONE);

            event.accept(FNaturalBlocks.ENDERSILT);

            event.accept(FNaturalBlocks.DISMALENE);

            event.accept(FNaturalBlocks.STALESTONE);
            event.accept(FNaturalBlocks.FRAGILE_STALESTONE);
            event.accept(FNaturalBlocks.CRACKED_FRAGILE_STALESTONE);

            event.accept(FLichenBlocks.CHORAL_LICHEN);
            event.accept(FLichenBlocks.BUDDING_CHORAL_LICHEN);

            event.accept(FOreBlocks.END_STONE_PERCUSSIONITE_ORE);
            event.accept(FOreBlocks.DISMALENE_PERCUSSIONITE_ORE);
            event.accept(FOreBlocks.STALESTONE_PERCUSSIONITE_ORE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(FBuildingBlocks.POLISHED_END_STONE);

            event.accept(FBuildingBlocks.ENDERSILT_BRICKS);

            event.accept(FBuildingBlocks.PERCUSSIONITE_BLOCK);
            event.accept(FBuildingBlocks.CUT_PERCUSSIONITE);
            event.accept(FBuildingBlocks.PERCUSSIONITE_PILLAR);
            event.accept(PercussioniteBars.PERCUSSIONITE_BARS);

            event.accept(FBuildingBlocks.POLISHED_DISMALENE);
            event.accept(FBuildingBlocks.DISMALENE_BRICKS);
            event.accept(FBuildingBlocks.POLISHED_STALESTONE);
            event.accept(FBuildingBlocks.STALESTONE_BRICKS);
            event.accept(FBuildingBlocks.POLISHED_FRAGILE_STALESTONE);
            event.accept(FBuildingBlocks.CRACKED_POLISHED_FRAGILE_STALESTONE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = Finale.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {

        }

    }
}
