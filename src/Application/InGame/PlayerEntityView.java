package Application.InGame;

import Game.Entity.Entity;
import Game.Entity.PlayerEntity;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerEntityView extends Actor{

	PlayerEntity player;
	TextureRegion mask,general;
	
	public PlayerEntityView(PlayerEntity pe)
	{
		this.setX(200);
		this.setY(-90);
		
		player = pe;
		String general_path = player.child("general") == null ?
				"default_general" : ((Entity)player.child("general")).type.fullName();
		general = DefaultSkin.instance.getRegion(general_path);
		mask  = DefaultSkin.instance.getRegion("character_mask");
		this.setWidth(mask.getRegionWidth());
		this.setHeight(mask.getRegionHeight());
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		batch.enableBlending();
		batch.setColor(1f,1f,1f,1f);
		
		batch.draw(mask,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());
		
		batch.setBlendFunction(GL10.GL_ONE_MINUS_DST_COLOR, GL10.GL_ZERO);
		
		batch.draw(general,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());
		
		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}
}
