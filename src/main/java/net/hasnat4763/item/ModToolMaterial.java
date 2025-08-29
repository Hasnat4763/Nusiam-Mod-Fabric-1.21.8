package net.hasnat4763.item;
import net.hasnat4763.Nusiam;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.Map;

import static net.hasnat4763.utils.ModTags.items.NUSIAM_ARMOR;
import static net.hasnat4763.utils.ModTags.items.NUSIAM_TOOLS;

public class ModToolMaterial {
    public static final RegistryKey<EquipmentAsset> NUSIAM_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Nusiam.MOD_ID, "nusiam"));
    public static final ToolMaterial NUSIAM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            5000,
            100F,
            15F,
            100,
            NUSIAM_TOOLS
    );

    public static final ArmorMaterial NUSIAM_ARMOR_MATERIAL = new ArmorMaterial(
            5000,
            Map.of(
                    EquipmentType.HELMET, 4,
                    EquipmentType.CHESTPLATE, 10,
                    EquipmentType.LEGGINGS, 8,
                    EquipmentType.BOOTS, 4
            ),
            100,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            10F,
            20F,
            NUSIAM_ARMOR,
            NUSIAM_ARMOR_MATERIAL_KEY
    );
}
