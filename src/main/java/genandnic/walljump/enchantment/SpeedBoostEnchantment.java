package genandnic.walljump.enchantment;

import genandnic.walljump.WallJump;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SpeedBoostEnchantment extends Enchantment {
	public SpeedBoostEnchantment(Enchantment.Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public int getMinLevel() {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return WallJump.CONFIGURATION.enchantconfigs.speedboost_maxlevel;
	}

	@Override
	public int getMinCost(int level) {
		return level * 15;
	}

	@Override
	public int getMaxCost(int level) {
		return level * 60;
	}

	@Override
	public boolean canEnchant(ItemStack stack) {

		if (!WallJump.CONFIGURATION.enchantconfigs.enableEnchantments)
			return false;
		
		return stack.isEnchantable() && (stack.getItem() instanceof ElytraItem || stack.getItem() instanceof ArmorItem);
	}
}
