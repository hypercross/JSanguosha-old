package game;

import java.util.ArrayList;

import game.entity.PlayerEntity;

public class PlayerManager {

	public ArrayList<IPlayer> players = new ArrayList<IPlayer>();
	public int size;
	
	public boolean login(IPlayer player)
	{
		if(players.size() >= size)return false;
		players.add(player);
		return true;
	}
	
	public <T extends Action> T askForDecision(PlayerEntity thePlayer, ActionSet actions)
	{
		IPlayer player = null;
		for(IPlayer a : players)
			if(a.PlayerId() == thePlayer.playerID)player = a;
		
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
