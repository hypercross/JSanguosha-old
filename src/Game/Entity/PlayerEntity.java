package Game.Entity;

@SuppressWarnings("serial")
public class PlayerEntity extends Entity{

	public int hp, maxHp, seatId, isAlive, playerID;
	
	public PlayerEntity()
	{
		CardSlotEntity entity = new CardSlotEntity();
		entity.viewable = false;
		this.setChild("hand", entity);
	}
}
