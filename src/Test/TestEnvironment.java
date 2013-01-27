package Test;

import Game.Environment;
import Game.ICard;
import Game.IPlayer;
import Game.Entity.CardEntity;
import Game.Entity.CardSlotEntity;
import Game.Entity.GameEntity;
import Game.Entity.PlayerEntity;
import Test.event.GameEventTurnLoop;

public class TestEnvironment extends Environment{
	
	public TestEnvironment()
	{
		cards = new ICard[5];
		
		cards[0] = new CardSlash();
		cards[1] = new CardSlash();
		cards[2] = new CardSlash();
		cards[3] = new CardDodge();
		cards[4] = new CardDodge();
	}
	
	public void setupGame(GameEntity gameEntity) {
		gameEntity.events.setRoot(new GameEventTurnLoop(gameEntity));
		
		for(IPlayer ip : gameEntity.players.players)
		{
			PlayerEntity pe = (PlayerEntity) gameEntity.child("player" + ip.PlayerId());
			
			pe.hp = 4;
			pe.isAlive = true;
			pe.maxHp = 4;
		}
	}
	
	public void setupDeck(CardSlotEntity slot)
	{
		if(slot.name().equals("drawDeck"))
		{
			for(int i =0;i<5;i++)
			{
				CardEntity ce = new CardEntity(i, i, 'S', cards[i]);
				slot.add(ce);
				ce.container = slot;
			}
			slot.shuffle();
		}
	}
}
