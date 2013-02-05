package test;

import game.ICard;
import game.entity.CardEntity;
import game.type.LinkedType;
import game.type.Type;

public class CardDodge implements ICard{
	public static Type typeDodge = new LinkedType("Dodge", Type.CARD);
	
	@Override
	public void registerRules(CardEntity ce) {
		
	}

	@Override
	public Type cardType() {
		return typeDodge;
	}
}
