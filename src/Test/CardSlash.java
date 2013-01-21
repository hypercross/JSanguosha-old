package Test;

import Game.ICard;
import Game.Entity.CardEntity;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;
import GameEvent.StagedGameEvent;
import Test.event.GameEventDecision;

public class CardSlash implements ICard{
	public static Type typeCardSlash = new LinkedType("Slash",Type.CARD);
	public static Type typeEventSlash = new LinkedType("Slash",Type.EVENT_ENTITY);

	@Override
	public Type cardType() {
		return typeCardSlash;
	}
	
	public static class RuleOnPlaySlash extends RuleOnPlay
	{
		public RuleOnPlaySlash(CardEntity ce) {
			super(ce);
		}

		@Override
		public boolean watchedType(Type cardType) {
			return cardType.is(typeCardSlash);
		}

		@Override
		public GameEvent onPlay(GameEvent ge) {
			return null;
		}
	}
	
	public static class GameEventPlaySlash extends StagedGameEvent
	{
		PlayerEntity from, to;
		GameEventDecision ged;

		public GameEventPlaySlash(GameEntity theGame, PlayerEntity from, PlayerEntity to) {
			super(typeEventSlash, theGame, new int[]{0,1});
		}

		@Override
		public boolean onResolve(int stage) {
			switch(stage)
			{
			case 0:
				
				break;
			case 1:
				break;
			}
			return false;
		}
		
	}

	@Override
	public void registerRules(CardEntity ce) {
	}

}
