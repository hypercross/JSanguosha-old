package test.action;

import game.Action;
import game.entity.CardEntity;
import game.entity.PlayerEntity;
import game.type.LinkedType;
import game.type.Type;

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
