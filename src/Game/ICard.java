package Game;

import Game.Entity.CardEntity;
import Game.Type.Type;

public interface ICard {

	Type cardType();
	
	public void registerRules(CardEntity ce);
}
