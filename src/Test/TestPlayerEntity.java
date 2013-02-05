package test;

import game.entity.CardEntity;
import game.entity.PlayerEntity;

@SuppressWarnings("serial")
public class TestPlayerEntity extends PlayerEntity{

	public TestPlayerEntity()
	{
		super();
		
		this.hp = this.maxHp = 4;
		this.child("hand").add(new CardEntity(0, 1, 'S', new CardSlash()));
		this.child("hand").add(new CardEntity(0, 2, 'S', new CardSlash()));
		this.child("hand").add(new CardEntity(0, 3, 'S', new CardDodge()));
	}
	
}
