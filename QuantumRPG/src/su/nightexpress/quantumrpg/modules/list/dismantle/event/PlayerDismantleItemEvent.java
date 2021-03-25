package su.nightexpress.quantumrpg.modules.list.dismantle.event;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import su.nexmedia.engine.manager.api.event.IEvent;
import su.nightexpress.quantumrpg.modules.list.dismantle.DismantleManager.OutputContainer;

public class PlayerDismantleItemEvent extends IEvent {

	private Player player;
	private double cost;
	private Map<ItemStack, OutputContainer> result;

	public PlayerDismantleItemEvent(
			@NotNull Player player,
			double cost,
			@NotNull Map<ItemStack, OutputContainer> result
			) {
		this.player = player;
		this.cost = cost;
	    this.result = result;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	@NotNull
	public Player getPlayer() {
		return this.player;
	}
	
	@NotNull
	public Map<ItemStack, OutputContainer> getResult() {
		return new HashMap<>(this.result);
	}
}
