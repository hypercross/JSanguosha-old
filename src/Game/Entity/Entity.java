package game.entity;

import java.util.ArrayList;
import java.util.HashMap;

import game.IEntityContainer;
import game.type.Type;

@SuppressWarnings("serial")
public class Entity extends ArrayList<Entity> implements IEntityContainer{
	
	IEntityContainer parent;
	HashMap<String,IEntityContainer> children = new  HashMap<String,IEntityContainer>(); 
	public Type type = Type.BASE_TYPE;
	public String name = "";

	@Override
	public IEntityContainer parent() {
		return parent;
	}

	@Override
	public IEntityContainer child(String name) {
		if(children.containsKey(name))
			return children.get(name);
		
		return null;
	}

	@Override
	public void setParent(IEntityContainer ec) {
		parent = ec;
		if(ec.child(this.name) == null)
			ec.setChild(this.name, this);
	}

	@Override
	public void setChild(String name, IEntityContainer ec) {
		if(ec == null)
		{
			children.remove(name);
			return;
		}
		
		ec.setName(name);
		children.put(name, ec);
		ec.setParent(this);
	}

	public boolean is(Type td)
	{
		return(this.type.is(td));
	}
	
	public boolean isKindOf(Entity entity)
	{
		return type.is(entity.type);
	}
	
	public boolean parentOf(Entity entity)
	{
		IEntityContainer parent = entity.parent();
		while(parent != null && parent != this)parent = parent.parent();
		
		return parent == this;
	}
	
	public Entity(Type td)
	{
		this.type = td;
	}
	
	public Entity()
	{}
	
	public String name()
	{
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name; 
	}
	
	public GameEntity root()
	{
		IEntityContainer parent = this;
		while(parent.parent() != null)parent = parent.parent();
		
		if(parent instanceof GameEntity)
			return (GameEntity)parent;
		
		return null;
			
	}
}
