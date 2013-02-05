package gameEvent;

import game.entity.GameEntity;
import game.type.Type;

public abstract class StagedGameEvent extends GameEvent {

	int[] stages;
	
	public StagedGameEvent(Type type, GameEntity theGame, int[] stages) {
		super(type,theGame,0);
		this.stages = stages;
		triggerable = false;
	}

	@Override
	public boolean resolve() {
		
		for(int stage : stages)
		this.attach(new NestedGameEvent(this.type,theGame,stage));
		
		return true;
	}

	public abstract boolean onResolve(int stage, GameEvent sub);
	
	public static class NestedGameEvent extends GameEvent
	{

		public NestedGameEvent(Type type, GameEntity theGame, int stage) {
			super(type, theGame, stage);
		}

		@Override
		public boolean resolve() {
			return ((StagedGameEvent)parent).onResolve(this.stage, this);
		}
		
	}
	
	public String toString()
	{
		return type + " stages: (" + 
				(resolvable ? " On " : " Off ") + 
				(triggerable ? " Triggering " : " Bypassed ")
				+")";
	}
}
