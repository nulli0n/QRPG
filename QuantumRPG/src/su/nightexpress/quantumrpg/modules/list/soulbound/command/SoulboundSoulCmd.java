package su.nightexpress.quantumrpg.modules.list.soulbound.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import su.nexmedia.engine.utils.ItemUT;
import su.nexmedia.engine.utils.StringUT;
import su.nightexpress.quantumrpg.Perms;
import su.nightexpress.quantumrpg.modules.command.MCmd;
import su.nightexpress.quantumrpg.modules.list.soulbound.SoulboundManager;
import su.nightexpress.quantumrpg.stats.items.requirements.user.SoulboundRequirement;

public class SoulboundSoulCmd extends MCmd<SoulboundManager> {
	
	private SoulboundRequirement reqSoul;
	
	public SoulboundSoulCmd(@NotNull SoulboundManager m, @NotNull SoulboundRequirement reqSoul) {
		super(m, new String[] {"soul"}, Perms.SOULBOUND_CMD_SOUL);
		this.reqSoul = reqSoul;
	}

	@Override
	@NotNull
	public String usage() {
		return plugin.lang().Soulbound_Cmd_Soul_Usage.getMsg();
	}
	
	@Override
	@NotNull
	public List<String> getTab(@NotNull Player player, int i, @NotNull String[] args) {
		if (i == 1) {
			return Arrays.asList("add", "remove");
		}
		if (i == 2 && args[0].equalsIgnoreCase("add")) {
			return Arrays.asList("[pos]");
		}
		return super.getTab(player, i, args);
	}

	@Override
	@NotNull
	public String description() {
		return plugin.lang().Soulbound_Cmd_Soul_Desc.getMsg();
	}

	@Override
	public boolean playersOnly() {
		return true;
	}

	@Override
	public void perform(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
		if (args.length < 2 || args.length > 3) {
			this.printUsage(sender);
			return;
		}
		if (!args[1].equalsIgnoreCase("add") && !args[1].equalsIgnoreCase("remove")) {
			this.printUsage(sender);
			return;
		}
		
		Player player = (Player) sender;
		ItemStack item = player.getInventory().getItemInMainHand();
		if (ItemUT.isAir(item)) {
			plugin.lang().Error_NoItem.send(player);
			return;
		}
		
		int pos = args.length == 3 ? StringUT.getInteger(args[2], -1) : -1;
		boolean add = args[1].equalsIgnoreCase("add");
		if (add) {
			this.reqSoul.add(item, pos);
		}
		else {
			this.reqSoul.remove(item);
		}
			
		plugin.lang().Soulbound_Cmd_Soul_Done
			.replace("%state%", plugin.lang().getBool(add))
			.send(player);
	}
}
