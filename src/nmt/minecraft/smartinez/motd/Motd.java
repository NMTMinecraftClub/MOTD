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
	}
	
	//detect when a player logs in
	@EventHandler 
	public void onPlayerJoin(PlayerJoinEvent event){
		  Player player = event.getPlayer();
		  getLogger().info(player.getDisplayName()+" Has logged in.");
		  
		  //get the message from the config file
		  String mssg = this.getConfig().get("message").toString();
		  if(mssg.isEmpty()){
			  mssg = message;
		  }
		  
		  //send the message
		  player.sendMessage(mssg);
	}
}
