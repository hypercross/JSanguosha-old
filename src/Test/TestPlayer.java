package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Game.Action;
import Game.ActionSet;
import Game.IPlayer;
import Game.Type.Type;

public class TestPlayer implements IPlayer{

	Action response;
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
	public  void propose(ActionSet as) {
		System.out.println("Asking " + playerID + " for action:");
		for(Type atype : as.actionTypes())
		{
			System.out.println(atype.fullName() + ": " + atype.description);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(!as.containsWithComposition(response))
			{
				System.out.print("ActionQuery>");
				response = new CommandAction(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Action> T getDecision() {
		return (T) response;
	}

}
