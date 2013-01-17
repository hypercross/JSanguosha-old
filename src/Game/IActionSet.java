package Game;

public interface IActionSet {

	boolean contains(IAction action);
	
	void include(IActionSet anotherSet);
	
	void exclude(IActionSet anotherSet);
	
}
