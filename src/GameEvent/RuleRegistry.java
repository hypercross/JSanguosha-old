package GameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RuleRegistry
{
	public static RuleRegistry instance;
	
	private ArrayList<IRule> rules;
	public Comparator<IRule> sorter;
	
	public boolean trigger(GameEvent ge)
	{
		boolean triggered = false;
		if(ge.children.isEmpty())return false;
		
		for(IRule rule : rules)
		{
			GameEvent childEvent = rule.trigger(ge);
			if(childEvent != null)
			{
				triggered = true;
				ge.attach(childEvent);
			}
		}
		
		return triggered;
	}
	
	public void register(IRule rule)
	{
		rules.add(rule);
		Collections.sort(rules, sorter);
	}
}