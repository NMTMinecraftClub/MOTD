package nmt.minecraft.jpmac26.MOTD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTDPlugin extends JavaPlugin implements Listener {

	private String defaultMsg = "A wild MISSINGMOTD. appeared!";
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("Message of the Day is now enabled.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Message of the Day is now disabled.");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player thisPlayer = event.getPlayer();
		getLogger().info("Player with username " + thisPlayer.getPlayerListName() + " has joined.");
		
		displayMOTD(thisPlayer);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("motd")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				Player player = (Player) sender;
				displayMOTD(player);
			}
			return true;
		}
		return false;
	}
	
	private void displayMOTD(Player player) {
		String eol = System.getProperty("line.separator");
		String msgToSend;
		if (this.getConfig().get("message") != null)
			msgToSend = this.getConfig().get("message").toString();
		else {
			msgToSend = defaultMsg;
			getLogger().info("YOU MUST CONSTRUCT ADDITIONAL PYLONS." + eol
					+ "Also, we failed to load the MOTD from config.yml, so look into that too.");
		}
		
		if (player.isOnline()) {
			player.sendMessage("You want to know the Message of the Day? Fine, here it is:");
			player.sendMessage(msgToSend);
		}
	}
}
