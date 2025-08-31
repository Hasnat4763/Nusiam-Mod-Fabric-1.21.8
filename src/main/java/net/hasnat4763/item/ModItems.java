package net.hasnat4763.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hasnat4763.Nusiam;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.function.Function;



import static net.hasnat4763.Nusiam.MOD_ID;


public class ModItems {

    public static final Item NUSIAM_INGOT = registerItem("nusiam_ingot",
            Item::new,
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item RAW_NUSIAM = registerItem("raw_nusiam",
            Item::new,
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item NOBEL_PRIZE = registerItem("nobel_prize",
            Item::new,
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item NUSIAM_SWORD = registerItem("nusiam_sword",
            Item::new,
            new Item.Settings().sword(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 4.0F, 2.4F).fireproof().rarity(Rarity.EPIC));

    public static final Item NUSIAM_PICKAXE = registerItem(
            "nusiam_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(ModToolMaterial.NUSIAM_TOOL_MATERIAL,1.0F, -2.8F).fireproof().rarity(Rarity.EPIC));

    public static final Item NUSIAM_AXE = registerItem(
            "nusiam_axe",
            settings -> new AxeItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 6.0F, -3.0F, settings),
            new Item.Settings().fireproof().rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_SHOVEL = registerItem(
            "nusiam_shovel",
            settings -> new ShovelItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, 1.5F, -3.0F, settings),
            new Item.Settings().fireproof().rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_HOE = registerItem(
            "nusiam_hoe",
            settings -> new HoeItem(ModToolMaterial.NUSIAM_TOOL_MATERIAL, -4.0F, 0.0F, settings),
            new Item.Settings().fireproof().rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_HELMET = registerItem(
            "nusiam_helmet",
            Item::new,
            new Item.Settings().armor(ModArmorMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.HELMET).rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_CHESTPLATE = registerItem(
            "nusiam_chestplate",
            Item::new,
            new Item.Settings().armor(ModArmorMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE).rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_LEGGINGS = registerItem(
            "nusiam_leggings",
            Item::new,
            new Item.Settings().armor(ModArmorMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.LEGGINGS).rarity(Rarity.EPIC)
    );

    public static final Item NUSIAM_BOOTS = registerItem(
            "nusiam_boots",
            Item::new,
            new Item.Settings().armor(ModArmorMaterial.NUSIAM_ARMOR_MATERIAL, EquipmentType.BOOTS).rarity(Rarity.EPIC)
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
