package Game;

import Game.Entity.Entity;
import Game.Entity.GameEntity;
import Game.Type.Type;

public interface IAction {

	public Type typeDesc();
	
	public Entity getContext(String name, GameEntity ge);
	
	public void setContext(String name, Entity something, GameEntity ge);
}
