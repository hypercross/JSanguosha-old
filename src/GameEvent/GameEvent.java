package GameEvent;

import java.util.ArrayList;

import Game.Entity.GameEntity;
import Game.Type.Type;

public abstract class GameEvent {

	public abstract boolean resolve();
	
	public ArrayList<GameEvent> children = new ArrayList<GameEvent>();
	public GameEvent parent;
	public GameEntity theGame;
	public int stage;
	
	public boolean triggerable()
	{
		return true;
	}
	
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
