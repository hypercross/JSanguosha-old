package Application.InGame;

import Game.Entity.Entity;
import Game.Entity.PlayerEntity;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerEntityView extends Group{

	PlayerEntity player;
	TextureRegion mask,general;
	
	Table[] props;
	Selectable selectable;
	
	public PlayerEntityView(PlayerEntity pe)
	{
		this.setX(200);
		this.setY(-90);
		selectable = new Selectable(this);
		
		player = pe;
		String general_path = player.child("general") == null ?
				"player/default_general" : ((Entity)player.child("general")).type.fullName();
		general = DefaultSkin.instance.getRegion(general_path);
		mask  = DefaultSkin.instance.getRegion("player/mask");
		this.setWidth(mask.getRegionWidth());
		this.setHeight(mask.getRegionHeight());
	
		props = new Table[3];
		
		props[0] = new CollapsedPropertyView<PlayerEntity>(pe)
		{
			protected Object[] drawnObjects()
			{
				return new Object[]{ DefaultSkin.instance.getRegion("player/magatama"),
						"x" + entity.hp};
			}
		};

		props[1] = new CollapsedPropertyView<PlayerEntity>(pe)
		{
			protected Object[] drawnObjects()
			{
				return new Object[]{ DefaultSkin.instance.getRegion("player/hand"),
						"x" + entity.child("hand").size()};
			}
		};
		
		props[2] = new CollapsedPropertyView<PlayerEntity>(pe)
		{
			protected Object[] drawnObjects()
			{
				return new Object[]{ DefaultSkin.instance.getRegion("player/role")
						};
			}
		};
		
		float y_pos = 90;
		float pad = 30f;
		for(Table prop : props)
		{
			this.addActor(prop);
			prop.setSize(this.getWidth(),30f);
			prop.setPosition(this.getWidth(),y_pos);
			y_pos += pad;
		}
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		batch.enableBlending();
		batch.setColor(1f,1f,1f,1f);
		
		batch.setBlendFunction(GL10.GL_ZERO, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		batch.draw(mask,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());
		
		batch.setBlendFunction(GL10.GL_ONE_MINUS_DST_ALPHA, GL10.GL_ONE);
		
		batch.draw(general,
				this.getX(),
				this.getY(),
				this.getWidth() * this.getScaleX(),
				this.getHeight() * this.getScaleY());

		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		selectable.draw(this,batch,parentAlpha);
	}
}
