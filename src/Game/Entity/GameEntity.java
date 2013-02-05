package game.entity;

import game.Environment;
import game.IPlayer;
import game.PlayerManager;
import game.type.Type;
import gameEvent.GameEvent;
import gameEvent.GameEventTree;
import gameEvent.RuleRegistry;

@SuppressWarnings("serial")
public class GameEntity extends Entity{
	
	public static int TRIGGER_DEPTH = 1000;
	
	public Environment environment;
	public PlayerManager players;
	public GameEventTree events;
	public RuleRegistry rules;
	
	public void init()
	{
		events = new GameEventTree();
		rules = new RuleRegistry();
		this.type = Type.ENTITY_GAME;
		this.name = "the game";
	}
	
	public void setupCommon()
	{
		CardSlotEntity entity = new CardSlotEntity();
		entity.type = Type.ENTITY_SLOT;
		entity.viewable = false;
		setChild("drawDeck", entity);
		environment.setupDeck(entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.ENTITY_SLOT;
		setChild("discardDeck", entity);
		environment.setupDeck(entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.ENTITY_SLOT;
		setChild("table", entity);
		environment.setupDeck(entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.ENTITY_SLOT;
		setChild("generalDeck", entity);
		environment.setupDeck(entity);
		
		entity = new CardSlotEntity();
		entity.type = Type.ENTITY_SLOT;
		setChild("roleDeck", entity);
		environment.setupDeck(entity);
		
		int seat = 0;
		for(IPlayer player : players.players)
		{
			int id = player.PlayerId();
			
			PlayerEntity pe = new PlayerEntity();
			pe.playerID = id;
			pe.seatId = seat++;
			pe.type = Type.ENTITY_PLAYER;
			
			setChild("player"+id, pe);
		}
		
		environment.setupGame(this);
	}
	
	public void step()
	{
		GameEvent ge = events.peek();
		int i =0;
		while(ge.triggerable && rules.trigger(ge) && i<TRIGGER_DEPTH)
		{
			i++;
			ge.triggerable = false;
			ge = events.peek();
		}
		
		if(ge.resolvable)
		{
			ge.resolvable = false;
			if(!ge.resolve())events.pop();
		}
		else events.pop();
	}
}
