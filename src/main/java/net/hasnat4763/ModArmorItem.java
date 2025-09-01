package net.hasnat4763;

import com.google.common.collect.ImmutableMap;
import net.hasnat4763.item.ModArmorMaterial;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends Item {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>()
                    .put(ModArmorMaterial.NUSIAM_ARMOR_MATERIAL,
                            List.of(
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 220, 3, false, false),
                                    new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 220, 10, false, false),
                                    new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 220, 10, false, false),
                                    new StatusEffectInstance(StatusEffects.LUCK, 220, 10, false, false),
                                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 220, 10, false, false)

                            ))
                    .build();

    public ModArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }


    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, effects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> effects) {
        for (StatusEffectInstance effect : effects) {
            // Reapply with short buffer so it never runs out
            StatusEffectInstance newEffect = new StatusEffectInstance(
                    effect.getEffectType(),
                    effect.getDuration(),
                    effect.getAmplifier(),
                    effect.isAmbient(),
                    effect.shouldShowParticles()
            );
            player.addStatusEffect(newEffect);
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        return !player.getEquippedStack(EquipmentSlot.HEAD).isEmpty()
                && !player.getEquippedStack(EquipmentSlot.CHEST).isEmpty()
                && !player.getEquippedStack(EquipmentSlot.LEGS).isEmpty()
                && !player.getEquippedStack(EquipmentSlot.FEET).isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        return isCorrectArmor(player.getEquippedStack(EquipmentSlot.HEAD), material)
                && isCorrectArmor(player.getEquippedStack(EquipmentSlot.CHEST), material)
                && isCorrectArmor(player.getEquippedStack(EquipmentSlot.LEGS), material)
                && isCorrectArmor(player.getEquippedStack(EquipmentSlot.FEET), material);
    }

    private boolean isCorrectArmor(ItemStack stack, ArmorMaterial material) {
        EquippableComponent component = stack.getComponents().get(DataComponentTypes.EQUIPPABLE);
        return component != null && component.assetId().isPresent() && component.assetId().get().equals(material.assetId());
    }
}
