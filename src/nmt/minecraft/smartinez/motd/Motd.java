package nmt.minecraft.smartinez.motd;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Motd extends JavaPlugin implements Listener{
	//private String message = "ADMIN HAS NOT YET SET UP THE MESSAGE OF THE DAY";	
	
	void OnEnable(){
		//getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHH TESTING STUFF");
		System.out.println("MOOOOOORRRRRRRRRRRRRRRRRR STTTTTUUUUUUUUUFFFFFFFFFFF");
		//get the message and save it
		
	}
	/*
	//detect when a player logs in
	@EventHandler(priority = EventPriority.NORMAL)
	public void onLogin(PlayerLoginEvent event) {
		//print the motd to that user's terminal
		event.getPlayer().sendMessage(message);
		getLogger().info(event.getPlayer().getDisplayName()+"logged in AND GOT THE MESSAGE");
	}
		*/
}
