package Test;

import Game.Entity.Entity;
import Game.Entity.GameEntity;
import GameEvent.GameEvent;
import GameEvent.IRule;

public class RuleClassical implements IRule {

	GameEntity game;
	
	public RuleClassical(GameEntity theGame)
	{
		game = theGame;
	}
	
	@Override
	public GameEvent trigger(GameEvent ge) {
		return null;
	}

	@Override
	public Entity owner() {
		return game;
	}

}
