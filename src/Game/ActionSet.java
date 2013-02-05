package game;

import game.type.Type;
import test.CardDodge;
import test.CardSlash;
import test.action.ActionPlay;

public abstract class ActionSet {
	
	private ActionSet includes,excludes;
	private Filter filter;

	public <T extends Action> boolean contains(T action)
	{
		return true;
	}
	
	public abstract Type[] actionTypes();
	
	public void include(ActionSet anotherSet)
	{
		includes = anotherSet;
	}
	
	public void exclude(ActionSet anotherSet)
	{
		excludes = anotherSet;
	}
	
	public boolean containsWithComposition(Action action)
	{
		if(excludes != null && excludes.contains(action))return false;
		if(includes != null && includes.contains(action))return true;
		return contains(action);
	}
	
	public Filter getFilter()
	{
		if(this.filter == null)
			filter = new Filter();
		
		return filter;
	}
	
	
	public static class Filter
	{
		private Filter a,b;
		private byte operation = -1;
		
		private Filter(Filter a, Filter b, byte operation)
		{
			this.a = a;
			this.b = b;
			this.operation = operation;
		}
		
		public Filter and(Filter other)
		{
			return new Filter(this,other, (byte) 0);
		}
		
		public Filter or(Filter other)
		{
			return new Filter(this, other, (byte) 1);
		}
		
		public Filter then(Filter other)
		{
			return new Filter(this, other, (byte) 2);
		}
		
		public <T extends Action> boolean check(T action)
		{
			return true;
		}
		
		public boolean checkAll(Action action)
		{
			boolean resultA = false,resultB = false;
			if(a != null) resultA = a.checkAll(action);
			if(b != null) resultB = b.checkAll(action);
			
			switch(operation)
			{
			case 0:
				return resultA && resultB;
			case 1:
				return resultA || resultB;
			case 2:
				return (resultA ? resultB : true);
			default:
				return check(action);
			}
		}
		
		public Filter(){};
	}
	
	public static class TypeFilter extends Filter
	{
		Type type;
		
		@Override
		public boolean check(Action action)
		{
			if(action instanceof ActionPlay)
			{
				ActionPlay thePlay = (ActionPlay)action;
				return thePlay.card.is(type);
			}
			return false;
		}
		
		public TypeFilter(Type type)
		{
			this.type = type;
		}
	}
	
	public static Filter TARGET_SINGLE = new Filter()
	{
		@Override
		public boolean check(Action action)
		{
			if(action instanceof ActionPlay)
			{
				ActionPlay thePlay = (ActionPlay)action;
				return thePlay.targets.length == 1;
			}
			return false;
		}
	};
	
	public static Filter TARGET_NONE = new Filter()
	{
		@Override
		public boolean check(Action action)
		{
			if(action instanceof ActionPlay)
			{
				ActionPlay thePlay = (ActionPlay)action;
				return thePlay.targets.length == 0;
			}
			return false;
		}
	};
	
	public static Filter CARDIS_SLASH = new TypeFilter(CardSlash.typeCardSlash);
	public static Filter CARDIS_DODGE = new TypeFilter(CardDodge.typeDodge);
}
