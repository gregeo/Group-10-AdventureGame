
package textgame;


/**
 * Class representing the boss which inherits from the Enemy class 
 * Runs all of the attack and taking damage functions for the boss
 * 
 */
 
public class Boss extends Enemy
{
	//declare class members
	private int attackStrength;
	
	/**
	* Copy Constructor to create a new boss object
	*
	* @param bossToCopy boss object to copy
	*
	* @return A new copied boss object
	*/
	public Boss(Boss bossToCopy)
	{
		//call parent class to initialize parameters 
		super(bossToCopy);
		this.attackStrength = bossToCopy.attackStrength;
	}
	
	/**
	* Constructor to create a new enemy object with a specified health and attack strength
	*
	* @param health boss's health
	* @param attackStrength boss's attack strength 
	*
	* @return A new enemy object with a specified health and attack strength
	*/
	public Boss(int health, int attackStrength)
	{
		//call parent class to initialize health
		super(health);
		setAttackStrength(15);
		
	}
	
	/**
	* setter method to set the boss's attack strength
	*
	*/
	public void setAttackStrength(int attackStrength)
	{
		this.attackStrength = attackStrength;
	}
	
	/**
	* method to get the boss's attack strength based on it's health value
	*
	* @return the boss's attack strength based on it's health value
	*/
	public int getAttackStrength()
	{
		
		/*
			if the boss's health is between 10 and 15 his attackStrength is 15
			if the boss's health is between 5 and 10 his attackStrength is 10
			if the boss's health is between 1 and 5 his attackStrength is 5
			
		*/
		if(this.getHealth() >= 10 && this.getHealth() <= 15)
		{
			setAttackStrength(15);
			return this.attackStrength;
		}
		if(this.getHealth() >= 5 && this.getHealth() < 10)
		{
			setAttackStrength(10);
			return this.attackStrength;
		}
		if(this.getHealth() >= 0 && this.getHealth() < 5)
		{
			setAttackStrength(5);
			return this.attackStrength;
		}
		else
		{
			return this.attackStrength;
		}
	}

	/**
	* method to assign damage to the boss
	*
	* @param dmg the damage to be taken away from the boss's health
	*/
	public void takeDamage(int dmg) 
	{
		//if the damage is positive and the tempHealth is not negative or 0 set tempHealth to be the new health
		//else the boss is dead and set health to 0
        if (dmg >= 0) 
		{
            int tempHealth = this.getHealth() - dmg;
			if(tempHealth >= 0)
			{
				this.setNonRandomHealth(tempHealth);
			}
			else
			{
				this.setNonRandomHealth(0);
			}
        }
    }

	/**
	* overridden toString method to print the boss's information
	*
	* @return a single string value with all of the information associated with boss
	*/
	public String toString(){
		int tempHealth = this.getHealth();
		int tempAttackStrength = getAttackStrength();
        String health = Integer.toString(tempHealth);
        String attackStrength = Integer.toString(tempAttackStrength);
        String methodReturn = "Boss information (health, attackStrength): (" + health + ";" + attackStrength + ")";
        return methodReturn;
    }
	
	/**
	* method to carry out the boss's attack
	*
	* @param target the player the boss will assign damage to 
	*/
	public void attack(Player target)
	{
		//get the boss's attack strenght and call the player's takeDamage method to assign this damage
		int attack = this.getAttackStrength();
		System.out.println("Boss attack Strength: " + attackStrength);
		target.takeDamage(attackStrength);
    }
}
