package test.event;

import game.IPlayer;
import game.entity.GameEntity;
import game.entity.PlayerEntity;
import game.type.LinkedType;
import game.type.Type;
import gameEvent.GameEvent;

public class GameEventTurnLoop extends GameEvent{
	public static Type EVENT_TURN = new LinkedType("Turn",Type.EVENT_PHRASE);

	public GameEventTurnLoop(GameEntity theGame) {
		super(EVENT_TURN, theGame, 0);
	}

	@Override
	public boolean resolve() {
		this.triggerable = true;
		this.resolvable  = true; 
		
		for(IPlayer player : theGame.players.players)
		{
			PlayerEntity pe = (PlayerEntity) theGame.child("player" + player.PlayerId());
			
			this.attach(new GameEventPhrase(theGame,pe));
		}
		
		return true;
	}
	
}
