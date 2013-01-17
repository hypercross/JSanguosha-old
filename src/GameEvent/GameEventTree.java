package GameEvent;

public class GameEventTree
{
	private GameEvent root;
	
	public void setRoot(GameEvent ge)
	{
		root = ge;
	}
	
	public GameEvent peek()
	{
		GameEvent ge = root;
		while(!ge.children.isEmpty())
			ge = ge.children.get(0);
		
		return ge;
	}
	
	public GameEvent pop()
	{
		GameEvent ge = peek();
		ge.parent.children.remove(ge);
		return ge;
	}
}