package gameEvent;

import game.entity.Entity;

public interface IRule {
	
	public boolean trigger(GameEvent ge);
	
	public Entity owner();
}
