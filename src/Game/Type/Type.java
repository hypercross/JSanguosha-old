package game.type;

public class Type {

	public static Type BASE_TYPE = new Type();
	
	public static Type CARD = new LinkedType("Card",BASE_TYPE);
	
	public static Type CARD_GENERAL = new LinkedType("General",CARD);
	public static Type CARD_ROLE = new LinkedType("Role",CARD);
	public static Type CARD_GAME = new LinkedType("Game",CARD);
	
	public static Type EVENT = new LinkedType("Event",BASE_TYPE);
	
	public static Type EVENT_PHRASE = new LinkedType("Phrase",EVENT);
	public static Type EVENT_ENTITY = new LinkedType("Entity",EVENT);
	
	public static Type EVENT_DECISION = new LinkedType("Decision",EVENT);
	public static Type EVENT_DECISION_IDLE = new LinkedType("Idle",EVENT_DECISION);
	
	public static Type ENTITY = new LinkedType("Entity",BASE_TYPE);
	
	public static Type ENTITY_GAME = new LinkedType("Game",ENTITY);
	public static Type ENTITY_CARD = new LinkedType("Card",ENTITY);
	public static Type ENTITY_PLAYER = new LinkedType("Player",ENTITY);
	public static Type ENTITY_SLOT = new LinkedType("Slot",ENTITY);
	
	
	public String toString()
	{
		return "Type";
	}
	
	public String fullName()
	{
		return toString();
	}
	
	public boolean parentOf(Type td)
	{
		return fullName().startsWith(td.fullName());
	}
	
	public boolean is(Type td)
	{
		return td.parentOf(this);
	}
	
	public String description = "";
}
