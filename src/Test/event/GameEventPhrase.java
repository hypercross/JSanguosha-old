package Test.event;

import Game.Entity.CardEntity;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;
import GameEvent.StagedGameEvent;

public class GameEventPhrase extends StagedGameEvent{
	public static Type EVENT_PHRASE = new LinkedType("Phrase",Type.EVENT_PHRASE);
	public PlayerEntity pe;

	public GameEventPhrase(GameEntity theGame, PlayerEntity pe) {
		super(EVENT_PHRASE, theGame, new int[]{0,1,2,3,4});
		this.pe = pe;
	}

	@Override
	public boolean onResolve(int stage, GameEvent sub) {

		switch(stage)
		{
		case 0:
			//start phrase
			break;
		case 1:
			//judge
			break;
		case 2:
			//draw cards
			sub.attach(GameEventCardMove.draw(pe));
			return true;
		case 3:
			//play
			break;
		case 4:
			//discard
			sub.attach(GameEventCardMove.discard((CardEntity) pe.child("hand").get(0)));
			return true;
		}
		
		return false;
	}

}
