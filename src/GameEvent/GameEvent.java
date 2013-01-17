package GameEvent;

import java.util.ArrayList;

import Game.Type.Type;

public abstract class GameEvent {

	public abstract boolean resolve();
	
	public ArrayList<GameEvent> children = new ArrayList<GameEvent>();
	public GameEvent parent;
	
	public final void attach(GameEvent ge)
	{
		ge.parent = this;
		children.add(ge);
	}
	
	public Type type = Type.BASE_TYPE;
	
	public GameEvent(Type type)
	{
		this.type = type; 
	}
}
