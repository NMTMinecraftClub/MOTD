package nmt.minecraft.smartinez.motd;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Motd extends JavaPlugin implements Listener{
	private String message = "ADMIN HAS NOT YET SET UP THE MESSAGE OF THE DAY";	
	
	@Override
	public void onEnable(){
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHH TESTING STUFF");
		//get the message and save it
		message = this.getConfig().get("message").toString();
	}
	
	
	//detect when a player logs in
	@EventHandler 
	public void onPlayerJoin(PlayerJoinEvent event){
		  Player player = event.getPlayer();
		  event.setJoinMessage("");
		  getLogger().info("PPPPPPPPPPPPPPPLLLLLLLLLLLLLLLLLAYYYYYYYYYYYYYYYYYEEEEERRRRRRRRRRR");
		  player.sendMessage(message);
	}
		
}
