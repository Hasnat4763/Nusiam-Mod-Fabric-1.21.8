package net.hasnat4763.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hasnat4763.Nusiam;
import net.hasnat4763.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import static net.hasnat4763.Nusiam.MOD_ID;


public class ModItemGroup {
    public static final ItemGroup NUSIAM_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(MOD_ID, "item_group"),
                    FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NUSIAM_INGOT))
                    .displayName(Text.translatable("itemgroup.nusiam.nusiam_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.NUSIAM_INGOT);
                        entries.add(ModItems.RAW_NUSIAM);
                        entries.add(ModBlocks.NUSIAM_ORE);
                        entries.add(ModItems.NOBEL_PRIZE);
                        entries.add(ModItems.NUSIAM_SWORD);
                        entries.add(ModItems.NUSIAM_PICKAXE);
                        entries.add(ModItems.NUSIAM_AXE);
                        entries.add(ModItems.NUSIAM_HOE);
                        entries.add(ModItems.NUSIAM_SHOVEL);
                        entries.add(ModItems.NUSIAM_HELMET);
                        entries.add(ModItems.NUSIAM_CHESTPLATE);
                        entries.add(ModItems.NUSIAM_LEGGINGS);
                        entries.add(ModItems.NUSIAM_BOOTS);
                        })
                    .build());


    public static void RegisterItemGroup() {
        Nusiam.LOGGER.info("Registering item group for mod" + MOD_ID);
    }
}
