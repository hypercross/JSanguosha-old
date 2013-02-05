package game;

public interface IPlayer {

	public int PlayerId();
	
	public void propose(ActionSet as);
	
	public boolean isReady();
	
	public <T extends Action> T getDecision();
}
