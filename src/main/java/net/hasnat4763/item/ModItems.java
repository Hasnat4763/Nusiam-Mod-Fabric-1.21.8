package net.hasnat4763.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hasnat4763.Nusiam;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

import static net.hasnat4763.Nusiam.MOD_ID;


public class ModItems {
    public static final Item NUSIAM_INGOT = registerItem("nusiam_ingot", Item::new, new Item.Settings());
    public static final Item RAW_NUSIAM = registerItem("raw_nusiam", Item::new, new Item.Settings());
    public static final Item NOBEL_PRIZE = registerItem("nobel_prize", Item::new, new Item.Settings());
    public static final Item NUSIAM_SWORD = registerItem(
            "nusiam_sword",
            settings -> new SwordItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 10f, 20f),
            new Item.Settings()
    );
    public static final Item NUSIAM_PICKAXE = registerItem(
            "nusiam_pickaxe",
            settings -> new PickaxeItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 5, 20f, settings),
            new Item.Settings()
    );
    public static final Item NUSIAM_AXE = registerItem(
            "nusiam_axe",
            settings -> new AxeItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings()
    );
    public static final Item NUSIAM_SHOVEL = registerItem(
            "nusiam_shovel",
            settings -> new ShovelItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings()
    );
    public static final Item NUSIAM_HOE = registerItem(
            "nusiam_hoe",
            settings -> new HoeItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings()
    );
    public static final Item NUSIAM_HELMET = registerItem(
            "nusiam_helmet",
            Item::new,
            new Item.Settings().armor(ModToolMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.HELMET)
    );
    public static final Item NUSIAM_CHESTPLATE = registerItem(
            "nusiam_chestplate",
            Item::new,
            new Item.Settings().armor(ModToolMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
    );
    public static final Item NUSIAM_LEGGINGS = registerItem(
            "nusiam_leggings",
            Item::new,
            new Item.Settings().armor(ModToolMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
    );
    public static final Item NUSIAM_BOOTS = registerItem(
            "nusiam_boots",
            Item::new,
            new Item.Settings().armor(ModToolMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.BOOTS)
    );



    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        Nusiam.LOGGER.info("Register mod items for " + MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries->{
            entries.add(NUSIAM_INGOT);
            entries.add(RAW_NUSIAM);
            entries.add(NOBEL_PRIZE);
            entries.add(NUSIAM_SWORD);
            entries.add(NUSIAM_PICKAXE);
            entries.add(NUSIAM_AXE);
            entries.add(NUSIAM_HOE);
            entries.add(NUSIAM_SHOVEL);
            entries.add(NUSIAM_HELMET);
            entries.add(NUSIAM_LEGGINGS);
            entries.add(NUSIAM_BOOTS);
            entries.add(NUSIAM_CHESTPLATE);

        });
    }

}
