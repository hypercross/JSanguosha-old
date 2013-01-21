package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Game.IAction;
import Game.IActionSet;
import Game.IPlayer;
import Game.Type.Type;

public class TestPlayer implements IPlayer{

	IAction response;
	int playerID = 0;
	
	public TestPlayer(int id)
	{
		playerID = id;
	}
	
	@Override
	public int PlayerId() {
		return playerID;
	}

	@Override
	public void propose(IActionSet as) {
		System.out.println("Asking " + playerID + " for action:");
		for(Type atype : as.actionTypes())
		{
			System.out.println(atype.fullName() + ": " + atype.description);
		}
			
		System.out.print("ActionQuery>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			response = new CommandAction(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public IAction getDecision() {
		return response;
	}

}
