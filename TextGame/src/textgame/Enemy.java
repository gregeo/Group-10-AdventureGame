/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.lang.Math;

/**
 * A class used to represent an enemy in a room for a player to fight
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
	*
	* @return A copy of an enemy object
	*/
	public Enemy(Enemy enemyToCopy)
	{
		this.health = enemyToCopy.health;
	}
	
	/**
	* Constructor to create a new enemy object with a specified health value
	*
	* @param health enemy's health
	*
	* @return A new enemy object with a specified health
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
	*
	* @return A new enemy object with a specified x and y coordinate 
	*/
	public Enemy(int posX, int posY)
	{
		super(posX, posY);
		setHealth();
		//setInitPos(posX, posY);
		
	}
	
	/**
	* method to set an enemy's initial position
	*
	* @param x The enemy's x position
	* @param x The enemy's y position 
	*/
    public void setInitPos(int x, int y) 
	{
        this.posX = x;
        this.posY = y;
    }
	/**
	* method to set an enemy's intial health
	*
	*/
    public void setHealth()
	{
        double randomHealth = Math.random();
		randomHealth = randomHealth * 6 + 1;
		int health = (int)randomHealth;
		this.health = health;
    }
	
	/**
	* method to set an enemy's initial health with a specified argument as opposed to creating a random value
	*
	* @param health enemy's health
	*/
	public void setNonRandomHealth(int health)
	{
		this.health = health;
	}

	/**
	* method to get an enemy's x position
	*
	* @return enemy's x position
	*/
    public int getPosX()
	{
        int tempPosX = this.posX;
        return tempPosX;
    }

	/**
	* method to get an enemy's y position
	*
	* @return enemy's x position
	*/
    public int getPosY() 
	{
        int tempPosY = this.posY;
        return tempPosY;
    }

	/**
	* method to get an enemy's health
	*
	* @return enemy's health 
	*/
    public int getHealth() 
	{
        int tempHealth = this.health;
        return tempHealth;
    }

	/**
	* method to assign damage to enemy
	*
	* @param dmg amount of health to subtract from the enemy's health
	*/
    public void takeDamage(int dmg) 
	{
		
		//if the tempHealth is not negative, set that to be the new health of the enemy
		//else the tempHealth is negative enemy is dead and is set to 0
        if (dmg >= 0) {
            int tempHealth = this.health - dmg;
			
			if(tempHealth >= 0)
			{
				this.health = tempHealth;
			}
			else
			{
				this.health = 0;
			}
        }
    }

	/**
	* Method to carry out the enemy's attack
	*
	* @param target The player object that damage will be assigned to 
	*/
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
    public String toString()
	{
		int tempHealth = this.health;
        int tempPosX = this.posX;
        int tempPosY = this.posY;
        String health = Integer.toString(tempHealth);
        String posX = Integer.toString(tempPosX);
        String posY = Integer.toString(tempPosY);
        String methodReturn = "Enemy information (health, x, y): (" + health + ";" + posX + ";" + posY + ")";
        return methodReturn;
    }
}
