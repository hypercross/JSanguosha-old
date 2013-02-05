package test;

import game.entity.Entity;
import game.entity.GameEntity;
import gameEvent.GameEvent;
import gameEvent.IRule;

public class RuleClassical implements IRule {

	GameEntity game;
	
	public RuleClassical(GameEntity theGame)
	{
		game = theGame;
	}
	
	@Override
	public boolean trigger(GameEvent ge) {
		return false;
	}

	@Override
	public Entity owner() {
		return game;
	}

}
