package Test.event;

import Game.Action;
import Game.ActionSet;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;

public class GameEventDecision extends GameEvent
{
	public static Type EVENT_QUERY = new LinkedType("Query", Type.EVENT_DECISION); 
	
	public ActionSet actions;
	public Action response;
	public PlayerEntity who;
	public GameEventDecision(ActionSet actions, PlayerEntity who)
	{
		super(EVENT_QUERY, who.root());
		this.actions = actions;
		this.who	 = who;
	}

	@Override
	public boolean resolve() {
		
		response = this.theGame.players.askForDecision(who, actions);		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Action> T getResponse()
	{
		return (T) response;
	}
}


