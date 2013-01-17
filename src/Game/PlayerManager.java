package Game;

import java.util.ArrayList;

public class PlayerManager {

	public ArrayList<IPlayer> players = new ArrayList<IPlayer>();
	public int size;
	
	public boolean login(IPlayer player)
	{
		if(players.size() >= size)return false;
		players.add(player);
		return true;
	}
	
	public IAction askForDecision(IPlayer player, IActionSet actions)
	{
		player.propose(actions);
		
		try{
			while(!player.isReady())Thread.sleep(20);
		}catch(Exception e){}//shouldn't happen
		
		return player.getDecision();
	}
	
	public void logout(IPlayer player)
	{
		players.remove(player);
	}
}
