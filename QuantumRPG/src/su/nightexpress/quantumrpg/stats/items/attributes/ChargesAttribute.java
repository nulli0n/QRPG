package su.nightexpress.quantumrpg.stats.items.attributes;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import su.nightexpress.quantumrpg.config.EngineCfg;
import su.nightexpress.quantumrpg.stats.items.ItemTags;
import su.nightexpress.quantumrpg.stats.items.api.ItemLoreStat;

public class ChargesAttribute extends ItemLoreStat<int[]> {

	public ChargesAttribute(
			@NotNull String name,
			@NotNull String format
			) {
		super("ITEM_CHARGES", name, format, ItemTags.PLACEHOLDER_ITEM_CHARGES, ItemTags.TAG_ITEM_CHARGES, PersistentDataType.INTEGER_ARRAY);
	}
	
	@Override
	protected boolean isSingle() {
		return true;
	}

	@NotNull
	public void takeCharges(@NotNull ItemStack item, int amount, boolean doBreak) {
		int[] values = this.getRaw(item);
		if (values == null) return;
		
		int current = values[0];
		if (current < 0) return;
		
		int max = values.length == 2 ? values[1] : current;
		
		int taken = current - amount;
		if (taken <= 0 && doBreak) {
			item.setAmount(0);
			return;
		}
		
		this.add(item, new int[] {taken,max}, -1);
		return;
	}
	
	@Override
	@NotNull
	public String formatValue(@NotNull ItemStack item, int @NotNull [] value) {
		int min = value[0];
		int max = value.length == 2 ? value[1] : min;
		
		if (max == 0) {
			return "";
		}
		if (max < 0) {
			return EngineCfg.LORE_STYLE_ATT_CHARGES_FORMAT_UNLIMITED;
		}
		return EngineCfg.LORE_STYLE_ATT_CHARGES_FORMAT_DEFAULT
				.replace("%max%", String.valueOf(max))
				.replace("%min%", String.valueOf(min));
	}

}
