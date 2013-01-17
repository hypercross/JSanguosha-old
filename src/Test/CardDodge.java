package Test;

import Game.ICard;
import Game.Type.LinkedType;
import Game.Type.Type;

public class CardDodge implements ICard{
	public static Type typeDodge = new LinkedType("Dodge", Type.CARD);
	
	@Override
	public void registerRules() {
		
	}

	@Override
	public Type cardType() {
		return typeDodge;
	}
}
