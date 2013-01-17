package Game.Type.Event;

public class TypeEventAction extends TypeEvent{

	public String toString()
	{
		return "Action";
	}
	
	public static class TypeEventActionPlay extends TypeEventAction
	{
		public String toString()
		{
			return "Play";
		}
	}
}
