package game.entity;

import java.util.Collections;

@SuppressWarnings("serial")
public class CardSlotEntity extends Entity{

	public int sizeCap = 0;
	public boolean viewable = true;
	
	public void shuffle()
	{
		Collections.shuffle(this);
	}
}
