package test.event;

import game.Action;
import game.ActionSet;
import game.entity.PlayerEntity;
import game.type.LinkedType;
import game.type.Type;
import gameEvent.GameEvent;

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


