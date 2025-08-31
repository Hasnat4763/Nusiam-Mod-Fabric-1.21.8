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

    public static final ToolMaterial NUSIAM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            5000,
            100.0F,
            20.0F,
            100,
            NUSIAM_TOOLS
    );
}
