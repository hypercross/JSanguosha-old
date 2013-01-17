package Test;

import Game.Type.TypeCard;
import GameEvent.GameEvent;
import GameEvent.IRule;

public class RuleOnPlay implements IRule{

	@Override
	public GameEvent trigger(GameEvent ge) {
		
		return null;
	}

	public boolean watchedType(TypeCard cardType)
	{
		return false;
	}
	
	public void onResolve()
	{
		
	}
}
