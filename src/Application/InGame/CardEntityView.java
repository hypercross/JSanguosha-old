package application.inGame;

import game.entity.CardEntity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;

public class CardEntityView extends Actor{
	
	CardEntity card ;
	TextureRegion image,glow;
	Selectable select;
	
	Label numberLabel;
	TextureRegion suit;
	
	public CardEntityView(CardEntity ce)
	{
		this.setX(100);
		this.setY(100);
		select = new Selectable(this);
		
		card = ce;
		image = DefaultSkin.instance.getRegion(card.type.fullName());
		select.setTexture(DefaultSkin.instance.getRegion("card/glow"));
		
		numberLabel = new Label(String.valueOf(card.number),DefaultSkin.instance);
		numberLabel.setColor(Color.BLACK);
		
		String suitName = "";
		if(card.suit == 'S')suitName = "card/spade";
		else if(card.suit == 'C')suitName = "card/club";
		else if(card.suit == 'D')suitName = "card/diamond";
		else if(card.suit == 'H')suitName = "card/heart";
		
		suit = DefaultSkin.instance.getRegion(suitName);
		
		this.setWidth(image.getRegionWidth());
		this.setHeight(image.getRegionHeight());
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		batch.enableBlending();

		batch.setColor(1f,1f,1f,1f);
		batch.draw(image,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());
		
		numberLabel.setPosition(this.getX() + this.getWidth() - numberLabel.getPrefWidth() - 7
				,this.getY() + this.getHeight() - numberLabel.getPrefHeight() - 5);
		numberLabel.draw(batch,parentAlpha);
		
		batch.draw(suit,
				numberLabel.getX() - 9,
				numberLabel.getY() - suit.getRegionHeight() + 10);

		select.draw(this, batch, parentAlpha);
	} 
	
	@SuppressWarnings("unused")
	private void scale()
	{

		ScaleToAction sta = new ScaleToAction();
		sta.setDuration(0.1f);
		
		float deltaScale = sta.getX() - getScaleX();
		
		MoveByAction mta = new MoveByAction();
		mta.setDuration(0.1f);
		mta.setAmount( -deltaScale * getWidth()/2,
				-deltaScale * getHeight()/2);
		
		addAction(sta);
		addAction(mta);
	}
}
