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
import Test.event.GameEventPlay;

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
		public GameEvent onPlay(GameEvent ge) {
			GameEventPlay gep = (GameEventPlay) ge;
			return new GameEventPlaySlash(ge.theGame, 
					(PlayerEntity)gep.playAction.getContext("from", ge.theGame),
					(PlayerEntity)gep.playAction.getContext("to", ge.theGame));
		}
	}
	
	public static class GameEventPlaySlash extends StagedGameEvent
	{
		PlayerEntity from, to;
		GameEventDecision ged;

		public GameEventPlaySlash(GameEntity theGame, PlayerEntity from, PlayerEntity to) {
			super(typeEventSlash, theGame, new int[]{0,1});
			this.from = from;
			this.to   = to;
		}	

		@Override
		public boolean onResolve(int stage, GameEvent subEvent) {
			switch(stage)
			{
			case 0:
				subEvent.attach(ged = new GameEventDecision(null, to));
				break;
			case 1:
				if(ged.response.typeDesc().is(Type.EVENT_DECISION_IDLE))
					;//attach damage event
				break;
			}
			return false;
		}
		
	}

	@Override
	public void registerRules(CardEntity ce) {
		ce.root().rules.register(new RuleOnPlaySlash(ce));
	}

}
