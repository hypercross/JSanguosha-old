package gameEvent;

import java.util.ArrayList;

import game.entity.GameEntity;
import game.type.Type;

public abstract class GameEvent {

	public abstract boolean resolve();
	
	public ArrayList<GameEvent> children = new ArrayList<GameEvent>();
	public GameEvent parent;
	public GameEntity theGame;
	public int stage;
	public boolean resolvable = true;
	public boolean triggerable = true;
	public Type type = Type.BASE_TYPE;
	
	public String toString()
	{
		return type + " at stage " + stage + 
				(resolvable ? ", On " : ", Off ") + 
				(triggerable ? ", Triggering " : ", Bypassed ");
	}
	
	public final void attach(GameEvent ge)
	{
		ge.parent = this;
		children.add(ge);
	}
	
	public final void attachToTop(GameEvent ge)
	{
		if(children.isEmpty())attach(ge);
		else children.get(0).attachToTop(ge);
	}
	
	
	public GameEvent(Type type)
	{
		this.type = type; 
	}
	
	public GameEvent(Type type, int stage)
	{
		this.type = type;
		this.stage = stage;
	}
	
	public GameEvent(Type type, GameEntity theGame)
	{
		this.type = type;
		this.theGame = theGame;
	}
	
	public GameEvent(Type type, GameEntity theGame, int stage)
	{
		this.type = type;
		this.theGame = theGame;
		this.stage = stage;
	}
	
	public static class GameEventEmpty extends GameEvent
	{

		public GameEventEmpty(Type type, GameEntity theGame, int stage)
		{
			super(type,theGame,stage);
		}

		@Override
		public boolean resolve() {
			return false;
		}
		
	}
}
