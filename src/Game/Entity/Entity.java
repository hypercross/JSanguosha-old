package Game.Entity;

import java.util.ArrayList;
import java.util.HashMap;

import Game.IEntityContainer;
import Game.Type.Type;

@SuppressWarnings("serial")
public class Entity extends ArrayList<Entity> implements IEntityContainer{
	
	IEntityContainer parent;
	HashMap<String,IEntityContainer> children = new  HashMap<String,IEntityContainer>(); 
	public Type type = Type.BASE_TYPE;

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
	}

	@Override
	public void setChild(String name, IEntityContainer ec) {
		children.put(name, ec);
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
}
