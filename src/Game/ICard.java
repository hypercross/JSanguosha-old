package game;

import game.entity.CardEntity;
import game.type.Type;

public interface ICard {

	Type cardType();
	
	public void registerRules(CardEntity ce);
}
