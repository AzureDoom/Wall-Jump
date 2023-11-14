package genandnic.walljump.enchantment;

import genandnic.walljump.WallJump;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class DoubleJumpEnchantment extends Enchantment {

	public DoubleJumpEnchantment(Enchantment.Rarity weight, EnchantmentCategory target, EquipmentSlot... slots) {
		super(weight, target, slots);
	}

	@Override
	public int getMinLevel() {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return WallJump.CONFIGURATION.enchantconfigs.doublejump_maxlevel;
	}

	@Override
	public int getMinCost(int level) {
		return level * 20;
	}

	@Override
	public int getMaxCost(int level) {
		return level * 60;
	}

	@Override
	public boolean checkCompatibility(Enchantment enchantment) {
		if (enchantment instanceof ProtectionEnchantment proenchant)
			return proenchant.type != ProtectionEnchantment.Type.FALL;

		return this != enchantment;
	}

	@Override
	public boolean canEnchant(ItemStack stack) {

		if (!WallJump.CONFIGURATION.enchantconfigs.enableEnchantments)
			return false;

		return stack.getItem() instanceof ArmorItem && stack.isEnchantable();
	}
}
