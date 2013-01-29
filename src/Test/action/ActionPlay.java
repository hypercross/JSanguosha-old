package Test.action;

import Game.Action;
import Game.Entity.CardEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;

public class ActionPlay extends Action{
	public static Type ACTION_PLAY = new LinkedType("Play", Type.EVENT_DECISION);

	@Override
	public Type typeDesc() {
		return ACTION_PLAY;
	}

	public PlayerEntity who;
	public CardEntity card;
	public PlayerEntity[] targets;
	
	public ActionPlay(PlayerEntity who, CardEntity card, PlayerEntity... targets)
	{
		this.who = who;
		this.card = card;
		this.targets = targets;
	}
}
