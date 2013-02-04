package Application.InGame;

import Game.Entity.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class CollapsedPropertyView <T extends Entity> extends Table{
	
	public T entity;
	public Selectable sel;
	
	public CollapsedPropertyView(T entity)
	{
		this.entity = entity;
		this.left();
		this.sel = new Selectable(this);

		Object[] objects = drawnObjects();
		
		for(Object obj : objects)
		{
			if(obj instanceof String)
			{
				this.add(new Label((String)obj, DefaultSkin.instance));
			}else if(obj instanceof TextureRegion)
			{
				this.add(new Image((TextureRegion)obj));
			}
		}
	}

	protected abstract Object[] drawnObjects();
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
//		batch.draw(DefaultSkin.instance.getRegion("state"),
//				this.getX(),
//				this.getY(),
//				this.getWidth() * this.getScaleX(),
//				this.getHeight() * this.getScaleY());
		sel.draw(this, batch, parentAlpha);
	}
}
