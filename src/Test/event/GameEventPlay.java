package test.event;

import game.entity.GameEntity;
import game.type.LinkedType;
import game.type.Type;
import gameEvent.GameEvent;
import gameEvent.StagedGameEvent;
import test.action.ActionPlay;

public class GameEventPlay extends StagedGameEvent
{

	public static Type EVENT_PLAY = new LinkedType("Play",Type.EVENT_ENTITY);
	
	
	public ActionPlay playAction;	
	public GameEventPlay(GameEntity theGame, ActionPlay action) {
		super(EVENT_PLAY, theGame, new int[]{-1,0,1});
		playAction = action;
	}
	
	@Override
	public boolean onResolve(int stage, GameEvent subEvent) {
		return false;
	}	
};