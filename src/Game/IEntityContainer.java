package game;

import java.util.List;

import game.entity.Entity;

public interface IEntityContainer extends List<Entity>{
	
	IEntityContainer parent();
	
	IEntityContainer child(String name);
	
	void setParent(IEntityContainer ec);
	
	void setChild(String name, IEntityContainer ec);
	
	String name();
	
	void setName(String name);
}
