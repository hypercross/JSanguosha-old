package Game;

import Game.Type.Type;

public interface IActionSet {

	boolean contains(IAction action);
	
	void include(IActionSet anotherSet);
	
	void exclude(IActionSet anotherSet);
	
	Type[] actionTypes();
}
