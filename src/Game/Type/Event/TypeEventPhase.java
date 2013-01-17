package Game.Type.Event;

public class TypeEventPhase extends TypeEvent{

	public String toString()
	{
		return "Phase";
	}
	
	public static class TypeEventPhaseDraw extends TypeEventPhase
	{
		public String toString()
		{
			return "Draw";
		}
	}
	
	public static class TypeEventPhasePlay extends TypeEventPhase
	{
		public String toString()
		{
			return "Play";
		}
	}
}
