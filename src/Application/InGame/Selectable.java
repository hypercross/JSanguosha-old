package Application.InGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Selectable{

	public ClickListener clickListener;
	public boolean isSelected = false;
	
	private float r=1f,g=1f,b=1f;
	private TextureRegion glow;
	private float intensity = 0f;
	
	private static int DURATION = 300;
	private static float OPACITY = 0.3f;
	
	public Selectable(Actor actor)
	{
		actor.addListener(clickListener = new ClickListener()
		{
			public void clicked (InputEvent event, float x, float y) {
				if(event.isHandled())return;
					isSelected = !isSelected;
			}
		});
	}
	
	public void setColor(float r,float g,float b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void draw (Actor actor, SpriteBatch batch, float parentAlpha) {
		float delta = Gdx.graphics.getDeltaTime();
		
		if(isSelected || clickListener.isOver())
		{
			intensity += delta * 1000f/ DURATION;
			if(intensity>1f)intensity = 1f;
		}else
		{
			intensity -= delta * 1000f / DURATION;
			if(intensity<0f)intensity = 0f;
		}
		
		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
		glow = DefaultSkin.instance.getRegion("glow");
		batch.setColor(r,g,b, OPACITY * intensity);
		batch.draw(glow,
				actor.getX(),
				actor.getY(),
				actor.getWidth(),
				actor.getHeight());
		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}

}
