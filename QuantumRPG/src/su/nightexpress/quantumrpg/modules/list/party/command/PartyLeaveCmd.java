package su.nightexpress.quantumrpg.modules.list.party.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import su.nightexpress.quantumrpg.Perms;
import su.nightexpress.quantumrpg.modules.command.MCmd;
import su.nightexpress.quantumrpg.modules.list.party.PartyManager;
import su.nightexpress.quantumrpg.modules.list.party.PartyManager.PartyMember;

public class PartyLeaveCmd extends MCmd<PartyManager> {

	public PartyLeaveCmd(@NotNull PartyManager m) {
		super(m, new String[] {"leave"}, Perms.PARTY_CMD_LEAVE);
	}

	@Override
	@NotNull
	public String usage() {
		return "";
	}

	@Override
	@NotNull
	public String description() {
		return plugin.lang().Party_Cmd_Leave_Desc.getMsg();
	}

	@Override
	public boolean playersOnly() {
		return true;
	}
	
	@Override
	public void perform(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
		Player player = (Player) sender;
		
		PartyMember member = module.getPartyMember(player);
		if (member == null) {
			plugin.lang().Party_Error_NotInParty.send(player);
			return;
		}
		
		member.leaveParty();
	}
}
