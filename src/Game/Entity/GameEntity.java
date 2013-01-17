package Game.Entity;

import Game.Environment;
import Game.IEntityContainer;
import Game.IPlayer;
import Game.PlayerManager;
import Game.Type.Type;
import GameEvent.GameEvent;
import GameEvent.GameEventTree;
import GameEvent.RuleRegistry;

@SuppressWarnings("serial")
public class GameEntity extends Entity{
	
	public static int TRIGGER_DEPTH = 1000;
	
	public Environment environment;
	public PlayerManager players;
	public GameEventTree events;
	public RuleRegistry rules;
	
	public void setupCommon()
	{
		CardSlotEntity entity = new CardSlotEntity();
		entity.type = Type.CARD_SLOT;
		entity.viewable = false;
		setChild("drawDeck", entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.CARD_SLOT;
		setChild("discardDeck", entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.CARD_SLOT;
		setChild("table", entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.CARD_SLOT;
		setChild("generalDeck", entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.CARD_SLOT;
		setChild("roleDeck", entity);
		
		int seat = 0;
		for(IPlayer player : players.players)
		{
			int id = player.PlayerId();
			
			PlayerEntity pe = new PlayerEntity();
			pe.playerID = id;
			pe.seatId = seat++;
			pe.type = Type.PLAYER;
			
			setChild("player"+id, pe);
		}
		
		for(IEntityContainer iec : children.values())
			environment.setupDeck(iec);
		
		environment.setupGame(this);
	}
	
	public void step()
	{
		GameEvent ge = events.peek();
		
		int i =0;
		while(rules.trigger(ge) && i<TRIGGER_DEPTH)i++;
		
		events.pop().resolve();
	}
}
