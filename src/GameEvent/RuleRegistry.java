package gameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RuleRegistry
{	
	private ArrayList<IRule> rules = new ArrayList<IRule>();
	public Comparator<IRule> sorter = new compare_by_entity_hierarchy();
	
	public boolean trigger(GameEvent ge)
	{
		boolean triggered = false;
		if(ge.children.isEmpty())return false;
		
		for(IRule rule : rules)
		{
			triggered |= rule.trigger(ge);
		}
		
		return triggered;
	}
	
	public void register(IRule rule)
	{
		rules.add(rule);
		Collections.sort(rules, sorter);
	}
	
	private class compare_by_entity_hierarchy implements Comparator<IRule>
	{
		// incorrect
		@Override
		public int compare(IRule arg0, IRule arg1) {
			if(arg0.owner().parentOf(arg1.owner()))return -1;
			if(arg1.owner().parentOf(arg0.owner()))return 1;
			return 0;
		}
		
	}
}