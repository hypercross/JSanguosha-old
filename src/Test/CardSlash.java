package Test;

import Game.ActionSet;
import Game.ICard;
import Game.Entity.CardEntity;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;
import GameEvent.StagedGameEvent;
import Test.action.ActionPlay;
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
		public boolean onPlay(GameEventPlay ge) {
			
			for(PlayerEntity target : ge.playAction.targets)
			 ge.attachToTop(new GameEventPlaySlash(ge.theGame, 
					ge.playAction.who,
					target));
			
			return true;
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
				ActionSetSingleType set = new ActionSetSingleType(ActionPlay.ACTION_PLAY);
				set.getFilter().and(ActionSet.CARDIS_DODGE).and(ActionSet.TARGET_NONE);
				subEvent.attachToTop(ged = new GameEventDecision( set , to));
				break;
			case 1:
				if(ged.getResponse().typeDesc().is(Type.EVENT_DECISION_IDLE))
					;//attach damage event
				break;
			}
			return false;
		}
		
	}
	
	public static class ActionSetSingleType extends ActionSet
	{
		Type type;
		@Override
		public Type[] actionTypes() {
			return new Type[]{type};
		}
		
		public ActionSetSingleType(Type type)
		{
			this.type = type;
		}
	}

	@Override
	public void registerRules(CardEntity ce) {
		ce.root().rules.register(new RuleOnPlaySlash(ce));
	}

}
