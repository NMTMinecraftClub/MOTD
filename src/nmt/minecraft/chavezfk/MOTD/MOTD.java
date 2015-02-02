package nmt.minecraft.chavezfk.MOTD;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author chavezfk (Franz Chavez)
 * @date 2/2/2015
 * @version 1.0
 */
public class MOTD extends JavaPlugin implements Listener{
	
	/**
	 * The events are sent to be registered and the console logs
	 * that the plugin has been successfully enabled. 
	 */
	@Override
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this,this);
		getLogger().info("Message of the day Enabled!");
		
	}
	@Override
	public void onDisable(){
		getLogger().info("Message of the day Disabled! :(");
	}
	/**
	 * When a player joins, the message of the day 
	 * is retrieved from the properties file
	 * and is then sent to the player in a message. 
	 * 
	 * @param event
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		String message = Bukkit.getMotd(); 
		p.sendMessage(ChatColor.GREEN + message);
	}
}
