package game.entity;

@SuppressWarnings("serial")
public class PlayerEntity extends Entity{

	public int hp, maxHp, seatId, playerID;
	public boolean isAlive;
	
	public PlayerEntity()
	{
		CardSlotEntity entity = new CardSlotEntity();
		entity.viewable = false;
		this.setChild("hand", entity);
	}
}
