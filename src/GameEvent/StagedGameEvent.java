package GameEvent;

import Game.Entity.GameEntity;
import Game.Type.Type;

public abstract class StagedGameEvent extends GameEvent {

	int[] stages;
	
	public boolean triggerable()
	{
		return false;
	}
	
	public StagedGameEvent(Type type, GameEntity theGame, int[] stages) {
		super(type,theGame,0);
		this.stages = stages;
	}

	@Override
	public boolean resolve() {
		
		for(int stage : stages)
		this.attach(new GameEvent(this.type, theGame, stage){
			@Override
			public boolean resolve() {
				return ((StagedGameEvent)parent).onResolve(this.stage);
			}
		});
		
		return false;
	}

	public abstract boolean onResolve(int stage);
}
