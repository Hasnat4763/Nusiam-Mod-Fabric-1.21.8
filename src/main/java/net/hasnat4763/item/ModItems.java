package net.hasnat4763.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hasnat4763.Nusiam;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import static net.hasnat4763.Nusiam.MOD_ID;


public class ModItems {
    public static final Item NUSIAM = registerItem("nusiam", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);

    }
    public static void registerModItems() {
        Nusiam.LOGGER.info("Register mod items for " + MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(NUSIAM);
        });
    }

}
