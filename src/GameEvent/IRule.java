package GameEvent;

import Game.Entity.Entity;

public interface IRule {
	
	public boolean trigger(GameEvent ge);
	
	public Entity owner();
}
