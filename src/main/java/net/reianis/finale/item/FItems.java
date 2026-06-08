package net.reianis.finale.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reianis.finale.Finale;

public class FItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Finale.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> RAW_PERCUSSIONITE = ITEMS.register("raw_percussionite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PERCUSSIONITE_INGOT = ITEMS.register("percussionite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ENDERSILT_BRICK = ITEMS.register("endersilt_brick",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
