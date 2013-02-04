package Application.InGame;

import Game.ActionSet;
import Game.Entity.PlayerEntity;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

public class ClientControlView extends Group{

	PlayerEntityView pev;
	Array<CardEntityView> hand = new Array<CardEntityView>();
	Table controls;
	
	ActionSet request;
	
	public ClientControlView(PlayerEntity pe)
	{
		this.setPosition(100,500);
		
		this.addActor(pev = new PlayerEntityView(pe));
		
		this.addActor(controls = new Table());
		controls.add(new Button(new Label("Confirm",DefaultSkin.instance), DefaultSkin.instance));
	}
	
	
}
