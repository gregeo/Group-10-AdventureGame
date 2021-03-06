/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame.backend;

/**
 * A child class from abstract character class used to represent an enemy in a room for a player to fight 
 *
 * 
 */
public class Enemy extends Character
{
	
	//declare class members
    private int health;
    private int posX;
    private int posY;

	/**
	* Copy constructor to create a copy object of another enemy 
	*
	* @param enemyToCopy enemy object to make a copy of
	*/
	public Enemy(Enemy enemyToCopy)
	{
		this.health = enemyToCopy.health;
	}
	
	/**
	* Constructor to create a new enemy object with a specified health value
	*
	* @param health enemy's health
	*/
	public Enemy(int health)
	{	
		this.health = health;
	}
	
	/**
	* Constructor to create a new enemy object with a specified x and y coordinate
	*
	* @param posX enemy's x position on the map
	* @param posY enemy's y position on the map 
	*/
	public Enemy(int posX, int posY)
	{
		super(posX, posY);
		setRandomHealth();
		//setInitPos(posX, posY);
		
	}

	/**
	* method to set an enemy's intial health
	*
	*/
    public void setRandomHealth()
	{
        double randomHealth = Math.random();
		randomHealth = randomHealth * 6 + 1;
		int newHealth = (int)randomHealth;
		this.health = newHealth;
    }
	
	/**
	* method to set an enemy's initial health with a specified argument as opposed to creating a random value
	*
	* @param health enemy's health
	*/
    @Override
	public void setHealth(int health)
	{
		this.health = health;
	}


	/**
	* method to get an enemy's health
	*
	* @return enemy's health 
	*/
    @Override
    public int getHealth() 
	{
        int tempHealth = this.health;
        return tempHealth;
    }


	/**
	* Method to carry out the enemy's attack
	*
	* @param target The player object that damage will be assigned to 
	*/
    @Override
    public void attack(Character target) 
	{
		//generate a random number between 1 and 3 for the enemy's attack strenght and call the target's takeDamage method sending this random number 
        double randomAttack = Math.random();
		randomAttack = randomAttack * 3 + 1;
		int attackStrength = (int)randomAttack;
		System.out.println("Enemies attack Strength: " + attackStrength);
		target.takeDamage(attackStrength);
    }
	
	/**
	* toString method for enemy's information
	*
	* @return methodReturn enemy's information (position and health)
	*/
    @Override
    public String toString()
	{
		int tempHealth = this.health;
        int tempPosX = this.posX;
        int tempPosY = this.posY;
        String healthOut = Integer.toString(tempHealth);
        String posXOut = Integer.toString(tempPosX);
        String posYOut = Integer.toString(tempPosY);
        String methodReturn = "Enemy information (health, x, y): (" + healthOut + ";" + posXOut + ";" + posYOut + ")";
        return methodReturn;
    }
}
