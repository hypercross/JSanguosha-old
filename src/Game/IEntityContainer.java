package Game;

import java.util.List;

import Game.Entity.Entity;

public interface IEntityContainer extends List<Entity>{
	
	IEntityContainer parent();
	
	IEntityContainer child(String name);
	
	void setParent(IEntityContainer ec);
	
	void setChild(String name, IEntityContainer ec);
}
