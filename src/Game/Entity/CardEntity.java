package game.entity;

import game.ICard;

@SuppressWarnings("serial")
public class CardEntity extends Entity{

	public int cardID;	// id in the environment
	public int number;	// poker number
	public char suit;	// poker suit
	public CardSlotEntity container;
	public ICard prototype;
	
	public CardEntity(int cardID, int number, char suit, ICard prototype)
	{
		this.cardID = cardID;
		this.number = number;
		this.suit = suit;
		
		this.prototype = prototype;
		this.type = prototype.cardType();
		this.name = type.toString();
	}
	
	public String toString()
	{
		return this.type.toString() + " " + number + ":" + suit + " " + cardID;
	}
}
