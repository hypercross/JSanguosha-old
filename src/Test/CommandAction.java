package Test;

import java.util.HashMap;

import Game.IAction;
import Game.IEntityContainer;
import Game.Entity.Entity;
import Game.Entity.GameEntity;
import Game.Type.LinkedType;
import Game.Type.Type;

public class CommandAction implements IAction{

	HashMap<String,String> context = new HashMap<String,String>();
	Type type;
	
	public CommandAction(String cmdString)
	{
		parse(cmdString);
	}
	
	private void parse(String cmd)
	{
		String[] words = cmd.split(" +");
		
		boolean first = true;
		for(String word : words)
		{
			if(first)
			{
				first = false;
				this.type = new LinkedType(word,Type.BASE_TYPE);
				continue;
			}
			String[] params = word.split(":") ;
			if(params.length != 2)continue;
			
			context.put(params[0], params[1]);
		}
	}
	
	@Override
	public Type typeDesc() {
		return type;
	}

	@Override
	public Entity getContext(String name, GameEntity ge) {
		
		String[] names = context.get(name).split(".");
		IEntityContainer iec = ge;
		
		for(String aname : names)iec = iec.child(aname);
		
		return (Entity) iec;
	}

	@Override
	public void setContext(String name, Entity something, GameEntity ge) {
		String theName = something.name();
		
		while(something != ge)
		{
			something = (Entity) something.parent();
			theName = something.name() + "." + theName;
		}
		
		context.put(name, theName);
	}

}
