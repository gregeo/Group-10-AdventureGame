package textgame;

public abstract class Character
{
	private int posX; 
	private int posY;
	
	public Character()
	{
		
	}
	public Character(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}
	public abstract int getHealth();
	
	public abstract void attack(Character chr1);
	
	public abstract void setHealth(int tempHealth);
	
	
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