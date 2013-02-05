package application.inGame;

import game.entity.Entity;
import game.entity.GameEntity;
import game.entity.PlayerEntity;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class EntityInfoLabel extends Label{
	
	Entity entity;
	public EntityInfoLabel(Entity entity) {
		super("", DefaultSkin.instance, "label");
		this.addListener(new ClickRefreshListener(entity));
		this.entity = entity;
		updateFor(entity);
	}

	public void updateFor(Entity entity)
	{
		if(entity instanceof PlayerEntity)
			updateFor((PlayerEntity)entity);
		else if(entity instanceof GameEntity)
			updateFor((GameEntity)entity);
	}
	
	private void updateFor(PlayerEntity pe)
	{
		String display = "Player\n";
		display += pe.playerID + " at " + pe.seatId + "\n";
		display += pe.isAlive ? "Alive " : "Dead ";
		display += pe.maxHp + "/" + pe.hp + "\n";
		display += list(pe,"hand");
		
		this.setText(display);
		this.pack();
	}
	
	public void update()
	{
		updateFor(entity);
	}
	
	private String list(Entity entity, String name)
	{
		String display = name + ": ==========================\n";
		for(int i = 0;i < entity.child(name).size(); i ++)
			display += entity.child(name).get(i).toString() + "\n";
		
		return display;
	}
	
	private void updateFor(GameEntity ge)
	{
		String display = ge.events.toString();
		this.setText(display + list(ge,"drawDeck") + list(ge,"discardDeck"));
	}
	
	private class ClickRefreshListener extends ClickListener
	{

		protected Entity entity;
		public ClickRefreshListener(Entity entity)
		{
			this.entity = entity;
		}
		
		public void clicked (InputEvent event, float x, float y) {
			updateFor(entity);
		}
		
		
	}
}
