package Test;

import Game.Entity.CardEntity;
import Game.Entity.Entity;
import Game.Type.Type;
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
			if(watchedType( ((CardEntity)gep.playAction.getContext("Card", ge.theGame)).type ))
			return onPlay(ge);
		}
		
		return null;
	}
	
	@Override
	public Entity owner()
	{
		return owner;
	}

	public abstract boolean watchedType(Type cardType);
	
	public abstract GameEvent onPlay(GameEvent ge);
}
