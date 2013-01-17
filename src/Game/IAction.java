package Game;

import Game.Entity.Entity;
import Game.Type.Type;

public interface IAction {

	public Type typeDesc();
	
	public Entity getContext(String name);
	
	Entity setContext(String name, Entity something);
}
