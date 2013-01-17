package Game.Type;

public class Type {

	public static Type BASE_TYPE = new Type();
	public static Type CARD_SLOT = new TypeCardSlot();
	public static Type CARD = new TypeCard();
	public static Type PLAYER = new TypePlayer();
	public static Type GAME = new TypeGame();
	
	public String toString()
	{
		return "Type";
	}
	
	public String fullName()
	{
		String result = "";
		if(this.getClass().getSuperclass() != null)
			result += this.getClass().getSuperclass().cast(this).toString() + ".";
		
		result += toString();
		
		return result;
	}
	
	public boolean parentOf(Type td)
	{
		return fullName().startsWith(td.fullName());
	}
	
	public boolean is(Type td)
	{
		return td.parentOf(this);
	}
}
