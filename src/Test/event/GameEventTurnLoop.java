package Test.event;

import Game.IPlayer;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;

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
