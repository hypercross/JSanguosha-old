package Test;

import Game.Entity.CardEntity;
import Game.Entity.Entity;
import GameEvent.GameEvent;
import GameEvent.IRule;
import Test.event.GameEventPlay;

public abstract class RuleOnPlay implements IRule{
	CardEntity owner;
	
	public RuleOnPlay(CardEntity ce)
	{
		owner = ce;
	}
	
	@Override
	public GameEvent trigger(GameEvent ge) {
		if(ge.type.is(GameEventPlay.EVENT_PLAY) && ge.stage == 0)
		{
			GameEventPlay gep = (GameEventPlay)ge.parent;
			if((CardEntity)gep.playAction.getContext("Card", ge.theGame) == owner)
			return onPlay(ge);
		}
		
		return null;
	}
	
	@Override
	public Entity owner()
	{
		return owner;
	}
	
	public abstract GameEvent onPlay(GameEvent ge);
}
