package test;

import game.PlayerManager;

public class TestPlayerManager extends PlayerManager{
	public TestPlayerManager()
	{
		size = 2;
		login(new TestPlayer(0));
		login(new TestPlayer(1));
	}
}
