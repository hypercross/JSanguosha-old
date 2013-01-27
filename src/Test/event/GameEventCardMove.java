package Test.event;

import Game.Entity.CardEntity;
import Game.Entity.CardSlotEntity;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Game.Type.LinkedType;
import Game.Type.Type;
import GameEvent.GameEvent;

public class GameEventCardMove extends GameEvent{
	public static Type EVENT_MOVE = new LinkedType("CardMove", Type.EVENT_ENTITY);
	
	public CardEntity subject;
	public CardSlotEntity target;

	public GameEventCardMove(CardEntity subject, CardSlotEntity target) {
		super(EVENT_MOVE);
		this.subject = subject;
		this.target  = target;
	}
	
	public static GameEventCardMove draw(PlayerEntity pe)
	{
		GameEntity ge = pe.root();
		
		if(ge.child("drawDeck").size() == 0)return null;
		
		return new GameEventCardMove(
				(CardEntity) ge.child("drawDeck").get(0), 
				(CardSlotEntity) pe.child("hand"));
	}
	
	public static GameEventCardMove discard(CardEntity ce)
	{
		if(ce.container == null)return null;
		
		GameEntity ge = ce.container.root();
		
		return new GameEventCardMove(
				ce,
				(CardSlotEntity) ge.child("discardDeck"));
	}

	@Override
	public boolean resolve() {
		
		if(subject.container != null)
			subject.container.remove(subject);
		
		target.add(subject);
		subject.container = target;
		
		return false;
	}

}
