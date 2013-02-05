package game.type;

public class LinkedType extends Type {
	Type parent;
	String name;
	
	public LinkedType(String name, Type parent)
	{
		this.parent = parent;
		this.name   = name;
	}
	
	public String toString()
	{
		return name;
	}
	
	public String fullName()
	{
		return parent.fullName() + "." + name;
	}
}
