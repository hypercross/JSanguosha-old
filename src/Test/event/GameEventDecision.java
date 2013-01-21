package Test.event;

import Game.IAction;
import Game.IActionSet;
import Game.Entity.PlayerEntity;
import Game.Type.Type;
import GameEvent.GameEvent;

public class GameEventDecision extends GameEvent
{
	public IActionSet actions;
	public IAction response;
	public PlayerEntity who;
	public GameEventDecision(IActionSet actions, PlayerEntity who)
	{
		super(Type.EVENT_DECISION);
		this.actions = actions;
		this.who	 = who;
	}

	@Override
	public boolean resolve() {
		
		response = this.theGame.players.askForDecision(who, actions);		
		return false;
	}
}


