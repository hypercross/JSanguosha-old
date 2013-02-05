package test;

import game.entity.CardEntity;
import game.entity.Entity;
import gameEvent.GameEvent;
import gameEvent.IRule;
import test.event.GameEventPlay;

public abstract class RuleOnPlay implements IRule{
	CardEntity owner;
	
	public RuleOnPlay(CardEntity ce)
	{
		owner = ce;
	}
	
	@Override
	public boolean trigger(GameEvent ge) {
		if(ge.type.is(GameEventPlay.EVENT_PLAY) && ge.stage == 0)
		{
			GameEventPlay gep = (GameEventPlay)ge.parent;
			return onPlay(gep);
		}
		
		return false;
	}
	
	@Override
	public Entity owner()
	{
		return owner;
	}
	
	public abstract boolean onPlay(GameEventPlay ge);
}
