package net.hasnat4763.utils;

import net.hasnat4763.Nusiam;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class items {
        public static final TagKey<Item> NUSIAM_TOOLS = createTag("nusiam_tools");
        public static final TagKey<Item> NUSIAM_ARMOR = createTag("nusiam_armor");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Nusiam.MOD_ID, name));
        }
    }

}
