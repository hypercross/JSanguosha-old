package Application.InGame;

import Game.Entity.CardEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;

public class CardEntityView extends Actor{
	
	CardEntity card ;
	TextureRegion image,glow;
	ClickListener cl;
	
	public boolean isSelected;
	
	public CardEntityView(CardEntity ce)
	{
		this.setX(100);
		this.setY(100);
		
		card = ce;
		image = DefaultSkin.instance.getRegion(card.type.fullName());
		glow  = DefaultSkin.instance.getRegion("card/glow");
		
		this.addListener(cl = new ClickListener()
		{
			public void clicked (InputEvent event, float x, float y) {
				isSelected = !isSelected;
			}
		});
		this.setWidth(image.getRegionWidth());
		this.setHeight(image.getRegionHeight());
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		batch.enableBlending();
		
		if(cl.isOver() || isSelected)batch.setColor(1f, 1f, 1f, 1f);
		else batch.setColor(.5f, .5f, .5f, 1f);

		batch.draw(image,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());
		
		if(this.isSelected)
		{	
			batch.draw(glow,
					this.getX(),
					this.getY(),
					this.getWidth() * this.getScaleX(),
					this.getHeight() * this.getScaleY());
			
		}
	} 
	
	@SuppressWarnings("unused")
	private void scale()
	{

		ScaleToAction sta = new ScaleToAction();
		sta.setDuration(0.1f);
		sta.setScale(isSelected ? 1.024f : 1.0f);
		
		float deltaScale = sta.getX() - getScaleX();
		
		MoveByAction mta = new MoveByAction();
		mta.setDuration(0.1f);
		mta.setAmount( -deltaScale * getWidth()/2,
				-deltaScale * getHeight()/2);
		
		addAction(sta);
		addAction(mta);
	}
}
