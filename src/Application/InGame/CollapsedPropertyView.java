package Application.InGame;

import Game.Entity.Entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class CollapsedPropertyView <T extends Entity> extends Table{
	
	public T entity;
	public CollapsedPropertyView(T entity)
	{
		this.entity = entity;
		this.left();

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
}
