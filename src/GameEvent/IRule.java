package GameEvent;

import Game.Entity.Entity;

public interface IRule {
	
	public GameEvent trigger(GameEvent ge);
	
	public Entity owner();
}
