package Game;

import java.util.HashMap;

import Game.Entity.CardSlotEntity;
import Game.Entity.GameEntity;

public class Environment {
	public HashMap<String, IPackage> packages = new HashMap<String, IPackage>();
	
	public ICard[] cards;
	
	public void setupDeck(CardSlotEntity container)
	{}

	public void setupGame(GameEntity gameEntity) {
		
	}
}
