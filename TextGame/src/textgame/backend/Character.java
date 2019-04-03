package textgame.backend;


/**
	* Abstract class representing the basic functions and properties for an entity in the game
*/
public abstract class Character
{
	//declare class members 
	private int posX; 
	private int posY;
	
	/**
	* Empty constructor for a character
	*
	* @return A character object with no set class members
	*/
	public Character()
	{
		
	}
	
	/**
	* Constructor to create an object of type character with a specified x and y coordinate
	*
	* @param posX character's x position on the map
	* @param posY character's y position on the map
	*
	* @return An object of character type with a specified x and y coordinate 
	*/
	public Character(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}
	
	
	/**
	* Abstract method to get a character's health
	*
	* @return health character's health class member
	*/
	public abstract int getHealth();
	
	/**
	* Abstract method for attacking that all child classes will implement in different ways 
	*
	* @param target A character type object that the current object will deal damage to
	*/
	public abstract void attack(Character chr1);
	
	
	/**
	* Abstract method to set a character's health
	*
	* @param newHealth players new health value 
	*/
	public abstract void setHealth(int newHealth);
	
	
	/**
	* method to get a character's x position
	*
	* @return character's x position
	*/
	public int getPosX()
	{
		int returnX = this.posX;
        return returnX;
	}
	
	/**
	* method to get an character's y position
	*
	* @return character's x position
	*/
	public int getPosY()
	{
		int returnY = this.posY;
        return returnY;
	}
	
	/**
	* method to assign damage to the character
	*
	* @param dmg amount of health to subtract from the character's health
	*/
	public void takeDamage(int dmg)
	{
		if (dmg >= 0)
		{
			int tempHealth = this.getHealth() - dmg;
		
			if(tempHealth >= 0)
			{
				this.setHealth(tempHealth);
			}
			else
			{
				this.setHealth(0);
			}
		}
	}
	
	/**
	* method to set an enemy's initial position
	*
	* @param x The enemy's x position
	* @param x The enemy's y position 
	*/
	public void setInitPos(int x, int y)
	{
		this.posY = y;
		this.posX = x;
	}
	
	/**
	* setter method to set player's x position on the map
	*
	*/
	public void setX(int x)
	{
		this.posX = x;
	}
	
	/**
	* setter method to set player's y position on the map
	*
	*/
	public void setY(int y)
	{
		this.posY = y;
	}

}