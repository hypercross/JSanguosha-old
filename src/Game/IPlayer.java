package Game;

public interface IPlayer {

	public int PlayerId();
	
	public void propose(IActionSet as);
	
	public boolean isReady();
	
	public IAction getDecision();
}
