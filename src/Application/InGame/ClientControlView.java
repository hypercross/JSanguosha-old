package application.inGame;

import javax.sound.sampled.Control.Type;

import game.ActionSet;
import game.entity.CardEntity;
import game.entity.Entity;
import game.entity.PlayerEntity;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
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
		this.addActor(pev = new PlayerEntityView(pe));
		
		this.addActor(controls = new Table());
		
		for(Entity ce : pe.child("hand"))
		{
			addCards(new CardEntityView((CardEntity) ce));
		}
		
		deployButtons("Confirm", "Cancel");
	}
	
	public void layout()
	{
		controls.setPosition(100,controls.getCells().size() * 20f);
		pev.setPosition(getStage().getWidth() - pev.getWidth(), 0);

		float start = 300;
		float end   = this.getStage().getWidth() - pev.getWidth() - 100;
		float interval = (end - start)/ hand.size;
		
		if(interval > 90)
		{
			start += (interval - 90) * hand.size / 2;
			interval = 90;
		}
		
		for(int i =0;i<hand.size;i++)
			animateTo(hand.get(i), 
					start + interval * i ,
					0);
	}
	
	public void addCards(CardEntityView... cards)
	{
		for(CardEntityView card : cards)
			this.addActor(card);
		hand.addAll(cards);
	}
	
	public void deployButtons(Type... types)
	{
		controls.clear();
		for(Type atype : types)
		{
			controls.add(new Button(new Label(atype.toString(),DefaultSkin.instance), DefaultSkin.instance));
			controls.row();
		}
	}
	
	public void deployButtons(String... types)
	{
		controls.clear();
		for(String atype : types)
		{
			controls.add(new Button(new Label(atype,DefaultSkin.instance), DefaultSkin.instance));
			controls.row();
		}
	}
	
	private void animateTo(Actor actor, float x, float y)
	{
		MoveToAction mta = new MoveToAction();
		mta.setDuration(0.3f);
		mta.setPosition(x, y);
		
		actor.addAction(mta);
	}
}
