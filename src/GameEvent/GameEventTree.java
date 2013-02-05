package gameEvent;

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
	
	public String toString(GameEvent ge, int level)
	{
		String display = "";
		for(int i =0;i<level;i++)display+="  ";
		display += ge.toString() + "\n";
		
		for(GameEvent another : ge.children)
			display += toString(another, level+1);
			
		return display;
	}
	
	public String toString()
	{
		return "GameEvent:\n"+toString(root,0);
	}
}